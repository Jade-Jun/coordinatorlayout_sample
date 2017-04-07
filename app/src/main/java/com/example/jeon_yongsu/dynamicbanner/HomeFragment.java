package com.example.jeon_yongsu.dynamicbanner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.jeon_yongsu.dynamicbanner.adapter.BannerPagerAdapter;
import com.example.jeon_yongsu.dynamicbanner.adapter.CustomPagerAdapter;

import java.util.ArrayList;

/**
 * Created by SuYa on 2017. 4. 7..
 */

public class HomeFragment extends Fragment implements View.OnClickListener{

    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        initLayer(rootView);

        return rootView;
    }

    void initLayer(View view) {
        ViewPager banner_pager = (ViewPager) view.findViewById(R.id.banner_pager);
        BannerPagerAdapter bannerPagerAdapter = new BannerPagerAdapter(getChildFragmentManager());
        banner_pager.setAdapter(bannerPagerAdapter);

        ArrayList<String> tabnames = new ArrayList<>();
        tabnames.add("page_1");
        tabnames.add("page_2");

        viewPager = (ViewPager) view.findViewById(R.id.view_pager);

        viewPager.setOffscreenPageLimit(2);
        CustomPagerAdapter adapter = new CustomPagerAdapter(getChildFragmentManager(), tabnames);

        viewPager.setAdapter(adapter);

        RadioButton btn1 = (RadioButton) view.findViewById(R.id.radio1);
        RadioButton btn2 = (RadioButton) view.findViewById(R.id.radio2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int vid = v.getId();

        if (vid == R.id.radio1) {
            viewPager.setCurrentItem(0);
        } else if (vid == R.id.radio2) {
            viewPager.setCurrentItem(1);
        }

    }
}
