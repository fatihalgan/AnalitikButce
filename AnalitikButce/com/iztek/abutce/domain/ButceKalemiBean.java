/*
 * Created on 12.Eki.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.iztek.abutce.domain;

import com.iztek.abutce.persister.ButceKalemiBeanPersister;
import com.iztek.abutce.util.money.Money;

/**
 * @author db2admin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ButceKalemiBean {

	/**
	 * 
	 */
	private int id;
	private String kod;
	private String tanim;
	private int yil;
	private int level;
	private Money odenek;
	private Money odenekSayman;
	private Money odenekBaskan;
	private Money odenekEncumen;
	private boolean left;
	private boolean right;
	private boolean leaf;
	private String rootToPath;
	
	
	public ButceKalemiBean() {
		super();
	}
	
	
	/**
	 * @return Returns the rootToPath.
	 */
	public String getRootToPath() {
		return rootToPath;
	}
	/**
	 * @param rootToPath The rootToPath to set.
	 */
	public void setRootToPath(String rootToPath) {
		this.rootToPath = rootToPath;
	}
	/**
	 * @return Returns the leaf.
	 */
	public boolean isLeaf() {
		return leaf;
	}
	/**
	 * @param leaf The leaf to set.
	 */
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	/**
	 * @return Returns the left.
	 */
	public boolean isLeft() {
		return left;
	}
	/**
	 * @param left The left to set.
	 */
	public void setLeft(boolean left) {
		this.left = left;
	}
	/**
	 * @return Returns the right.
	 */
	public boolean isRight() {
		return right;
	}
	/**
	 * @param right The right to set.
	 */
	public void setRight(boolean right) {
		this.right = right;
	}
	public static ButceKalemiBeanPersister getPersister() {
		return new ButceKalemiBeanPersister();
	}
	
	public ButceKalemiBean(int id, String kod, String tanim, int level) {
		this.id = id;
		this.kod = kod;
		this.tanim = tanim;
		this.level = level;
	}
	
	public ButceKalemiBean(String kod, String tanim, int level) {
		this.kod = kod;
		this.tanim = tanim;
		this.level = level;
	}
	
	/**
	 * @return Returns the level.
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level The level to set.
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return
	 */
	public Money getOdenek() {
		return odenek;
	}

	/**
	 * @return
	 */
	public Money getOdenekBaskan() {
		return odenekBaskan;
	}

	/**
	 * @return
	 */
	public Money getOdenekEncumen() {
		return odenekEncumen;
	}

	/**
	 * @return
	 */
	public Money getOdenekSayman() {
		return odenekSayman;
	}

	/**
	 * @return
	 */
	public int getYil() {
		return yil;
	}

	/**
	 * @param decimal
	 */
	public void setId(int decimal) {
		id = decimal;
	}

	/**
	 * @param money
	 */
	public void setOdenek(Money money) {
		odenek = money;
	}

	/**
	 * @param money
	 */
	public void setOdenekBaskan(Money money) {
		odenekBaskan = money;
	}

	/**
	 * @param money
	 */
	public void setOdenekEncumen(Money money) {
		odenekEncumen = money;
	}

	/**
	 * @param money
	 */
	public void setOdenekSayman(Money money) {
		odenekSayman = money;
	}

	/**
	 * @param i
	 */
	public void setYil(int i) {
		yil = i;
	}
	
	public String toString() {
		try {
			return getKod() + " " + getTanim();
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public String getKod() {
		return kod;
	}

	/**
	 * @return Returns the tanim.
	 */
	public String getTanim() {
		return tanim;
	}
	/**
	 * @param tanim The tanim to set.
	 */
	public void setTanim(String tanim) {
		this.tanim = tanim;
	}
	/**
	 * @param kod The kod to set.
	 */
	public void setKod(String kod) {
		this.kod = kod;
	}
	
}
