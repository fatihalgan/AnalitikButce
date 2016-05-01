import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/*
 * Created on 11.Eki.2004
 */

/**
 * @author Selim
 *
 */
public class LicenseProducerGUI extends JFrame {

	private javax.swing.JPanel jContentPane = null;

	private javax.swing.JTextField authorization_field_1 = null;
	private javax.swing.JTextField authorization_field_2 = null;
	private javax.swing.JLabel jLabel = null;
	private javax.swing.JTextField authentication_field_1 = null;
	private javax.swing.JTextField authentication_field_2 = null;
	private javax.swing.JLabel jLabel1 = null;
	private javax.swing.JButton jButton1 = null;
	private javax.swing.JLabel jLabel2 = null;
	private javax.swing.JTextField belediye_field = null;
	public static void main(String[] args) {
		LicenseProducerGUI lm = new LicenseProducerGUI();
		lm.show();
	}
	/**
	 * This is the default constructor
	 */
	public LicenseProducerGUI() {
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
			jContentPane.add(getAuthorization_field_1(), null);
			jContentPane.add(getAuthorization_field_2(), null);
			jContentPane.add(getJLabel(), null);
			jContentPane.add(getAuthentication_field_1(), null);
			jContentPane.add(getAuthentication_field_2(), null);
			jContentPane.add(getJLabel1(), null);
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
			authorization_field_2.setLocation(125, 260);
			authorization_field_2.setSize(99, 30);
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
			jLabel.setBounds(17, 202, 90, 30);
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
			authentication_field_1.setSize(99, 30);
			authentication_field_1.setEnabled(true);
			authentication_field_1.setLocation(13, 144);
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
			authentication_field_2.setEnabled(true);
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
			jLabel1.setBounds(17, 86, 90, 30);
			jLabel1.setText("Pin Kodu");
		}
		return jLabel1;
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
			jButton1.setText("Hesapla");
			jButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String belediyeKodu = belediye_field.getText();    
					String authenticationCode = authentication_field_1.getText() + authentication_field_2.getText();
					String authorizationCode = LicenseSystemModule.getAuthorizationCode(authenticationCode,belediyeKodu);
					authorization_field_1.setText(authorizationCode.substring(0,5));
					authorization_field_2.setText(authorizationCode.substring(5,10));
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
			jLabel2.setText("Belediye Kodu");
			jLabel2.setLocation(17, 28);
			jLabel2.setSize(90, 30);
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
			belediye_field.setSize(99, 30);
			belediye_field.setLocation(122, 28);
		}
		return belediye_field;
	}
}  //  @jve:visual-info  decl-index=0 visual-constraint="10,10"
