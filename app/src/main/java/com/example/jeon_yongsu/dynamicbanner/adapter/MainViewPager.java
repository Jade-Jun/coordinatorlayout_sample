package com.example.jeon_yongsu.dynamicbanner.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.jeon_yongsu.dynamicbanner.HomeFragment;
import com.example.jeon_yongsu.dynamicbanner.RecyclerFragment;

import java.util.Vector;

/**
 * Created by SuYa on 2017. 4. 7..
 */

public class MainViewPager extends FragmentPagerAdapter {

    Vector<String> _tab_names = new Vector<String>();

    public MainViewPager(FragmentManager fm, Vector<String> names) {
        super(fm);

        _tab_names = names;
    }

    @Override
    public Fragment getItem(int index) {

        String tabName = _tab_names.get(index);

        if (tabName.equalsIgnoreCase("홈")) {
            HomeFragment fragment = new HomeFragment();
            return fragment;
        } else {
            RecyclerFragment fragment = new RecyclerFragment();
            return fragment;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return _tab_names.get(position);
    }

    @Override
    public int getCount() {
        return _tab_names.size();
    }

}
