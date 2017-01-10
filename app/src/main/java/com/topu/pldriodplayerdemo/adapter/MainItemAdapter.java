package com.topu.pldriodplayerdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.topu.pldriodplayerdemo.R;
import com.topu.pldriodplayerdemo.activity.FullScreenVideoActivity;
import com.topu.pldriodplayerdemo.utils.OnRecyclerViewOnClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shituocheng on 2017/1/9.
 */

public class MainItemAdapter extends RecyclerView.Adapter {

    private List<String> data = new ArrayList<>();

    private OnRecyclerViewOnClickListener mListener;
    private Context mContext;

    public MainItemAdapter(List<String> data) {
        this.data = data;
    }

    public MainItemAdapter(List<String> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView itemTextView;
        private CardView cardView;
        private OnRecyclerViewOnClickListener listener;
        public ItemViewHolder(View itemView, OnRecyclerViewOnClickListener listener) {
            super(itemView);
            itemTextView = (TextView)itemView.findViewById(R.id.itemNum_textView);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
        }

        @Override
        public void onClick(View view) {
            if (listener != null){
                listener.OnItemClick(view,getLayoutPosition());
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(v, mListener);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        TextView itemTextV = ((ItemViewHolder)holder).itemTextView;
        final CardView cardView = ((ItemViewHolder)holder).cardView;
        final String title = data.get(position);
        itemTextV.setText(title);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.modrails.com/videos/passenger_nginx.mov";
                Intent intent = new Intent(mContext, FullScreenVideoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                intent.putExtra("videoUrl", url);
                intent.putExtra("videoTitle", title);
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

    public void setItemClickListener(OnRecyclerViewOnClickListener listener){
        this.mListener = listener;
    }
}
