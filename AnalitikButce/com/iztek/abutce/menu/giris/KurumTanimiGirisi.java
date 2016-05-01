/*
 * Created on 12.Eki.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.iztek.abutce.menu.giris;

import javax.swing.JFrame;

import com.iztek.abutce.domain.KurumsalTanimBean;
import com.iztek.abutce.util.SwingUtils;

/**
 * @author Selim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class KurumTanimiGirisi extends JFrame {

	private javax.swing.JPanel jContentPane = null;

	private javax.swing.JLabel jLabel = null;
	private javax.swing.JLabel jLabelKod = null;
	private javax.swing.JLabel jLabelTaným = null;
	private javax.swing.JLabel jLabelInfoKod = null;
	private javax.swing.JTextArea jTextAreaTanim = null;
	private javax.swing.JButton jButton = null;
	private javax.swing.JButton jButton1 = null;
	private com.iztek.abutce.domain.KurumsalTanimBean ivjKurumsalTanimBean = null;  //  @jve:visual-info  decl-index=0 visual-constraint="46,87"
	private JFrame parent;
	/**
	 * This is the default constructor
	 */
	public KurumTanimiGirisi() {
		super();
		initialize();
	}
	
	public KurumTanimiGirisi(String title, KurumsalTanimBean bean) {
		super();
		//this.parent = parent;
		ivjKurumsalTanimBean = bean;
		initialize();
		setTitle(title);
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(395, 196);
		SwingUtils.centerJFrame(this);
		this.setContentPane(getJContentPane());
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
			jContentPane.add(getJLabel(), null);
			jContentPane.add(getJLabelKod(), null);
			jContentPane.add(getJLabelTaným(), null);
			jContentPane.add(getJLabelInfoKod(), null);
			jContentPane.add(getJTextAreaTanim(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel() {
		if(jLabel == null) {
			jLabel = new javax.swing.JLabel();
			jLabel.setBounds(139, 10, 134, 16);
			jLabel.setText("Kurumsal Taným Giriþi");
		}
		return jLabel;
	}
	/**
	 * This method initializes jLabelKod
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabelKod() {
		if(jLabelKod == null) {
			jLabelKod = new javax.swing.JLabel();
			jLabelKod.setBounds(17, 47, 47, 17);
			jLabelKod.setText("Kod: ");
		}
		return jLabelKod;
	}
	/**
	 * This method initializes jLabelTaným
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabelTaným() {
		if(jLabelTaným == null) {
			jLabelTaným = new javax.swing.JLabel();
			jLabelTaným.setBounds(17, 86, 47, 17);
			jLabelTaným.setText("Taným: ");
		}
		return jLabelTaným;
	}
	/**
	 * This method initializes jLabelInfoKod
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabelInfoKod() {
		if(jLabelInfoKod == null) {
			jLabelInfoKod = new javax.swing.JLabel();
			jLabelInfoKod.setBounds(69, 47, 33, 17);
			jLabelInfoKod.setText(getIvjKurumsalTanimBean().getKod());
		}
		return jLabelInfoKod;
	}
	/**
	 * This method initializes jTextAreaTanim
	 * 
	 * @return javax.swing.JTextArea
	 */
	private javax.swing.JTextArea getJTextAreaTanim() {
		if(jTextAreaTanim == null) {
			jTextAreaTanim = new javax.swing.JTextArea();
			jTextAreaTanim.setBounds(69, 78, 270, 32);
			jTextAreaTanim.setText(getIvjKurumsalTanimBean().getTanim());
		}
		return jTextAreaTanim;
	}
	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton() {
		if(jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setBounds(77, 127, 77, 19);
			jButton.setText("Tamam");
			jButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					getIvjKurumsalTanimBean().setTanim(getJTextAreaTanim().getText().trim());
					getIvjKurumsalTanimBean().setConfigured(true);
					kapatButtonClicked();
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
			jButton1.setBounds(231, 127, 77, 19);
			jButton1.setText("Kapat");
			jButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					kapatButtonClicked();
				}
			});
		}
		return jButton1;
	}
	/**
	 * This method initializes ivjKurumsalTanimBean
	 * 
	 * @return com.iztek.abutce.domain.KurumsalTanimBean
	 */
	private com.iztek.abutce.domain.KurumsalTanimBean getIvjKurumsalTanimBean() {
		if(ivjKurumsalTanimBean == null) {
			ivjKurumsalTanimBean = new com.iztek.abutce.domain.KurumsalTanimBean();
		}
		return ivjKurumsalTanimBean;
	}
	
	private void kapatButtonClicked() {
		this.dispose();
	}
}  //  @jve:visual-info  decl-index=0 visual-constraint="208,14"
