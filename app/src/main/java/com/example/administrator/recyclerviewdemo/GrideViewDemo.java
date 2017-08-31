package com.example.administrator.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
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
public class GrideViewDemo extends Activity {
    @BindView(R.id.gridview)
    GridView gridview;
    @BindView(R.id.activity_grideview)
    LinearLayout activityGrideview;
    private ArrayList<String> list;
    private MyAdapter mMyAdapter;
    private ViewHolder viewHolder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grideview);
        ButterKnife.bind(this);

        list = new ArrayList<>();
        for (int i=0;i<=50;i++){
            list.add("玩转布局");
        }

        if (mMyAdapter==null){
            mMyAdapter = new MyAdapter();
            gridview.setAdapter(mMyAdapter);
        }
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                viewHolder = new ViewHolder();
                convertView = getLayoutInflater().inflate(R.layout.item_listview, null);
                viewHolder.mTextView = (TextView) convertView.findViewById(R.id.text_view);
                viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.image);
                convertView.setTag(viewHolder);
            }else{
                viewHolder= (ViewHolder) convertView.getTag();
            }
            Glide.with(GrideViewDemo.this).load(Images.imageUrls[position]).placeholder(R.drawable.splash).error(R.drawable.error).into(viewHolder.mImageView);
            viewHolder.mTextView.setText(list.get(position));
            return convertView;
        }
    }

    public class ViewHolder{
        TextView mTextView;
        ImageView mImageView;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
