import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Created on 11.Eki.2004
 */

/**
 * @author Selim
 *
 */
public class LicenseManagerGUI extends JFrame {

	private javax.swing.JPanel jContentPane = null;

	private javax.swing.JTextField authorization_field_1 = null;
	private javax.swing.JTextField authorization_field_2 = null;
	private javax.swing.JLabel jLabel = null;
	private javax.swing.JTextField authentication_field_1 = null;
	private javax.swing.JTextField authentication_field_2 = null;
	private javax.swing.JLabel jLabel1 = null;
	private javax.swing.JButton jButton = null;
	private javax.swing.JButton jButton1 = null;
	private javax.swing.JLabel jLabel2 = null;
	private javax.swing.JTextField belediye_field = null;
	public static void main(String[] args) {
		LicenseManagerGUI lm = new LicenseManagerGUI();
		lm.show();
	}
	/**
	 * This is the default constructor
	 */
	public LicenseManagerGUI() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(243, 350);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screenSize.width-243)/2, (screenSize.height-350)/2, 243, 350);
		this.setContentPane(getJContentPane());
		this.setTitle("Lisans Modülü");
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(null);
			jContentPane.setPreferredSize(new java.awt.Dimension(243,350));
			jContentPane.setMaximumSize(new java.awt.Dimension(243,350));
			jContentPane.add(getAuthorization_field_1(), null);
			jContentPane.add(getAuthorization_field_2(), null);
			jContentPane.add(getJLabel(), null);
			jContentPane.add(getAuthentication_field_1(), null);
			jContentPane.add(getAuthentication_field_2(), null);
			jContentPane.add(getJLabel1(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJLabel2(), null);
			jContentPane.add(getBelediye_field(), null);
		}
		return jContentPane;
	}
	/**
	 * This method initializes authorization_field_1
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getAuthorization_field_1() {
		if(authorization_field_1 == null) {
			authorization_field_1 = new javax.swing.JTextField();
			authorization_field_1.setBounds(13, 260, 99, 30);
		}
		return authorization_field_1;
	}
	/**
	 * This method initializes authorization_field_2
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getAuthorization_field_2() {
		if(authorization_field_2 == null) {
			authorization_field_2 = new javax.swing.JTextField();
			authorization_field_2.setBounds(125, 260, 99, 30);
		}
		return authorization_field_2;
	}
	/**
	 * This method initializes jLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel() {
		if(jLabel == null) {
			jLabel = new javax.swing.JLabel();
			jLabel.setBounds(16, 202, 90, 30);
			jLabel.setText("Program Kodu");
		}
		return jLabel;
	}
	/**
	 * This method initializes authentication_field_1
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getAuthentication_field_1() {
		if(authentication_field_1 == null) {
			authentication_field_1 = new javax.swing.JTextField();
			authentication_field_1.setBounds(13, 144, 99, 30);
			authentication_field_1.setEnabled(false);
		}
		return authentication_field_1;
	}
	/**
	 * This method initializes authentication_field_2
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getAuthentication_field_2() {
		if(authentication_field_2 == null) {
			authentication_field_2 = new javax.swing.JTextField();
			authentication_field_2.setBounds(125, 144, 99, 30);
			authentication_field_2.setEnabled(false);
		}
		return authentication_field_2;
	}
	/**
	 * This method initializes jLabel1
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new javax.swing.JLabel();
			jLabel1.setBounds(16, 86, 90, 30);
			jLabel1.setText("Pin Kodu");
		}
		return jLabel1;
	}
	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton() {
		if(jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setBounds(134, 86, 80, 30);
			jButton.setText("Hesapla");
			jButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String belediyeKodu = belediye_field.getText();     
					String authenticationCode = LicenseSystemModule.getAuthenticationCode(belediyeKodu);
					System.out.println(authenticationCode);
					authentication_field_1.setText(authenticationCode.substring(0,5));
					authentication_field_2.setText(authenticationCode.substring(5,10));
				}
			});
		}
		return jButton;
	}
	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new javax.swing.JButton();
			jButton1.setBounds(134, 202, 80, 30);
			jButton1.setText("Onayla");
			jButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String belediyeKodu = belediye_field.getText();    
					String authorizationCode = authorization_field_1.getText() + authorization_field_2.getText();
					boolean correctCode = LicenseSystemModule.compareAuthorizationCode(authorizationCode,belediyeKodu);
					//System.out.println(correctCode);
					if(correctCode){
						JOptionPane.showMessageDialog(null,"Aktivasyon baþarýlý!","",JOptionPane.INFORMATION_MESSAGE);
						try {
							FileOutputStream fos = new FileOutputStream("./key.iyte");
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(authorizationCode);
							oos.close();
							fos.close();
							fos = new FileOutputStream("./code.iyte");
							oos = new ObjectOutputStream(fos);
							oos.writeObject(belediyeKodu);
							oos.close();
							fos.close();
							dispose();
						} catch (FileNotFoundException e1) {
							JOptionPane.showMessageDialog(null,"Lisans dosyasý oluþturulamadý!","",JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null,"Yazma iþlemi sýrasýnda bir sorun oluþtu!","",JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}
					else JOptionPane.showMessageDialog(null,"Aktivasyon gerçekleþtirilemedi!","",JOptionPane.ERROR_MESSAGE);
				}
			});
		}
		return jButton1;
	}
	/**
	 * This method initializes jLabel2
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new javax.swing.JLabel();
			jLabel2.setBounds(16, 28, 90, 30);
			jLabel2.setText("Belediye Kodu");
		}
		return jLabel2;
	}
	/**
	 * This method initializes belediye_field
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getBelediye_field() {
		if(belediye_field == null) {
			belediye_field = new javax.swing.JTextField();
			belediye_field.setBounds(122, 28, 99, 30);
		}
		return belediye_field;
	}
}  //  @jve:visual-info  decl-index=0 visual-constraint="10,10"
