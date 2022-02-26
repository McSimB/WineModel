package com.mcsimb.winemodel.model;

import java.util.ArrayList;
import java.util.List;

public class Production {

	public static float FILTERING_LOSS;
	public static float BOTTLING_LOSS;

	private final List<Blend> mBlends;

	public Production() {
		mBlends = new ArrayList<>();
	}

	public void addBlend(Blend blend) {
		mBlends.add(blend);
	}

	public List<Blend> getBlendsByName(String name) {
		List<Blend> blends = new ArrayList<>();
		for (Blend blend : mBlends) {
			if (blend.getName().equals(name)) {
				blends.add(blend);
			}
		}
		return blends;
	}

}
