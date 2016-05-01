/*
 * Created on 17.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.abutce.event;

import java.util.EventObject;

import com.iztek.abutce.domain.SidedTreeNode;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TreeRefreshedEvent extends EventObject {

	private SidedTreeNode treeNode;
	/**
	 * @param source
	 */
	public TreeRefreshedEvent(Object source, SidedTreeNode node) {
		super(source);
		treeNode = node;
	}
	

	/**
	 * @return Returns the treeNode.
	 */
	public SidedTreeNode getTreeNode() {
		return treeNode;
	}
	/**
	 * @param treeNode The treeNode to set.
	 */
	public void setTreeNode(SidedTreeNode treeNode) {
		this.treeNode = treeNode;
	}
}
