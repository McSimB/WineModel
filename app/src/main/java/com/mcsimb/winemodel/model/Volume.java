package com.mcsimb.winemodel.model;

public class Volume {

	/* Объем тары для розлива продукции, дал */
	private final float mDal;
	/* Процент расхождения продукции между первым счетчиком и кол-вом, что поступило по
	накладной */
	private final float mDivergencyPercent;

	public Volume(float dal, float divergencyPercent) {
		mDal = dal;
		mDivergencyPercent = divergencyPercent;
	}

	public float getDal() {
		return mDal;
	}

	public float getDivPercent() {
		return mDivergencyPercent;
	}

}
