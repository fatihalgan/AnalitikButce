package com.iztek.abutce.domain;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;


/*
 * Created on 16.Eki.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author Selim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SidedTreeNode extends DefaultMutableTreeNode {
	
	private boolean LEFT = true;
	private boolean RIGHT = false;
	
	public SidedTreeNode(String s){
		super(s);
	}
	
	public SidedTreeNode(Object o) {
		super();
		setUserObject(o);
	}
	
	/**
	 * @return
	 */
	public boolean isLEFT() {
		return LEFT;
	}

	/**
	 * @return
	 */
	public boolean isRIGHT() {
		return RIGHT;
	}

	/**
	 * @param b
	 */
	public void setLEFT(boolean b) {
		LEFT = b;
	}

	/**
	 * @param b
	 */
	public void setRIGHT(boolean b) {
		RIGHT = b;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.DefaultMutableTreeNode#getChildAt(int)
	 */
	public TreeNode getChildAt(int index) {
		if (children == null) {
			throw new ArrayIndexOutOfBoundsException("node has no children");
		}

		int realIndex = -1;
		int visibleIndex = -1;
		Enumeration enum = children.elements();
		while (enum.hasMoreElements()) {
			SidedTreeNode node = (SidedTreeNode) enum.nextElement();
			if(UIBroker.getSide()==0){
				if (node.isLEFT()) {
					visibleIndex++;
				}
				realIndex++;
				if (visibleIndex == index) {
					return (TreeNode) children.elementAt(realIndex);
				}
			}
			if(UIBroker.getSide()==1){
				if (node.isRIGHT()) {
					visibleIndex++;
				}
				realIndex++;
				if (visibleIndex == index) {
					return (TreeNode) children.elementAt(realIndex);
				}
			}
		}

		throw new ArrayIndexOutOfBoundsException("index unmatched");
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.tree.DefaultMutableTreeNode#getChildCount()
	 */
	public int getChildCount() {
		if (children == null) {
			return 0;
		}

		int count = 0;
		Enumeration enum = children.elements();
		while (enum.hasMoreElements()) {
			SidedTreeNode node = (SidedTreeNode) enum.nextElement();
			if(UIBroker.getSide()==0){
				if (node.isLEFT()) {
					count++;
				}
			}
			if(UIBroker.getSide()==1){
				if (node.isRIGHT()) {
					count++;
				}
			}
		}

		return count;
	}
	
	public void loadChildren(int butceTipi) throws Exception {
		ButceKalemiBean bean = (ButceKalemiBean)getUserObject();
		Collection children = ButceKalemiBean.getPersister().findTanimlarByRootPathAndLevel(butceTipi, getButceKoduPath(null), bean.getLevel() + 1);
		Iterator it = children.iterator();
		while(it.hasNext()) {
			ButceKalemiBean child = (ButceKalemiBean)it.next();
			SidedTreeNode childNode = new SidedTreeNode(child);
			add(childNode);
			ButceKalemiBean.getPersister().loadButceKalemiBilgileri(butceTipi, childNode.getButceKoduPath(null), child);
			//childNode.setLEFT(!child.isLeaf());
			childNode.setRIGHT(child.isRight());
		}
	}
	
	public String getButceKoduPath(String path) throws Exception {
		if(path == null) path="";
		if(getParent() != null) {
			path = ((SidedTreeNode)getParent()).getButceKoduPath(path) + "_" + ((ButceKalemiBean)getUserObject()).getKod();
		} else {
			path = ((ButceKalemiBean)getUserObject()).getKod() + path;
		}
		return path;
	}

	/**
	 * 
	 */
	public void persistNode(int butceTipi) {
		boolean isLeaf = true;
		try {
			SidedTreeNode parentNode = (SidedTreeNode)getParent();
			ButceKalemiBean bean = (ButceKalemiBean)getUserObject();
			bean.setLeaf(isLeaf);
			ButceKalemiBean.getPersister().insertButceKalemi(ButceConstants.RIGHT, butceTipi, bean, getButceKoduPath(null));
			if(parentNode!=null)parentNode.persistNode(butceTipi);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteNode(){
		ButceKalemiBean bean = (ButceKalemiBean)getUserObject();
		int childCount = getChildCount();
		if(childCount==0){
			try {
				ButceKalemiBean.getPersister().deleteButceKalemi(ButceConstants.RIGHT,ButceConstants.GIDER,bean,getButceKoduPath(null));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		SidedTreeNode parentNode = (SidedTreeNode)getParent(); 
		if(parentNode!=null)parentNode.deleteNode();
	}
	
	public void setAncestorsVisibleRight() {
		setRIGHT(true);
		SidedTreeNode parentNode = (SidedTreeNode)getParent();
		if(parentNode!=null)parentNode.setAncestorsVisibleRight();		
	}

	/**
	 * 
	 */
	public void setAncestorsInvisibleRight() {
		setRIGHT(false);
		Enumeration children = children();
		while(children.hasMoreElements()){
			SidedTreeNode child = (SidedTreeNode) children.nextElement();
			if(child.isRIGHT()) setRIGHT(true);
		}
		SidedTreeNode parentNode = (SidedTreeNode)getParent();
		if(parentNode!=null)parentNode.setAncestorsInvisibleRight();
	}


}
