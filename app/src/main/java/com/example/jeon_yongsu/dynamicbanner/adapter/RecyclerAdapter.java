package com.example.jeon_yongsu.dynamicbanner.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jeon_yongsu.dynamicbanner.R;

import java.util.ArrayList;

/**
 * Created by SuYa on 2017. 4. 6..
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;
    public static final int TYPE_FOOTER = 2;

    Activity activity;
    ArrayList<String> titles;

    private View header_view;
    private View footer_view;
    private int header_view_count = 0, footer_view_count = 0;

    public RecyclerAdapter(Activity activity, ArrayList<String> items) {

        this.activity = activity;
        this.titles = items;

    }

    public boolean IsHeaderUsed(int position) {

        if (this.header_view_count == 0)
            return false;

        if ((this.header_view_count-1) >= position)
            return true;

        return false;
    }

    public boolean IsFooterUsed(int position) {

        if (this.footer_view_count == 0) {
            return false;
        }

        int _footer_position = this.titles.size() + this.header_view_count;

        if (_footer_position > position) {
            return false;
        }

        return true;
    }

    @Override
    public int getItemViewType(int position) {

        if (IsHeaderUsed(position)) {
            return TYPE_HEADER;
        } else if (IsFooterUsed(position)) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return this.titles.size() + this.header_view_count + this.footer_view_count;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == TYPE_HEADER) {
            return new VHeader(header_view);
        }
        else if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new VHItem(view);
        }
        else if (viewType == TYPE_FOOTER) {
            return new VHFooter(this.footer_view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof VHeader) {
            VHeader vHeader = (VHeader) holder;
        } else if (holder instanceof VHFooter) {
            VHFooter vhFooter = (VHFooter) holder;
        } else {
            String item = this.titles.get(position - this.header_view_count);
            VHItem VHitem = (VHItem)holder;

            VHitem.title.setText(item);
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


    private static class VHeader extends RecyclerView.ViewHolder {
        public VHeader(View view) {
            super(view);
        }
    }

    private static class VHFooter extends RecyclerView.ViewHolder {
        public VHFooter(View view) {
            super(view);
        }
    }

    private static class VHItem extends RecyclerView.ViewHolder {

        TextView title;

        public VHItem(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
        }
    }

}
