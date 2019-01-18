package com.example.shoucang;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private List<Welfare.ResultsBean> beanList;
    private Context context;

    public MyAdapter(List<Welfare.ResultsBean> beanList, Context context) {
        this.beanList = beanList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup,false);
        MyViewHolder mvh = new MyViewHolder(view);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof MyViewHolder){
            MyViewHolder mvh = (MyViewHolder) viewHolder;
            mvh.tv.setText(beanList.get(i).getType());
            Glide.with(context).load(beanList.get(i).getUrl()).into(mvh.img);

        }
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv;
        public ImageView img;

        public MyViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.img = (ImageView) rootView.findViewById(R.id.img);
        }
    }
}
