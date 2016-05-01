package com.iztek.abutce.domain;


public class RaporBean {
	private int tip;
	private int yil;
	private boolean isPdf = true;
	private boolean isSayman = true;
	private boolean isBaskan = true;
	private boolean isEncumen = true;
	private String outputPath = null;
	
	public RaporBean(int tip, int yil, boolean isPdf, boolean isSayman) {
		this.tip = tip;
		this.yil = yil;
		this.isPdf = isPdf;
		this.isSayman = isSayman;
	}
		
	public RaporBean(
		int tip, int yil, boolean isPdf, boolean isSayman, 
		boolean isBaskan, boolean isEncumen)
	{
		this(tip, yil, isPdf, isSayman);
		this.isBaskan = isBaskan;
		this.isEncumen = isEncumen;
	}
	
	public boolean isBaskan() {
		return isBaskan;
	}

	public boolean isEncumen() {
		return isEncumen;
	}

	public boolean isSayman() {
		return isSayman;
	}

	public int getTip() {
		return tip;
	}

	public int getYil() {
		return yil;
	}

	public void setBaskan(boolean b) {
		isBaskan = b;
	}

	public void setEncumen(boolean b) {
		isEncumen = b;
	}

	public void setSayman(boolean b) {
		isSayman = b;
	}

	public void setTip(int i) {
		tip = i;
	}

	public void setYil(int i) {
		yil = i;
	}
	
	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String string) {
		outputPath = string;
	}
	
	public boolean isPdf() {
		return isPdf;
	}

	public void setPdf(boolean b) {
		isPdf = b;
	}

}