package com.topu.pldriodplayerdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.topu.pldriodplayerdemo.fragment.MainListFragment;
import com.topu.pldriodplayerdemo.fragment.MainReviewFragment;

/**
 * Created by shituocheng on 2017/1/9.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    int number;

    public MainViewPagerAdapter(FragmentManager fm, int number) {
        super(fm);
        this.number = number;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                MainListFragment mainListFragment = new MainListFragment();
                return mainListFragment;

            case 1:
                MainReviewFragment mainReviewFragment = new MainReviewFragment();
                return mainReviewFragment;

            default:
                return null;
        }
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return number;
    }
}
