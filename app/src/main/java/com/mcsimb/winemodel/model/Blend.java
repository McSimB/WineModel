package com.mcsimb.winemodel.model;

import com.mcsimb.winemodel.util.MathUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blend {

	private final Sort mSort;
	private final Date mCreateDate;
	private final float mRest;
	private final List<Part> mParts;

	public Blend(Date createDate, Sort sort, float dal) {
		mSort = sort;
		mCreateDate = createDate;
		mRest = dal;
		mParts = new ArrayList<>();
	}

	public void addPart(Part part) {
		mParts.add(part);
	}

	public String getName() {
		return mSort.getName();
	}

	public List<Part> getParts() {
		return mParts;
	}

	public float getRest() {
		return mParts.size() > 0 ? getRestForPart(mParts.get(mParts.size() - 1)) : mRest;
	}

	public float getRestForPart(Part part) {
		float rest = mRest;
		for (Part p : mParts) {
			rest -= p.getFiltering().getExpense();
			if (p.equals(part)) {
				return rest;
			}
		}
		return -1;
	}

	public float calcRestProduction() {
		return MathUtils.floor1(getRest() - calcRestLosses());
	}

	public float calcRestLosses() {
		float loss = Production.FILTERING_LOSS + Production.BOTTLING_LOSS;
		return MathUtils.floor1(getRest() * loss / 100.0f);
	}

}
