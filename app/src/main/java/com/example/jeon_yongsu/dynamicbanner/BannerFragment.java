package com.example.jeon_yongsu.dynamicbanner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by SuYa on 2017. 4. 7..
 */

public class BannerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_banner, container, false);
        ImageView view = (ImageView)rootView.findViewById(R.id.image_view);
        view.setImageResource(R.drawable.ic_no_1);
        return rootView;
    }

}
