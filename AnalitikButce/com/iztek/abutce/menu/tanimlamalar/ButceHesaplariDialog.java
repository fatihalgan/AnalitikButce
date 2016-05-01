/*
 * Created on 19.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.abutce.menu.tanimlamalar;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import com.iztek.abutce.domain.ButceKalemiBean;
import com.iztek.abutce.util.SwingUtils;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ButceHesaplariDialog extends JDialog {

	private javax.swing.JPanel jContentPane = null;

	private JButton jButton = null;
	private JButton jButton1 = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField txtButceKod = null;
	private JTextArea txtButceTanim = null;
	private ButceKalemiBean butceKalemiBean = null;  //  @jve:decl-index=0:visual-constraint="460,112"
	/**
	 * @throws java.awt.HeadlessException
	 */
	public ButceHesaplariDialog(ButceKalemiBean bean) throws HeadlessException {
		super();
		this.butceKalemiBean = bean;
		initialize();
	}

	/**
	 * @param arg0
	 * @throws java.awt.HeadlessException
	 */
	public ButceHesaplariDialog(Dialog arg0) throws HeadlessException {
		super(arg0);
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @throws java.awt.HeadlessException
	 */
	public ButceHesaplariDialog(Dialog arg0, boolean arg1)
			throws HeadlessException {
		super(arg0, arg1);
		initialize();
	}

	/**
	 * @param arg0
	 * @throws java.awt.HeadlessException
	 */
	public ButceHesaplariDialog(Frame arg0, ButceKalemiBean arg1) throws HeadlessException {
		super(arg0);
		this.butceKalemiBean = arg1;
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @throws java.awt.HeadlessException
	 */
	public ButceHesaplariDialog(Frame arg0, boolean arg1) throws HeadlessException {
		super(arg0, arg1);
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @throws java.awt.HeadlessException
	 */
	public ButceHesaplariDialog(Dialog arg0, String arg1) throws HeadlessException {
		super(arg0, arg1);
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws java.awt.HeadlessException
	 */
	public ButceHesaplariDialog(Dialog arg0, String arg1, boolean arg2)
			throws HeadlessException {
		super(arg0, arg1, arg2);
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @throws java.awt.HeadlessException
	 */
	public ButceHesaplariDialog(Frame arg0, String arg1) throws HeadlessException {
		super(arg0, arg1);
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws java.awt.HeadlessException
	 */
	public ButceHesaplariDialog(Frame arg0, String arg1, boolean arg2)
			throws HeadlessException {
		super(arg0, arg1, arg2);
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @throws java.awt.HeadlessException
	 */
	public ButceHesaplariDialog(Dialog arg0, String arg1, boolean arg2,
			GraphicsConfiguration arg3) throws HeadlessException {
		super(arg0, arg1, arg2, arg3);
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public ButceHesaplariDialog(Frame arg0, String arg1, boolean arg2,
			GraphicsConfiguration arg3) {
		super(arg0, arg1, arg2, arg3);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setTitle("Kurumunuza Ait Bütçe Tanýmlamalarý");
		this.setSize(386, 233);
		this.setContentPane(getJContentPane());
		SwingUtils.centerJFrame(this);

	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			jLabel1 = new JLabel();
			jLabel = new JLabel();
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jLabel.setText("Kod:");
			jLabel1.setText("Taným:");
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 2;
			gridBagConstraints1.gridwidth = 2;
			gridBagConstraints1.ipadx = 10;
			gridBagConstraints1.ipady = -1;
			gridBagConstraints1.insets = new java.awt.Insets(11,68,34,34);
			gridBagConstraints2.gridx = 2;
			gridBagConstraints2.gridy = 2;
			gridBagConstraints2.ipadx = 29;
			gridBagConstraints2.ipady = -1;
			gridBagConstraints2.insets = new java.awt.Insets(13,34,32,70);
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.ipadx = 26;
			gridBagConstraints3.ipady = 4;
			gridBagConstraints3.insets = new java.awt.Insets(36,63,13,5);
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 1;
			gridBagConstraints4.ipadx = 13;
			gridBagConstraints4.ipady = 4;
			gridBagConstraints4.insets = new java.awt.Insets(23,64,19,4);
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.gridy = 0;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints5.ipadx = 25;
			gridBagConstraints5.insets = new java.awt.Insets(36,5,13,36);
			gridBagConstraints6.gridx = 1;
			gridBagConstraints6.gridy = 1;
			gridBagConstraints6.gridwidth = 2;
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.weighty = 1.0;
			gridBagConstraints6.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints6.ipadx = 197;
			gridBagConstraints6.ipady = 22;
			gridBagConstraints6.insets = new java.awt.Insets(13,5,11,59);
			gridBagConstraints7.gridx = 0;
			gridBagConstraints7.gridy = 2;
			gridBagConstraints7.gridwidth = 2;
			gridBagConstraints7.ipadx = 10;
			gridBagConstraints7.ipady = -1;
			gridBagConstraints7.insets = new java.awt.Insets(11,68,34,34);
			gridBagConstraints8.gridx = 2;
			gridBagConstraints8.gridy = 2;
			gridBagConstraints8.ipadx = 29;
			gridBagConstraints8.ipady = -1;
			gridBagConstraints8.insets = new java.awt.Insets(13,34,32,70);
			gridBagConstraints9.gridx = 0;
			gridBagConstraints9.gridy = 0;
			gridBagConstraints9.ipadx = 26;
			gridBagConstraints9.ipady = 4;
			gridBagConstraints9.insets = new java.awt.Insets(36,63,13,5);
			gridBagConstraints10.gridx = 0;
			gridBagConstraints10.gridy = 1;
			gridBagConstraints10.ipadx = 13;
			gridBagConstraints10.ipady = 4;
			gridBagConstraints10.insets = new java.awt.Insets(23,64,19,4);
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.gridy = 0;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints11.ipadx = 25;
			gridBagConstraints11.insets = new java.awt.Insets(36,5,13,36);
			gridBagConstraints12.gridx = 1;
			gridBagConstraints12.gridy = 1;
			gridBagConstraints12.gridwidth = 2;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.weighty = 1.0;
			gridBagConstraints12.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints12.ipadx = 197;
			gridBagConstraints12.ipady = 22;
			gridBagConstraints12.insets = new java.awt.Insets(13,5,11,59);
			jContentPane.add(getJButton(), gridBagConstraints7);
			jContentPane.add(getJButton1(), gridBagConstraints8);
			jContentPane.add(jLabel, gridBagConstraints9);
			jContentPane.add(jLabel1, gridBagConstraints10);
			jContentPane.add(getTxtButceKod(), gridBagConstraints11);
			jContentPane.add(getTxtButceTanim(), gridBagConstraints12);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Tamam");
			jButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					getButceKalemiBean().setKod(getTxtButceKod().getText().trim());
					getButceKalemiBean().setTanim(getTxtButceTanim().getText().trim());
					dispose();
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
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Ýptal");
			jButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					dispose();
				}
			});
		}
		return jButton1;
	}
	/**
	 * This method initializes txtButceKod	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getTxtButceKod() {
		if (txtButceKod == null) {
			txtButceKod = new JTextField();
			txtButceKod.setText(getButceKalemiBean().getKod());
		}
		return txtButceKod;
	}
	/**
	 * This method initializes txtButceTanim	
	 * 	
	 * @return javax.swing.JTextArea	
	 */    
	private JTextArea getTxtButceTanim() {
		if (txtButceTanim == null) {
			txtButceTanim = new JTextArea();
			txtButceTanim.setText(getButceKalemiBean().getTanim());
		}
		return txtButceTanim;
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
     }  //  @jve:decl-index=0:visual-constraint="10,10"
