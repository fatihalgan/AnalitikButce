/**
 * @author db2admin
 * Created on 12.Eki.2004 09:52:55
 */

package com.iztek.abutce.menu.hakkinda;

import javax.swing.JFrame;

import com.iztek.abutce.controller.GuiController;
import com.iztek.abutce.util.SwingUtils;

public class Hakkinda extends JFrame {

	private javax.swing.JPanel jContentPane = null;

	private javax.swing.JLabel jLabel = null;
	private javax.swing.JLabel jLabel1 = null;
	private javax.swing.JLabel jLabel2 = null;
	private javax.swing.JLabel jLabel3 = null;
	private javax.swing.JLabel jLabel4 = null;
	private javax.swing.JLabel jLabel5 = null;
	private javax.swing.JLabel jLabel6 = null;
	/**
	 * This is the default constructor
	 */
	public Hakkinda() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(484, 333);
		this.setContentPane(getJContentPane());
		this.setTitle("Hakkýnda");
		this.setResizable(false);
		SwingUtils.centerJFrame(this);
		this.addWindowListener(new java.awt.event.WindowAdapter() { 
			public void windowClosing(java.awt.event.WindowEvent e) {    
				kapatButtonClicked();
			}
		});
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
			jContentPane.add(getJLabel1(), null);
			jContentPane.add(getJLabel2(), null);
			jContentPane.add(getJLabel3(), null);
			jContentPane.add(getJLabel4(), null);
			jContentPane.add(getJLabel5(), null);
			jContentPane.add(getJLabel6(), null);
		}
		return jContentPane;
	}
	
	private void kapatButtonClicked() {
		GuiController.getInstance().disposeEnableFrames(this);
	}
	/**
	 * This method initializes jLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel() {
		if(jLabel == null) {
			jLabel = new javax.swing.JLabel();
			jLabel.setBounds(60, 33, 365, 44);
			jLabel.setText("Analitik Bütçe Yönetim Sistemi");
			jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 24));
			jLabel.setForeground(new java.awt.Color(0,0,177));
		}
		return jLabel;
	}
	/**
	 * This method initializes jLabel1
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new javax.swing.JLabel();
			jLabel1.setBounds(133, 113, 89, 24);
			jLabel1.setText("Versiyon 1.0");
			jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		}
		return jLabel1;
	}
	/**
	 * This method initializes jLabel2
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new javax.swing.JLabel();
			jLabel2.setBounds(233, 113, 91, 24);
			jLabel2.setText("ÝZTEK A.Þ.");
			jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		}
		return jLabel2;
	}
	/**
	 * This method initializes jLabel3
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new javax.swing.JLabel();
			jLabel3.setBounds(46, 178, 166, 24);
			jLabel3.setText("http://www.iztek.com.tr");
			jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		}
		return jLabel3;
	}
	/**
	 * This method initializes jLabel4
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new javax.swing.JLabel();
			jLabel4.setBounds(46, 214, 166, 24);
			jLabel4.setText("Tel:  0232 - 425 39 49");
			jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		}
		return jLabel4;
	}
	/**
	 * This method initializes jLabel5
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new javax.swing.JLabel();
			jLabel5.setBounds(159, 254, 166, 24);
			jLabel5.setText("Copyright (c) Her Hakký Saklýdýr");
			jLabel5.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 10));
			jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		}
		return jLabel5;
	}
	/**
	 * This method initializes jLabel6
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel6() {
		if(jLabel6 == null) {
			jLabel6 = new javax.swing.JLabel();
			jLabel6.setBounds(262, 178, 166, 24);
			jLabel6.setText("email: iztek@iztek.com.tr");
			jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		}
		return jLabel6;
	}
}  //  @jve:visual-info  decl-index=0 visual-constraint="10,10"
