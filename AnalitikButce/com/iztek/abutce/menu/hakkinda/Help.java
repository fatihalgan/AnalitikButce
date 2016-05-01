/*
 * Created on 21.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.abutce.menu.hakkinda;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JDialog;

import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Help extends JDialog {

	private JScrollPane jScrollPane = null;
	private JEditorPane jEditorPane = null;
	/**
	 * @throws java.awt.HeadlessException
	 */
	public Help() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @throws java.awt.HeadlessException
	 */
	public Help(Frame owner) throws HeadlessException {
		super(owner);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param modal
	 * @throws java.awt.HeadlessException
	 */
	public Help(Frame owner, boolean modal) throws HeadlessException {
		super(owner, modal);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param title
	 * @throws java.awt.HeadlessException
	 */
	public Help(Frame owner, String title) throws HeadlessException {
		super(owner, title);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param title
	 * @param modal
	 * @throws java.awt.HeadlessException
	 */
	public Help(Frame owner, String title, boolean modal)
			throws HeadlessException {
		super(owner, title, modal);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param title
	 * @param modal
	 * @param gc
	 */
	public Help(Frame owner, String title, boolean modal,
			GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @throws java.awt.HeadlessException
	 */
	public Help(Dialog owner) throws HeadlessException {
		super(owner);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param modal
	 * @throws java.awt.HeadlessException
	 */
	public Help(Dialog owner, boolean modal) throws HeadlessException {
		super(owner, modal);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param title
	 * @throws java.awt.HeadlessException
	 */
	public Help(Dialog owner, String title) throws HeadlessException {
		super(owner, title);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param title
	 * @param modal
	 * @throws java.awt.HeadlessException
	 */
	public Help(Dialog owner, String title, boolean modal)
			throws HeadlessException {
		super(owner, title, modal);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param title
	 * @param modal
	 * @param gc
	 * @throws java.awt.HeadlessException
	 */
	public Help(Dialog owner, String title, boolean modal,
			GraphicsConfiguration gc) throws HeadlessException {
		super(owner, title, modal, gc);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
		this.setTitle("Yardým");
		this.setContentPane(getJScrollPane());
		this.setSize(421, 297);
		Dimension dim = this.getToolkit().getScreenSize();
		this.setLocation(
			dim.width / 2 - this.getWidth() / 2,
			dim.height / 2 - this.getHeight() / 2);
		this.addWindowListener(new java.awt.event.WindowAdapter() { 
			public void windowClosing(java.awt.event.WindowEvent e) {    
				dispose();
			}
		});
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJEditorPane());
		}
		return jScrollPane;
	}
	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */    
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane();
			jEditorPane.setContentType("text/html");
			try {
				jEditorPane.setPage(getClass().getResource("../../../../../help.htm"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jEditorPane;
	}
  }  //  @jve:decl-index=0:visual-constraint="10,10"
