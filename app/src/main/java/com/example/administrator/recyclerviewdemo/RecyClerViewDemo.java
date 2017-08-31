package com.example.administrator.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.rxjavademo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/30.
 */
public class RecyClerViewDemo extends Activity {
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.activity_recyclerview)
    LinearLayout activityRecyclerview;
    private ArrayList<String> mDatas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
        initData();
        //设置布局管理器
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(new HomeAdapter());
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }

    private class HomeAdapter extends RecyclerView.Adapter<RecyClerViewDemo.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(RecyClerViewDemo.this).inflate(R.layout.item_recyclerview,parent,false));
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.mTextView.setText(mDatas.get(position));
            Glide.with(RecyClerViewDemo.this).load(Images.imageUrls[position]).placeholder(R.drawable.splash).error(R.drawable.error).into(holder.mImageView);
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }


    }

    private class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView mImageView;
        private final TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_recycler);
            mTextView = (TextView) itemView.findViewById(R.id.text_view_recycler);
        }
    }
}
