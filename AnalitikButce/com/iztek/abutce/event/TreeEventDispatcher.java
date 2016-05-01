/*
 * Created on 17.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.abutce.event;

import javax.swing.event.EventListenerList;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TreeEventDispatcher {

	private EventListenerList leftTreeListenerList = null;
	private EventListenerList rightTreeListenerList = null;
	private EventListenerList butceTipiListenerList = null;
	private static TreeEventDispatcher dispatcher = null;
	private TreeEventDispatcher() {
		
	}
	
	public static TreeEventDispatcher getDispatcher(){
		if(dispatcher == null){
			dispatcher = new TreeEventDispatcher();
		}
		return dispatcher;
	}
	
	public synchronized void addLeftTreeRefreshedListener(LeftTreeListener listener){
		if (leftTreeListenerList == null ) {
			leftTreeListenerList = new javax.swing.event.EventListenerList();
		}
		leftTreeListenerList.add(LeftTreeListener.class, listener);
	}
	
	public synchronized void removeLeftTreeRefreshedListener(LeftTreeListener listener) {
		leftTreeListenerList.remove(LeftTreeListener.class, listener);
	}
	
	public synchronized void addButceTipiListener(ButceTipiListener listener) {
		if(butceTipiListenerList == null) {
			butceTipiListenerList = new EventListenerList();
		}
		butceTipiListenerList.add(ButceTipiListener.class, listener);
	}
	
	public synchronized void removeButceTipiListener(ButceTipiListener listener) {
		butceTipiListenerList.remove(ButceTipiListener.class, listener);
	}
	
	public void fireLeftTreeRefreshedEvent(TreeRefreshedEvent event) {
		if (leftTreeListenerList == null) return;
		Object[] listeners =
				leftTreeListenerList.getListeners(LeftTreeListener.class);
		for (int i = 0 ; i<listeners.length; i++) {
			((LeftTreeListener)listeners[i]).refreshTree(event);
		}
	}
	
	public synchronized void addRightTreeRefreshedListener(RightTreeListener listener){
		if (rightTreeListenerList == null ) {
			rightTreeListenerList = new javax.swing.event.EventListenerList();
		}
		rightTreeListenerList.add(RightTreeListener.class, listener);
	}
	
	public synchronized void removeRightTreeRefreshedListener(RightTreeListener listener) {
		rightTreeListenerList.remove(RightTreeListener.class, listener);
	}
	
	public void fireRightTreeRefreshedEvent(TreeRefreshedEvent event) {
		if (rightTreeListenerList == null) return;
		Object[] listeners =
				rightTreeListenerList.getListeners(RightTreeListener.class);
		for (int i = 0 ; i<listeners.length; i++) {
			((RightTreeListener)listeners[i]).refreshTree(event);
		}
	}
	
	public void fireButceTipiChangedEvent(ButceTipiChangedEvent event) {
		if(butceTipiListenerList == null) return;
		Object[] listeners = butceTipiListenerList.getListeners(ButceTipiListener.class);
		for(int i = 0; i < listeners.length; i++) {
			((ButceTipiListener)listeners[i]).butceTipiChanged(event.getNewButceTipi());
		}
	}
}
