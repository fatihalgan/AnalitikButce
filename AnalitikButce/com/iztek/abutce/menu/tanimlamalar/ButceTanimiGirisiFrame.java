package com.iztek.abutce.menu.tanimlamalar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import com.iztek.abutce.domain.ButceKalemiBean;
import com.iztek.abutce.util.SwingUtils;

public class ButceTanimiGirisiFrame extends JFrame {

	private javax.swing.JPanel jContentPane = null;
	private javax.swing.JLabel jLabel = null;
	private javax.swing.JLabel jLabel1 = null;
	private javax.swing.JTextField txtButceKodu = null;
	private javax.swing.JTextField txtButceTanimi = null;
	private javax.swing.JButton jButton = null;
	private javax.swing.JButton jButton1 = null;
	
	private ButceHesaplariPanel parent = null;
	private String title = null;
		
	
	private ButceKalemiBean butceKalemiBean = null;  //  @jve:decl-index=0:visual-constraint="403,97"
	public ButceTanimiGirisiFrame(ButceHesaplariPanel parent, String title, ButceKalemiBean bean) {
		super();
		this.parent = parent;
		this.title = title+" Kod Giriþi";
		this.butceKalemiBean = bean;
		initialize();
	}
	
	private void initialize() {
		this.setSize(323, 152);
		this.setContentPane(getJContentPane());
		this.setTitle(title);
		this.setResizable(false);
		SwingUtils.centerJFrame(this);
		this.addWindowListener(new java.awt.event.WindowAdapter() { 
			public void windowClosing(java.awt.event.WindowEvent e) {    
				kapatButtonClicked();
			}
		});		
		
	}
	
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJLabel(), null);
			jContentPane.add(getJLabel1(), null);
			jContentPane.add(getTxtButceKodu(), null);
			jContentPane.add(getTxtButceTanimi(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
		}
		return jContentPane;
	}
	
	private javax.swing.JLabel getJLabel() {
		if(jLabel == null) {
			jLabel = new javax.swing.JLabel();
			jLabel.setBounds(15, 20, 55, 20);
			jLabel.setText("Kod");
		}
		return jLabel;
	}
	
	private javax.swing.JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new javax.swing.JLabel();
			jLabel1.setBounds(15, 44, 55, 20);
			jLabel1.setText("Açýklama");
		}
		return jLabel1;
	}
	
	private javax.swing.JTextField getTxtButceKodu() {
		if(txtButceKodu == null) {
			txtButceKodu = new javax.swing.JTextField();
			txtButceKodu.setBounds(72, 20, 46, 20);
			txtButceKodu.setText(getButceKalemiBean().getKod());
			txtButceKodu.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					tamamButtonClicked();
				}
			});
		}
		return txtButceKodu;
	}
	
	private javax.swing.JTextField getTxtButceTanimi() {
		if(txtButceTanimi == null) {
			txtButceTanimi = new javax.swing.JTextField();
			txtButceTanimi.setBounds(72, 44, 229, 20);
			txtButceTanimi.setText(getButceKalemiBean().getTanim());
			txtButceTanimi.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					tamamButtonClicked();
				}
			});
		}
		return txtButceTanimi;
	}
	
	private javax.swing.JButton getJButton() {
		if(jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setSize(99, 28);
			jButton.setText("Tamam");
			jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iztek/abutce/images/ok.gif")));
			jButton.setLocation(58, 79);
			jButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					tamamButtonClicked();
				}
			});
		}
		return jButton;
	}
	
	private javax.swing.JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new javax.swing.JButton();
			jButton1.setBounds(160, 79, 99, 28);
			jButton1.setText("Kapat");
			jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iztek/abutce/images/close.gif")));
			jButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					kapatButtonClicked();
				}
			});
		}
		return jButton1;
	}
	
	private void kapatButtonClicked() {
		this.dispose();
	}
	
	private boolean checkInputFields() {
		boolean flag = true;
		String kod = txtButceKodu.getText();
		String tanim =txtButceTanimi.getText();
		if(kod == null || kod.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "Lütfen geçerli bir kod giriniz.", "UYARI", JOptionPane.WARNING_MESSAGE);
			txtButceKodu.setText("");
			flag = false;		
		}else if(tanim == null || tanim.trim().length()==0) {
			JOptionPane.showMessageDialog(null, "Lütfen geçerli bir açýklama giriniz.", "UYARI", JOptionPane.WARNING_MESSAGE);
			txtButceTanimi.setText("");
			flag = false;
		}
		if(flag) {
			try {
				int num = Integer.parseInt(kod.trim());
				if(num < 0 || num > 99) {
					JOptionPane.showMessageDialog(null, "Lütfen 00 ile 99 arasýnda bir kod giriniz.", "UYARI", JOptionPane.WARNING_MESSAGE);
					flag = false;
				}
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Lütfen 00 ile 99 arasýnda bir kod giriniz.", "UYARI", JOptionPane.WARNING_MESSAGE);
				flag = false;
			}				
		}
		return flag;
	}
	
	private void tamamButtonClicked() {
		if(checkInputFields()) {
			String kod = txtButceKodu.getText().trim();
			String tanim = txtButceTanimi.getText().trim();
			getButceKalemiBean().setKod(kod);
			getButceKalemiBean().setTanim(tanim);
			((ButceHesaplariPanel)getParent()).editButceTanimiGirisi();
			kapatButtonClicked();
		}
	}
	/**
	 * This method initializes butceKalemiBean	
	 * 	
	 * @return com.iztek.abutce.domain.ButceKalemiBean	
	 */    
	private ButceKalemiBean getButceKalemiBean() {
		if (butceKalemiBean == null) {
			butceKalemiBean = new ButceKalemiBean();
		}
		return butceKalemiBean;
	}
 }