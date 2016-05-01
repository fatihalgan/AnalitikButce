import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.Key;

import javax.crypto.Mac;

public class Hasher {
	public static boolean activate(File directory) {
		boolean flag = true;
		try {
			FileOutputStream fos = new FileOutputStream(directory.getPath()+"/key.iyte");
			Mac mac = Mac.getInstance("HmacSHA1");

			mac.init((Key)KeyUtility.reconstituteKey("408IelQfywjWwgvZx2IH0EmUmATWKYNt"));

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			String licenceId = "318790925467791325509724675961";
			String hddSerialNumber = new HDSerialNumberReader().getHDSerialNumber();

			byte buf[] = licenceId.getBytes();
			mac.update(buf);
			buf = hddSerialNumber.getBytes();
			mac.update(buf);

			String temp = new sun.misc.BASE64Encoder().encodeBuffer(mac.doFinal());
			System.out.println(temp);
			oos.writeObject(temp);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
}
