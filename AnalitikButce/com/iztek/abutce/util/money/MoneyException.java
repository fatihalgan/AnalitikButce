package com.iztek.abutce.util.money;

public class MoneyException extends Exception {
	
	public MoneyException () {
		super("Different type of units.");
	}
	
	public MoneyException (String s) {
		super(s);
	}
}