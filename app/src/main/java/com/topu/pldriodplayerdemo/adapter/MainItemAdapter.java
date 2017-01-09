package com.topu.pldriodplayerdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.topu.pldriodplayerdemo.R;
import com.topu.pldriodplayerdemo.activity.FullScreenVideoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shituocheng on 2017/1/9.
 */

public class MainItemAdapter extends RecyclerView.Adapter {

    private List<String> data = new ArrayList<>();

    private Context mContext;

    public MainItemAdapter(List<String> data) {
        this.data = data;
    }

    public MainItemAdapter(List<String> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder{

        private TextView itemTextView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            itemTextView = (TextView)itemView.findViewById(R.id.itemNum_textView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(v);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        TextView itemTextV = ((ItemViewHolder)holder).itemTextView;
        itemTextV.setText(data.get(position));
        itemTextV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.modrails.com/videos/passenger_nginx.mov";
                Intent intent = new Intent(mContext, FullScreenVideoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                intent.putExtra("videoUrl", url);
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0,
                                0);
                ActivityCompat.startActivity(mContext, intent, options.toBundle());
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
