package com.agriculture;

import com.agriculture.fragment.FruitsFragment;
import com.agriculture.fragment.ProducedMaterialFragment;
import com.agriculture.fragment.VegetablesFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

	public MyAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		Fragment fragment = null;
		if (arg0 == 0) {
			fragment = new FruitsFragment();
		}
		if (arg0 == 1) {
			fragment = new VegetablesFragment();
		}
		if (arg0 == 2) {
			fragment = new ProducedMaterialFragment();
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return 3;
	}
}
