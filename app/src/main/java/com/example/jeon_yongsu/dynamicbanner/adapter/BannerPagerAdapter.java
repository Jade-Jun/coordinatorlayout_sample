package com.example.jeon_yongsu.dynamicbanner.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.jeon_yongsu.dynamicbanner.BannerFragment;

import java.util.ArrayList;

/**
 * Created by SuYa on 2017. 4. 7..
 */

public class BannerPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragments = new ArrayList<>();

    public BannerPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        update();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = fragments.get(position);
        return frag;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public int getItemPosition(Object object) {
        //return super.getItemPosition(object);
        return POSITION_NONE;
    }

    void update() {
        fragments.clear();
        for (int i=0; i<3; i++) {
            BannerFragment fragment = new BannerFragment();
            fragments.add(fragment);
        }
    }

}
