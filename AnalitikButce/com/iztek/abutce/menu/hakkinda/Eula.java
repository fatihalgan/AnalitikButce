package com.iztek.abutce.menu.hakkinda;

import java.io.IOException;

import javax.swing.JFrame;

import com.iztek.abutce.controller.GuiController;
import com.iztek.abutce.util.SwingUtils;

public class Eula extends JFrame {

	private javax.swing.JPanel jContentPane = null;

	private javax.swing.JScrollPane jScrollPane = null;
	private javax.swing.JEditorPane jEditorPane = null;
	/**
	 * This is the default constructor
	 */
	public Eula() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(484, 356);
		this.setContentPane(getJContentPane());
		this.setTitle("Son Kullanýcý Lisans Anlaþmasý");
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
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private javax.swing.JScrollPane getJScrollPane() {
		if(jScrollPane == null) {
			jScrollPane = new javax.swing.JScrollPane();
			jScrollPane.setViewportView(getJEditorPane());
		}
		return jScrollPane;
	}
	/**
	 * This method initializes jEditorPane
	 * 
	 * @return javax.swing.JEditorPane
	 */
	private javax.swing.JEditorPane getJEditorPane() {
		if(jEditorPane == null) {
			jEditorPane = new javax.swing.JEditorPane();
			jEditorPane.setContentType("text/html");
			try {
				jEditorPane.setPage(getClass().getResource("EULA.htm"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jEditorPane;
	}
	

	private void kapatButtonClicked() {
		GuiController.getInstance().disposeEnableFrames(this);
	}
}  //  @jve:visual-info  decl-index=0 visual-constraint="10,10"
