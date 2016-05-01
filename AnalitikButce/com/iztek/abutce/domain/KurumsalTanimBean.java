/*
 * Created on 11.Eki.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.iztek.abutce.domain;

import java.math.BigDecimal;

/**
 * @author Selim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class KurumsalTanimBean {

	private BigDecimal id;
	private String tanim;
	private String kod;
	private int level;
	private boolean configured;
	private boolean selected;
	
	public KurumsalTanimBean(BigDecimal id, String tanim, String kod, int level,
	boolean configured, boolean selected) {
		this.id = id;
		this.tanim = tanim;
		this.kod = kod;
		this.level = level;
		this.configured = configured;
		this.selected = selected;
	}
	
	public KurumsalTanimBean() {
		super();
	}
	/**
	 * @return
	 */
	public BigDecimal getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getKod() {
		return kod;
	}

	/**
	 * @return
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @return
	 */
	public String getTanim() {
		return tanim;
	}

	/**
	 * @param decimal
	 */
	public void setId(BigDecimal decimal) {
		id = decimal;
	}

	/**
	 * @param string
	 */
	public void setKod(String string) {
		kod = string;
	}

	/**
	 * @param i
	 */
	public void setLevel(int i) {
		level = i;
	}

	/**
	 * @param string
	 */
	public void setTanim(String string) {
		tanim = string;
	}
	
	public String toString() {
		return kod + " " + tanim;
	}

	/**
	 * @return
	 */
	public boolean isConfigured() {
		return configured;
	}

	/**
	 * @return
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param b
	 */
	public void setConfigured(boolean b) {
		configured = b;
	}

	/**
	 * @param b
	 */
	public void setSelected(boolean b) {
		selected = b;
	}

}
