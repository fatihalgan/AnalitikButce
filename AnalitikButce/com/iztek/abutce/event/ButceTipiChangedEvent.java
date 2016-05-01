/*
 * Created on 19.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.abutce.event;

import java.util.EventObject;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ButceTipiChangedEvent extends EventObject {

	private int newButceTipi;
	/**
	 * @param source
	 */
	public ButceTipiChangedEvent(Object source, int newButceTipi) {
		super(source);
		this.newButceTipi = newButceTipi;
	}

	/**
	 * @return Returns the newButceTipi.
	 */
	public int getNewButceTipi() {
		return newButceTipi;
	}
	
}
