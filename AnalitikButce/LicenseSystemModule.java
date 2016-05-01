import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.iztek.abutce.controller.GuiController;

/*
 * Created on 11.Eki.2004
 */

/**
 * @author Selim
 *
 */
public class LicenseSystemModule {
	
	public static String normalizeString(String original){
		String normalized = null;
		try {
			normalized = new sun.misc.BASE64Encoder().encodeBuffer(original.getBytes("UTF-8"));
			normalized = normalized.replace('/','a');
			normalized = normalized.replace('I','q');
			normalized = normalized.replace('ý','p');
		} catch (UnsupportedEncodingException e) {
			System.out.println("Encoding not supported");
			e.printStackTrace();
		}
		
		return normalized.substring(0,25).toLowerCase();
	}
	
	public static String getAuthenticationCode(String belediyeKodu){
		String authenticationCode = null;
		String serial = new HDSerialNumberReader().getHDSerialNumber();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Algorithm not recognized");
			e.printStackTrace();
		}
		md.update(serial.getBytes());
		md.update(belediyeKodu.getBytes());
		authenticationCode = new sun.misc.BASE64Encoder().encodeBuffer(md.digest());
		String normalized = normalizeString(authenticationCode);
		
		return normalized;
	}
	
	public static String getAuthorizationCode(String authenticationCode,String belediyeKodu){
		String authorizationCode = null;
		String serial = new HDSerialNumberReader().getHDSerialNumber();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Algorithm not recognized");
			e.printStackTrace();
		}
		md.update(authenticationCode.getBytes());
		md.update(belediyeKodu.getBytes());
		authorizationCode = new sun.misc.BASE64Encoder().encodeBuffer(md.digest());
		String normalized = normalizeString(authorizationCode);
		
		return normalized;
	}
	
	public static boolean compareAuthorizationCode(String receivedCode,String belediyeKodu){
		String localCode = getAuthorizationCode(getAuthenticationCode(belediyeKodu).substring(0,10),belediyeKodu);
		localCode = localCode.substring(0,10);
		if (receivedCode.equals(localCode)){
			GuiController.getInstance().showAButceFrame();
			return true;
		}
		return false;
	}
}
