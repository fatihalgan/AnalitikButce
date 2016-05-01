package com.iztek.abutce.domain;
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
public class UIBroker {
	
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	
	private static int side = 0;

	/**
	 * @return
	 */
	public static int getSide() {
		return side;
	}

	/**
	 * @param i
	 */
	public static void setSide(int i) {
		side = i;
		if(side==0)System.out.println("Side is left!");
		else System.out.println("Side is right!");
	}

}
