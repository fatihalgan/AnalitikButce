/*
 * Created on 17.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.abutce.menu.tanimlamalar;

import java.awt.Cursor;

import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import com.iztek.abutce.domain.SidedTreeNode;
import com.iztek.abutce.domain.UIBroker;
import com.iztek.abutce.event.ButceTipiListener;
import com.iztek.abutce.event.TreeEventDispatcher;
import com.iztek.abutce.event.TreeRefreshedEvent;
import com.iztek.abutce.event.LeftTreeListener;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RightTreePanel extends JScrollPane implements LeftTreeListener, ButceTipiListener {

	private javax.swing.JTree jTree = null;
	private SidedTreeNode rootNode = null;
	private DefaultTreeModel treeModel = null;
	private int side = UIBroker.RIGHT;
	private int butceTipi = 0;
	
	/**
	 * @return Returns the butceTipi.
	 */
	public int getButceTipi() {
		return butceTipi;
	}
	/**
	 * @param butceTipi The butceTipi to set.
	 */
	public void setButceTipi(int butceTipi) {
		this.butceTipi = butceTipi;
	}
	public RightTreePanel(SidedTreeNode rootNode) {
		super();
		this.rootNode = rootNode;
		initialize();
	}
	
	
	/**
	 * @return Returns the treeModel.
	 */
	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}
	
	private String title = null;
		
	public RightTreePanel(String title,SidedTreeNode rootNode) {
		super();
		this.title = title;
		this.rootNode = rootNode;
		initialize();
	}
		
	private void initialize() {
		this.setViewportView(getJTree());
		this.setSize(300, 200);
	}
	
	public javax.swing.JTree getJTree() {
		if(jTree == null) {
			jTree = new javax.swing.JTree();
			jTree.setModel(new DefaultTreeModel(rootNode));
			jTree.addMouseListener(new java.awt.event.MouseAdapter() { 
				public void mouseClicked(java.awt.event.MouseEvent e) {    
					try {
						UIBroker.setSide(side);
						readChildNodes();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return jTree;
	}
	

	/******************************************************/
	/***************** BUSINESS METHODS *******************/
	/******************************************************/
	
	private void readChildNodes() throws Exception {
		SidedTreeNode selectedNode = (SidedTreeNode)jTree.getLastSelectedPathComponent();		
		if(selectedNode != null && !selectedNode.children().hasMoreElements()) {
			((SidedTreeNode)selectedNode).loadChildren(butceTipi);
		}
		if(side == UIBroker.LEFT)	
			TreeEventDispatcher.getDispatcher().fireLeftTreeRefreshedEvent(new TreeRefreshedEvent(this, selectedNode));
		else TreeEventDispatcher.getDispatcher().fireRightTreeRefreshedEvent(new TreeRefreshedEvent(this, selectedNode));
	} 
	
	public void expandTree(SidedTreeNode selectedNode){
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		jTree.updateUI();
		scrollPathToVisible((SidedTreeNode)selectedNode.getLastLeaf());		
	}
	
	public void updateTree() {
		jTree.updateUI();
	}
	
	public SidedTreeNode getSelectedNode() {
		return (SidedTreeNode)jTree.getLastSelectedPathComponent();
	}
	
	public SidedTreeNode getRoot() {
		return (SidedTreeNode)treeModel.getRoot();
	}
	
	public void scrollPathToVisible(SidedTreeNode node) {
		jTree.scrollPathToVisible(new TreePath(node.getPath()));
		jTree.expandPath(new TreePath(node.getPath()));
	}


	/* (non-Javadoc)
	 * @see com.iztek.abutce.event.TreeRefreshedListener#refreshTree(com.iztek.abutce.event.TreeRefreshedEvent)
	 */
	public void refreshTree(TreeRefreshedEvent event) {
			expandTree(event.getTreeNode());		
	}
	/* (non-Javadoc)
	 * @see com.iztek.abutce.event.ButceTipiListener#butceTipiChanged(int)
	 */
	public void butceTipiChanged(int butceTipi) {
		this.butceTipi = butceTipi;	
	}
}
	