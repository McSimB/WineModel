package com.mcsimb.winemodel.util;

public class MathUtils {

    public static float floor1(float val) {
		return (float)Math.floor(val * 10) / 10.0f;
	}
	
	public static float floor2(float val) {
		return (float)Math.floor(val * 100) / 100.0f;
	}

}
