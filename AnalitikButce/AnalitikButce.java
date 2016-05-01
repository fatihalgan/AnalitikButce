import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

public class AnalitikButce {

	public static void main(String[] args) {
		String belediyeKodu = null;
		String code = null;
		boolean licensed = false;
		Object[] options = new Object[] {"Tamam"};
		Object o = new Object();
		try {
			FileInputStream fis = new FileInputStream("./key.iyte");
			ObjectInputStream ois = new ObjectInputStream(fis);
			code = (String) ois.readObject();
			ois.close();
			fis.close();
			fis = new FileInputStream("./code.iyte");
			ois = new ObjectInputStream(fis);
			belediyeKodu = (String) ois.readObject();
			ois.close();
			fis.close();
			licensed = LicenseSystemModule.compareAuthorizationCode(code,belediyeKodu);
		} catch (FileNotFoundException e) {
			runLicenseManager();
		} catch (IOException e) {
		      JOptionPane.showMessageDialog(
		            null, "Yazma/Okuma iþlemi sýrasýnda bir hata oluþtu", "HATA!",
		            JOptionPane.INFORMATION_MESSAGE );
		} catch (ClassNotFoundException e) {
		      JOptionPane.showMessageDialog(
		            null, "Gerekli sýnýf bulunamadý", "HATA!",
		            JOptionPane.INFORMATION_MESSAGE );

		}
		
		//if(licensed) GuiController.getInstance().showAButceFrame();
	}

	/**
	 * 
	 */
	private static void runLicenseManager() {
		LicenseManagerGUI licenseManager = new LicenseManagerGUI();
		licenseManager.show();
	}
}