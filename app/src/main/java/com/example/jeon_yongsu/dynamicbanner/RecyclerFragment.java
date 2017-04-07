package com.example.jeon_yongsu.dynamicbanner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jeon_yongsu.dynamicbanner.adapter.RecyclerAdapter;

import java.util.ArrayList;

/**
 * Created by SuYa on 2017. 4. 6..
 */

public class RecyclerFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        init(rootView);

        return rootView;
    }

    void init(View view) {

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager((recyclerView.getContext())));

        adapter = new RecyclerAdapter(getActivity(), getDfalutItems());

        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                switch (adapter.getItemViewType(position)) {
                    case RecyclerAdapter.TYPE_HEADER:
                        return 3;
                    case RecyclerAdapter.TYPE_FOOTER:
                        return 3;
                    default:
                        return 1;
                }
            }
        });
        recyclerView.setLayoutManager(layoutManager);

    }

    ArrayList<String> getDfalutItems() {
        ArrayList<String> items = new ArrayList<>();

        for (int i=0; i<200; i++) {
            String item = "text_" + i;
            items.add(item);
        }
        return items;

    }

}
