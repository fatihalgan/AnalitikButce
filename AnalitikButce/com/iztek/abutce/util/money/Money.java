package com.iztek.abutce.util.money;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;

public class Money {
	private static final double fractionDigit = ConvertionRatio.FRACTION_DIGIT;
	
	private double amount;
	private String unit;
	
	private Money() {
	}
		
	public Money(double amount, String unit) {
		this.amount = amount;
		this.unit = unit;
	}
				
	public double getAmount() {
		return amount;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setAmount(double d) {
		amount = d;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
		
	public Money convertTo(String u) {
		double ratio = ConvertionRatio.getRatio(unit, u);
		ratio = Math.round((amount * ratio*fractionDigit))/fractionDigit;
		return new Money(ratio, u);
	}
	
	private void checkSameUnitAs(Money m) throws MoneyException{
		if(m == null || !m.getUnit().equals(unit)) {
			throw new MoneyException();
		}			
	}
	
	public Money add(Money other) throws MoneyException {
		checkSameUnitAs(other); 
		return new Money(amount + other.amount, unit);	
	}
	
	public Money subtract(Money other) throws MoneyException {
		checkSameUnitAs(other); 
		return new Money(amount - other.amount, unit);
	}
	
	public Money multiply(double d) {
		return new Money(amount * d, unit);
	}
	
	public Money divide(double d) {
		return new Money(amount / d, unit);
	}

	static NumberFormat nf = NumberFormat.getInstance();
	static {
		if (nf instanceof DecimalFormat) {
			DecimalFormat format = (DecimalFormat) nf;
			format.applyPattern("#,###.##");
		}
	}
	
	public String toString() {
		Currency currency = Currency.getInstance(new java.util.Locale("en", "US")); 
		nf.setCurrency(currency);
		nf.setMinimumFractionDigits(currency.getDefaultFractionDigits());
		nf.setMaximumFractionDigits(currency.getDefaultFractionDigits());
		return nf.format(getAmount())+" "+unit;
	}
	
	public boolean equals(Object other) {
		return (other instanceof Money) && equals((Money) other);
	}

	public boolean equals(Money other) {
		return unit.equals(other.unit) && (amount == other.amount);
	}
	
	public int compareTo(Object other) throws MoneyException {
		return compareTo((Money) other);
	}
	
	public int compareTo(Money other) throws MoneyException {
		checkSameUnitAs(other);
		if (amount < other.amount)
			return -1;
		else if (amount == other.amount)
			return 0;
		else
			return 1;
	}
	
	public boolean greaterThan(Money other) throws MoneyException {
		return (compareTo(other) > 0);
	}
	
	public boolean lessThan(Money other) throws MoneyException {
		return (compareTo(other) < 0);
	}
	
	public String getAmountAsString() {
		NumberFormat numberFormat = NumberFormat.getInstance();
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
		decimalFormat.applyPattern("#");
		
		String amountAsString = decimalFormat.format(amount);
		if(amount == 0) {
			if(unit.equals(Unit.TL)) {
				amountAsString = "0";
			}else if(unit.equals(Unit.YTL)) {
				amountAsString = "0.00";
			}
		}
		
		return amountAsString;
	}
}
