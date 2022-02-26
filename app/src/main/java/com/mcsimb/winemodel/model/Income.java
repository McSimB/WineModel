package com.mcsimb.winemodel.model;

import com.mcsimb.winemodel.util.MathUtils;

public class Income {

	private static float mLab;

	public static float getLab(Part part) {
		getIncome(part);
		return mLab;
	}

	public static float getIncome(Part part) {
		mLab = 0;
		if (!part.isValidCounters()) {
			mLab = 0;
			return part.getDal2();
		}

		float div = part.getVolume().getDivPercent();
		float dal1 = part.getDal1();
		float dal2 = part.getDal2();
		float income = MathUtils.floor1(dal1 * 100.0f / (100.0f - div));
		income = Math.max(income, dal1);

		// Разница между фактическими и нормативными потерями по цеху розлива
		float diff = (income - dal2 - mLab) - (dal2 * Production.BOTTLING_LOSS / 100.0f);
		if (diff > 0) {
			if (income - dal1 > diff) {
				income = Math.max(MathUtils.floor1(income - diff), part.getDal1());
			}
		}

		mLab = income - dal1 >= part.getVolume().getDal() ? part.getVolume().getDal() : 0;
		return income;
	}

}
