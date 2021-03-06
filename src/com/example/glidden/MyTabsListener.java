package com.example.glidden;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.util.Log;

/**
 * Swaps fragments based on the tab that is selected.
 * @author alexdrawbond
 */
public class MyTabsListener implements ActionBar.TabListener {
	public Fragment fragment;
	String TAG = "MyTabsListener";
	
	public MyTabsListener(Fragment fragment) {
		Log.e(TAG, "Here!!!");
		this.fragment = fragment;
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		ft.replace(R.id.fragment_placeholder, fragment);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.remove(fragment);
	}

}
