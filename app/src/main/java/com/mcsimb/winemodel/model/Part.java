package com.mcsimb.winemodel.model;

import com.mcsimb.winemodel.util.MathUtils;

import java.util.Date;

public class Part {

	private final Date mDate;
	private final Sort mSort;
	private final Volume mVolume;
	private final int mCounter1;
	private final int mCounter2;
	private final Filtering mFiltering;
	private final Bottling mBottling;

	public Part(Date date, Sort sort, Volume volume, int counter1, int counter2) {
		mDate = date;
		mSort = sort;
		mVolume = volume;
		mCounter1 = counter1;
		mCounter2 = counter2;
		mFiltering = new Filtering(this);
		mBottling = new Bottling(this);
	}

	public boolean isValidCounters() {
		return mCounter1 > mCounter2;
	}

	public float getDal1() {
		return MathUtils.floor2(mCounter1 * mVolume.getDal());
	}

	public float getDal2() {
		return MathUtils.floor2(mCounter2 * mVolume.getDal());
	}

	public Volume getVolume() {
		return mVolume;
	}

	public Filtering getFiltering() {
		return mFiltering;
	}

	public Bottling getBottling() {
		return mBottling;
	}

}
