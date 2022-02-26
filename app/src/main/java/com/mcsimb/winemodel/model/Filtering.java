package com.mcsimb.winemodel.model;

import com.mcsimb.winemodel.util.MathUtils;

public class Filtering {

	private final Part mPart;

	public Filtering(Part part) {
		mPart = part;
	}

	public float getLoss() {
		return MathUtils.floor1(Income.getIncome(mPart) * Production.FILTERING_LOSS / 100f);
	}

	public float getIncome() {
		return Income.getIncome(mPart);
	}

	public float getExpense() {
		return Income.getIncome(mPart) + getLoss();
	}

}
