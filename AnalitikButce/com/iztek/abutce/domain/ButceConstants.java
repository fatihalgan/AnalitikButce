package com.iztek.abutce.domain;

public class ButceConstants {
	
	public static final int GELIR = 0;
	public static final int GIDER = 1;
	
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	
	public static final int BUTCE_YILI=2005;
	
	public static String getTableName(int level, int islemTipi, int butceTipi) {
		if(islemTipi == LEFT) {
			if(level <=4) return "KURUMSAL_SINIFLAR";
			else if (level <= 8) return "FONKSIYONEL_SINIFLAR";
			else if(level == 9) return "FINANSAL_SINIFLAR";
			else { 
				if(butceTipi == GIDER) {
					return "EKONOMIK_SINIFLAR";
				} else if(butceTipi == GELIR) {
					return "GELIR_SINIFLARI";
				}
			}
		} else if(islemTipi == RIGHT) {
			if(butceTipi == GIDER) {
				return "GIDERLER";
			} else if(butceTipi == GELIR) {
				return "GELIRLER";
			}
		}
		return null;
	}
}