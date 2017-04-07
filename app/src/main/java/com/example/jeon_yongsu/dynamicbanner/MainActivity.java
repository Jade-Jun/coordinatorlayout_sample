package com.example.jeon_yongsu.dynamicbanner;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.jeon_yongsu.dynamicbanner.adapter.BannerPagerAdapter;
import com.example.jeon_yongsu.dynamicbanner.adapter.CustomPagerAdapter;
import com.example.jeon_yongsu.dynamicbanner.adapter.MainViewPager;
import com.example.jeon_yongsu.dynamicbanner.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayer();
    }

    private void initLayer() {
        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);

        Vector<String> tabNames = new Vector<>();
        tabNames.add("홈");
        tabNames.add("요일");

        pager.setOffscreenPageLimit(2);
        MainViewPager mainViewPager = new MainViewPager(getSupportFragmentManager(), tabNames);
        pager.setAdapter(mainViewPager);
    }

}
