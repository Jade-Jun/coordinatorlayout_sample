package com.example.jeon_yongsu.dynamicbanner.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.jeon_yongsu.dynamicbanner.WebviewFragment;

import java.util.ArrayList;

/**
 * Created by SuYa on 2017. 4. 6..
 */

public class CustomPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<String> tabNames;

    public CustomPagerAdapter(FragmentManager fm, ArrayList<String> tabNames) {
        super(fm);
        this.tabNames = tabNames;
    }

    @Override
    public Fragment getItem(int index) {
//        RecyclerFragment fragment = new RecyclerFragment();
        WebviewFragment fragment = new WebviewFragment();
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.tabNames.get(position);
    }

    @Override
    public int getCount() {
        return this.tabNames.size();
    }

}
