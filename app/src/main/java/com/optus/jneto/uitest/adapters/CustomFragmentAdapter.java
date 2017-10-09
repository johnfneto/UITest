package com.optus.jneto.uitest.adapters;

/**
 * Created by jneto on 10/8/17.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.optus.jneto.uitest.MainFragment;

public class CustomFragmentAdapter extends FragmentPagerAdapter {

    private static final int TOTAL_FRAGMENTS = 4;

    public CustomFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return TOTAL_FRAGMENTS;
    }

    @Override
    public Fragment getItem(int position) {
        return MainFragment.newInstance(position + 1);
    }
}
