/*
 * Created on 20.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.abutce.menu.giris;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import com.iztek.abutce.controller.GuiController;
import com.iztek.abutce.domain.ButceConstants;
import com.iztek.abutce.domain.ButceKalemiBean;
import com.iztek.abutce.domain.SidedTreeNode;
import com.iztek.abutce.util.money.Money;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class GelirTeklifGirisiDialog extends JDialog {

	private javax.swing.JPanel jContentPane = null;

	private javax.swing.JPanel jPanel = null;
	private javax.swing.JLabel jLabel = null;
	private javax.swing.JTextField jTextField = null;
	private SidedTreeNode selecteNode = null;
	private ButceKalemiBean bean = null;
	private String defaultUnit = GuiController.getInstance().getDefaultUnit();
	private javax.swing.JLabel jLabel3 = null;
	private javax.swing.JLabel jLabel4 = null;
	private javax.swing.JLabel jLabel5 = null;
	private javax.swing.JTextField jTextField3 = null;
	private javax.swing.JTextField jTextField4 = null;
	private javax.swing.JTextField jTextField6 = null;
	private javax.swing.JTextField jTextField7 = null;
	private javax.swing.JTextField jTextField8 = null;
	private javax.swing.JButton jButton = null;
	private javax.swing.JButton jButton1 = null;
	private javax.swing.JLabel jLabel6 = null;
	public GelirTeklifGirisiDialog(ButceKalemiBean bean,SidedTreeNode selectedNode) {
		this.bean = bean;
		this.selecteNode = selectedNode;		
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(439, 204);
		this.setContentPane(getJContentPane());
		editLabels();
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJPanel(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJPanel() {
		if(jPanel == null) {
			jPanel = new javax.swing.JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJLabel(), null);
			jPanel.add(getJTextField(), null);
			jPanel.add(getJLabel3(), null);
			jPanel.add(getJLabel4(), null);
			jPanel.add(getJLabel5(), null);
			jPanel.add(getJTextField3(), null);
			jPanel.add(getJTextField4(), null);
			jPanel.add(getJButton(), null);
			jPanel.add(getJButton1(), null);
			jPanel.add(getJLabel6(), null);
		}
		return jPanel;
	}
	private javax.swing.JLabel getJLabel() {
		if(jLabel == null) {
			jLabel = new javax.swing.JLabel();
			jLabel.setBounds(6, 95, 205, 20);
		}
		return jLabel;
	}
	
	private javax.swing.JTextField getJTextField() {
		if(jTextField == null) {
			jTextField = new javax.swing.JTextField();
			jTextField.setBounds(213, 95, 168, 20);
			if(bean.getOdenekSayman() != null) {
				if(defaultUnit.equals("YTL"))
				jTextField.setText(bean.getOdenekSayman().convertTo("YTL").toString());
				else 
					jTextField.setText(bean.getOdenekSayman().toString());
			}
		}	
		return jTextField;
	}
	
	private void tamamButtonClicked() {
		Money odenek = null;
		try{
			if(jTextField.getText() != null && jTextField.getText().trim().length() != 0) {
				odenek = new Money((Double.parseDouble(jTextField.getText().trim())), defaultUnit);
			}
			if(defaultUnit.equals("YTL")) {
				bean.setOdenek(odenek.convertTo("TL"));
			} else {
				bean.setOdenek(odenek);
			}
			try {
				ButceKalemiBean.getPersister().updateButceKalemi(ButceConstants.RIGHT,ButceConstants.GELIR,bean,selecteNode.getButceKoduPath(null));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Lütfen geçerli bir ödenek teklifi giriniz.", "UYARI", JOptionPane.WARNING_MESSAGE);
		}
	}

	private javax.swing.JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new javax.swing.JLabel();
			jLabel3.setBounds(109, 7, 217, 22);
			jLabel3.setText("Ödenek Teklifi Giriþi");
			jLabel3.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
			jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		}
		return jLabel3;
	}
	private javax.swing.JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new javax.swing.JLabel();
			jLabel4.setBounds(6, 40, 205, 20);
			jLabel4.setText("Bütçe Kodu");
		}
		return jLabel4;
	}
	
	private javax.swing.JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new javax.swing.JLabel();
			jLabel5.setBounds(6, 65, 205, 20);
			jLabel5.setText("Açýklama");
		}
		return jLabel5;
	}

	private javax.swing.JTextField getJTextField3() {
		if(jTextField3 == null) {
			jTextField3 = new javax.swing.JTextField();
			jTextField3.setBounds(213, 40, 213, 20);
			jTextField3.setText(bean.getKod());
			jTextField3.setEditable(false);
		}
		return jTextField3;
	}
	
	private javax.swing.JTextField getJTextField4() {
		if(jTextField4 == null) {
			jTextField4 = new javax.swing.JTextField();
			jTextField4.setBounds(213, 65, 213, 20);
			jTextField4.setText(bean.getTanim());
			jTextField4.setEditable(false);
		}
		return jTextField4;
	}
	private javax.swing.JLabel getJLabel6() {
		if(jLabel6 == null) {
			jLabel6 = new javax.swing.JLabel();
			jLabel6.setBounds(384, 95, 42, 20);
			jLabel6.setText(GuiController.getInstance().getDefaultUnit().toString());
		}
		return jLabel6;
	}
	
	private javax.swing.JButton getJButton() {
		if(jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setBounds(106, 135, 104, 26);
			jButton.setText("Tamam");
			jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iztek/abutce/images/ok.gif")));
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
			jButton1.setBounds(219, 136, 104, 26);
			jButton1.setText("Kapat");
			jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iztek/abutce/images/close.gif")));
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
			
		}
		return jButton1;
	}
		
	private void editLabels() {
			jLabel.setText("Ödenek");
			jLabel6.setText(defaultUnit);
			if(bean.getOdenek() != null) {
				jTextField.setText(bean.getOdenek().convertTo(defaultUnit).getAmountAsString());
			}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
