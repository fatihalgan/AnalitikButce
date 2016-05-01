/*
 * Created on 17.Eki.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.iztek.abutce.menu.main;

import javax.swing.JPanel;

/**
 * @author Selim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class EmptyPanel extends JPanel {

	private javax.swing.JLabel jLabel = null;
	/**
	 * This is the default constructor
	 */
	public EmptyPanel() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(new java.awt.BorderLayout());
		this.add(getJLabel(), java.awt.BorderLayout.CENTER);
		this.setSize(800, 600);
	}
	/**
	 * This method initializes jLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel() {
		if(jLabel == null) {
			jLabel = new javax.swing.JLabel();
			jLabel.setText("Analitik Bütçe Yönetim Sistemi");
			jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			jLabel.setForeground(java.awt.SystemColor.textHighlight);
		}
		return jLabel;
	}
}
