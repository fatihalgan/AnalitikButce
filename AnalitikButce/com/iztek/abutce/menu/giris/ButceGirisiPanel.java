/*
 * Created on 17.Eki.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.iztek.abutce.menu.giris;

import java.util.Collection;
import java.util.Iterator;

import javax.swing.JPanel;

import com.iztek.abutce.domain.ButceConstants;
import com.iztek.abutce.domain.ButceKalemiBean;
import com.iztek.abutce.domain.SidedTreeNode;
import com.iztek.abutce.domain.UIBroker;
import com.iztek.abutce.event.TreeEventDispatcher;
import com.iztek.abutce.event.TreeRefreshedEvent;
import com.iztek.abutce.menu.tanimlamalar.LeftTreePanel;
import com.iztek.abutce.menu.tanimlamalar.RightTreePanel;
import com.iztek.abutce.util.SwingUtils;

import javax.swing.ImageIcon;

import java.awt.Component;
import java.awt.FlowLayout;
/**
 * @author Selim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ButceGirisiPanel extends JPanel {

	private javax.swing.JPanel jPanel = null;
	private javax.swing.JSplitPane jSplitPane = null;
	private javax.swing.JButton jButton = null;
	private javax.swing.JButton jButton1 = null;
	private com.iztek.abutce.menu.tanimlamalar.LeftTreePanel tanimlarPanel = null;
	private com.iztek.abutce.menu.tanimlamalar.RightTreePanel kalemlerPanel = null;
	private SidedTreeNode root = null;
	private javax.swing.JButton jButton2 = null;
	private ButceGirisiPanel butcePanel = this;
	
	
	/**
	 * This is the default constructor
	 */
	public ButceGirisiPanel() {
		super();
		getTreeRoot();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(new java.awt.BorderLayout());
		this.add(getJPanel(), java.awt.BorderLayout.SOUTH);
		this.add(getJSplitPane(), java.awt.BorderLayout.CENTER);
		this.setSize(800, 600);
	}
	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJPanel() {
		if(jPanel == null) {
			FlowLayout flowLayout1 = new FlowLayout();
			jPanel = new javax.swing.JPanel();
			jPanel.setLayout(flowLayout1);
			jPanel.setPreferredSize(new java.awt.Dimension(10,50));
			flowLayout1.setHgap(20);
			jPanel.add(getJButton(), null);
			jPanel.add(getJButton1(), null);
			jPanel.add(getJButton2(), null);
		}
		return jPanel;
	}
	/**
	 * This method initializes jSplitPane
	 * 
	 * @return javax.swing.JSplitPane
	 */
	private javax.swing.JSplitPane getJSplitPane() {
		if(jSplitPane == null) {
			jSplitPane = new javax.swing.JSplitPane();
			jSplitPane.setOneTouchExpandable(true);
			jSplitPane.setContinuousLayout(false);
			jSplitPane.setPreferredSize(new java.awt.Dimension(800,600));
			jSplitPane.setOrientation(javax.swing.JSplitPane.HORIZONTAL_SPLIT);
			jSplitPane.setLeftComponent(getTanimlarPanel());
			jSplitPane.setRightComponent(getKalemlerPanel());
			jSplitPane.setResizeWeight(0.5);
		}
		return jSplitPane;
	}
	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton() {
		if(jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setText("Çýkar");
			jButton.setIcon(new ImageIcon(getClass().getResource("/com/iztek/abutce/images/sol.jpg")));
			jButton.setPreferredSize(new java.awt.Dimension(110,27));
			jButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					SidedTreeNode selectedNode = (SidedTreeNode)getKalemlerPanel().getSelectedNode();
					if(selectedNode.getChildCount()==0){
						UIBroker.setSide(1);
						selectedNode.setAncestorsInvisibleRight();
						selectedNode.deleteNode();
						TreeEventDispatcher.getDispatcher().fireLeftTreeRefreshedEvent(new TreeRefreshedEvent(this, selectedNode));
					}
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
			jButton1.setText("Seç");
			jButton1.setIcon(new ImageIcon(getClass().getResource("/com/iztek/abutce/images/sag.jpg")));
			jButton1.setPreferredSize(new java.awt.Dimension(110,27));
			jButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					SidedTreeNode selectedNode = (SidedTreeNode)getTanimlarPanel().getSelectedNode();
					if(selectedNode.getChildCount()==0){
						UIBroker.setSide(1);
						selectedNode.setAncestorsVisibleRight();
						selectedNode.persistNode(getTanimlarPanel().getButceTipi());
						TreeEventDispatcher.getDispatcher().fireLeftTreeRefreshedEvent(new TreeRefreshedEvent(this, selectedNode));
						getKalemlerPanel().expandTree(selectedNode);
						UIBroker.setSide(0);			
						getTanimlarPanel().expandTree(selectedNode);											
					} else {
						SwingUtils.errorMessage((Component)getParent(), "Sadece Aðaçtaki En Alt Seviyeden Bütçe Kalemi Ekleyebilirsiniz...");
					}
				}
			});
		}
		return jButton1;
	}
	/**
	 * This method initializes tanimlarPanel
	 * 
	 * @return com.iztek.abutce.menu.tanimlamalar.TreePanel
	 */
	private com.iztek.abutce.menu.tanimlamalar.LeftTreePanel getTanimlarPanel() {
		if(tanimlarPanel == null) {
			tanimlarPanel = new LeftTreePanel(root);
			TreeEventDispatcher.getDispatcher().addRightTreeRefreshedListener(tanimlarPanel);
			TreeEventDispatcher.getDispatcher().addButceTipiListener(tanimlarPanel);
		}
		return tanimlarPanel;
	}
	/**
	 * This method initializes kalemlerPanel
	 * 
	 * @return com.iztek.abutce.menu.tanimlamalar.TreePanel
	 */
	private com.iztek.abutce.menu.tanimlamalar.RightTreePanel getKalemlerPanel() {
		if(kalemlerPanel == null) {
			kalemlerPanel = new RightTreePanel(root);
			TreeEventDispatcher.getDispatcher().addLeftTreeRefreshedListener(kalemlerPanel);
			TreeEventDispatcher.getDispatcher().addButceTipiListener(kalemlerPanel);
		}
		return kalemlerPanel;
	}
	
	private void getTreeRoot(){
		ButceKalemiBean rootBean = null;
		Collection tanimlar = null;
		try {
			tanimlar = ButceKalemiBean.getPersister().findTanimlarByRootPathAndLevel(1,	"", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Iterator it = tanimlar.iterator();
		while(it.hasNext()){ 
			rootBean = (ButceKalemiBean) it.next();
		}
		root = new SidedTreeNode(rootBean);
	}	
	
	/**
	 * This method initializes jButton2
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new javax.swing.JButton();
			jButton2.setText("Ödenek Giriþi");			
			jButton2.setIcon(new ImageIcon(getClass().getResource("/com/iztek/abutce/images/edit.gif")));
			jButton2.setPreferredSize(new java.awt.Dimension(130,27));
			jButton2.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
					SidedTreeNode selectedNode = getKalemlerPanel().getSelectedNode();
					if(selectedNode == null) SwingUtils.errorMessage(getParent(), "Lütfen Sað Taraftaki Panelden Bir Bütçe Kalemi Seçiniz...");
					if(selectedNode != null){
						if(kalemlerPanel.getButceTipi() == ButceConstants.GIDER) {
							GiderTeklifGirisiDialog dialog = new GiderTeklifGirisiDialog((ButceKalemiBean)selectedNode.getUserObject(),selectedNode);
							SwingUtils.centerJFrame(dialog);
							dialog.show();
						} else {
							GelirTeklifGirisiDialog dialog = new GelirTeklifGirisiDialog((ButceKalemiBean)selectedNode.getUserObject(),selectedNode);
							SwingUtils.centerJFrame(dialog);
							dialog.show();
						}
					}    					
				}
			});
		}
		return jButton2;
	}
}
