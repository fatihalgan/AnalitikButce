/*
 * Created on 17.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.abutce.event;

import java.util.EventListener;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface RightTreeListener extends EventListener {
	
	public void refreshTree(TreeRefreshedEvent event);

}
