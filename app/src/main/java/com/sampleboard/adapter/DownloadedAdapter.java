package com.sampleboard.adapter;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sampleboard.R;

import java.util.List;

/**
 * Created by Anuj Sharma on 4/5/2017.
 */

public class DownloadedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<String> list;
    Context context;
    public DownloadedAdapter(Context ctx, List<String> listing){
        this.context = ctx;
        this.list = listing;
    }
    public void updateData(List<String> jobsList) {
        this.list = jobsList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_downloaded,parent,false);
        DownloadedHolder vh = new DownloadedHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DownloadedHolder){
            DownloadedHolder vh = (DownloadedHolder)holder;
            vh.mJobId.setText("123");
            vh.mJobTitle.setText(list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return (list==null)?0:list.size();
    }



    private class DownloadedHolder extends RecyclerView.ViewHolder{
        CardView parentView;
        TextView mJobId,mJobTitle;

        public DownloadedHolder(View itemView) {
            super(itemView);
            mJobId = (TextView)itemView.findViewById(R.id.jobID);
            mJobTitle = (TextView)itemView.findViewById(R.id.jobTitle);
        }
    }
}