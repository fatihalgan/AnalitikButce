package com.iztek.abutce.util.money;

public class ConvertionRatio {
	public static final double FRACTION_DIGIT = 100.0;
	
	private static final double TLtoYTL = 0.000001;
	private static final double YTLtoTL = 1000000;
		
	public static double getRatio(String u1, String u2) {
		String key = u1+"to"+u2;
		if(key.equals("TLtoYTL")) {
			return TLtoYTL;
		}else if(key.equals("YTLtoTL")) {
			return YTLtoTL;
		}else {
			return 1;
		}
	}
}
