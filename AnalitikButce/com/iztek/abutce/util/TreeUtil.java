/*
 * Created on 18.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.abutce.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;

import com.iztek.abutce.domain.ButceKalemiBean;
import com.iztek.abutce.persister.ButceKalemiBeanPersister;
import com.iztek.abutce.util.money.MoneyException;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TreeUtil {

	public static DefaultMutableTreeNode convertPreOrderListToTree(ArrayList list) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			ButceKalemiBean bean = (ButceKalemiBean)it.next();
			addToTree(bean, node);
		}
		return node;
	}
	
	public static void addToTree(ButceKalemiBean bean, DefaultMutableTreeNode root) {
		String[] pathArray = ButceKalemiBeanPersister.parseRootPath(bean.getRootToPath());
		int index = 0;
		if(pathArray.length == 1) {
			root.setUserObject(bean);
		}
		else {
			DefaultMutableTreeNode node = root;
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(bean); 
			for(int i = 1; i < pathArray.length; i++) {
				Enumeration e = node.children();
				boolean nodeFound = false;
				while(e.hasMoreElements()) {
					DefaultMutableTreeNode child = (DefaultMutableTreeNode)e.nextElement();
					ButceKalemiBean childBean = (ButceKalemiBean)child.getUserObject();
					if(childBean.getKod().equals(pathArray[i])) {
						node = child;
						nodeFound = true;
						break;
					}
				}
				if(!nodeFound) {
					node.add(newNode);
					addOdemeToplamlari((ButceKalemiBean)newNode.getUserObject(), (DefaultMutableTreeNode)newNode.getParent());
				}
			}
		}
	}
	
	public static void addOdemeToplamlari(ButceKalemiBean bean, DefaultMutableTreeNode parent) {
		try {
			if(parent != null) {
				ButceKalemiBean parentBean = (ButceKalemiBean)parent.getUserObject();
				if(parentBean.getOdenek() != null)
					parentBean.setOdenek(parentBean.getOdenek().add(bean.getOdenek()));
				if(parentBean.getOdenekSayman() != null)
					parentBean.setOdenekSayman(parentBean.getOdenekSayman().add(bean.getOdenekSayman()));
				if(parentBean.getOdenekBaskan() != null)
					parentBean.setOdenekBaskan(parentBean.getOdenekBaskan().add(bean.getOdenekBaskan()));
				if(parentBean.getOdenekEncumen() != null)
					parentBean.setOdenekEncumen(parentBean.getOdenekEncumen().add(bean.getOdenekEncumen()));
				addOdemeToplamlari(bean, (DefaultMutableTreeNode)parent.getParent());
			}
		} catch(MoneyException me) {
			System.out.println(me.getMessage());
		}
	}
}
