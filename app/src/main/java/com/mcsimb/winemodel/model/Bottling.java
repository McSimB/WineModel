package com.mcsimb.winemodel.model;

import com.mcsimb.winemodel.util.MathUtils;

public class Bottling {

	private final Part mPart;

	public Bottling(Part part) {
		mPart = part;
	}

	public float getLab() {
		return Income.getLab(mPart);
	}

	public float getLoss() {
		return MathUtils.floor2(Income.getIncome(mPart) - mPart.getDal2() - getLab());
	}

}
