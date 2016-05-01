/*
 * Created on 17.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.abutce.menu.tanimlamalar;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.iztek.abutce.domain.ButceKalemiBean;
import com.iztek.abutce.domain.SidedTreeNode;
import com.iztek.abutce.event.TreeEventDispatcher;

import javax.swing.JFrame;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ButceHesaplariPanel extends JPanel {
	private LeftTreePanel butceTreePanel = null;
	private JPanel jPanel = null;
	private JButton btnDuzelt = null;
	private SidedTreeNode root = null;
	private ButceHesaplariDialog butceHesaplariDialog = null;  //  @jve:decl-index=0:visual-constraint="654,139"
	private JFrame parentFrame = null;
	/**
	 * @return Returns the parent.
	 */
	public JFrame getParentFrame() {
		return parentFrame;
	}
	/**
	 * 
	 */
	public ButceHesaplariPanel() {
		super();
		initialize();
	}
	
	public ButceHesaplariPanel(JFrame parent) {
		super();
		initialize();
		this.parentFrame = parent;
	}

	/**
	 * @param isDoubleBuffered
	 */
	public ButceHesaplariPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		initialize();
	}

	/**
	 * @param layout
	 */
	public ButceHesaplariPanel(LayoutManager layout) {
		super(layout);
		initialize();
	}

	/**
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public ButceHesaplariPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
		this.setLayout(new BorderLayout());
		this.setSize(600, 400);
		this.add(getButceTreePanel(), java.awt.BorderLayout.CENTER);
		this.add(getJPanel(), java.awt.BorderLayout.SOUTH);
	}
	/**
	 * This method initializes butceTreePanel	
	 * 	
	 * @return com.iztek.abutce.menu.tanimlamalar.TreePanel	
	 */    
	private LeftTreePanel getButceTreePanel() {
		if (butceTreePanel == null) {
			getTreeRoot();
			butceTreePanel = new LeftTreePanel("Kurumunuza Ait Bütçe Tanýmlamalarý", root);
			butceTreePanel.setName("butceTreePanel");
			TreeEventDispatcher.getDispatcher().addButceTipiListener(butceTreePanel);
		}
		return butceTreePanel;
	}
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setName("jPanel");
			jPanel.add(getBtnDuzelt(), null);
		}
		return jPanel;
	}
	private javax.swing.JButton getBtnDuzelt() {
		if(btnDuzelt == null) {
			btnDuzelt = new javax.swing.JButton();
			btnDuzelt.setText("Düzelt");
			btnDuzelt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iztek/abutce/images/edit.gif")));
			btnDuzelt.setPreferredSize(new java.awt.Dimension(108,26));
			btnDuzelt.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						getButceHesaplariDialog();
						ButceKalemiBean bean = (ButceKalemiBean)(getButceTreePanel().getSelectedNode().getUserObject());
						getButceTreePanel().expandTree(getButceTreePanel().getSelectedNode());
						ButceKalemiBean.getPersister().updateButceTanimi(bean, getButceTreePanel().getButceTipi());
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					
				}
			});
		}
		return btnDuzelt;
	}
	
	private void getTreeRoot(){
		ButceKalemiBean rootBean = null;
		Collection tanimlar = null;
		try {
			tanimlar = ButceKalemiBean.getPersister().findTanimlarByRootPathAndLevel(0,	"", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Iterator it = tanimlar.iterator();
		while(it.hasNext()){ 
			rootBean = (ButceKalemiBean) it.next();
		}
		root = new SidedTreeNode(rootBean);
	}	
	
	public void editButceTanimiGirisi() {
		try{
			getButceTreePanel().expandTree(getButceTreePanel().getSelectedNode());
			ButceKalemiBean.getPersister().updateButceTanimi((ButceKalemiBean)(getButceTreePanel().getSelectedNode().getUserObject()),
				getButceTreePanel().getButceTipi());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void showButceTanimiGirisiFrame() {
		ButceTanimiGirisiFrame tanimFrame = new ButceTanimiGirisiFrame(this, "Butçe Hesaplarý Tanýmlama", (ButceKalemiBean)(((SidedTreeNode)getButceTreePanel().getSelectedNode()).getUserObject()));
		tanimFrame.show();
	}
	/**
	 * This method initializes butceHesaplariDialog	
	 * 	
	 * @return com.iztek.abutce.menu.tanimlamalar.ButceHesaplariDialog	
	 */    
	private ButceHesaplariDialog getButceHesaplariDialog() {
			butceHesaplariDialog = new ButceHesaplariDialog(getParentFrame(), (ButceKalemiBean)(getButceTreePanel().getSelectedNode().getUserObject()));
			butceHesaplariDialog.show();
		return butceHesaplariDialog;
	}
 }  //  @jve:decl-index=0:visual-constraint="4,57"
