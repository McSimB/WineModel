package com.mcsimb.winemodel;

import android.app.Application;

import com.mcsimb.winemodel.common.crash.CrashHandler;

public class App extends Application {

	private static App sApp;

	public static boolean isNightMode() {
		return getApp().getResources().getBoolean(R.bool.night_mode);
	}

	public static App getApp() {
		return sApp;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		sApp = this;
		CrashHandler.init(this);
	}

}
