package com.mcsimb.winemodel.model;

public class Sort {

	private final String mName;
	private final long mLabelId;

	public Sort(String name, long labelId) {
		mName = name;
		mLabelId = labelId;
	}

	public String getName() {
		return mName;
	}

	public long getLabelId() {
		return mLabelId;
	}

}
