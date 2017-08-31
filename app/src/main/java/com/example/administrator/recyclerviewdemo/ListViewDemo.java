package com.example.administrator.recyclerviewdemo;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.rxjavademo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/30.
 */
public class ListViewDemo extends Activity {
    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.activity_listview)
    LinearLayout activityListview;
    private MyAdapter mMyAdapter;
    private ArrayList<String> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ButterKnife.bind(this);


        list = new ArrayList<>();
        for (int i=0;i<=50;i++){
            list.add("heiheihei");
        }

        if (mMyAdapter==null){
            mMyAdapter = new MyAdapter();
            listview.setAdapter(mMyAdapter);
        }else{

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
        ViewHolder viewHolder;
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
            Glide.with(ListViewDemo.this).load(Images.imageUrls[position]).placeholder(R.drawable.splash).error(R.drawable.error).into(viewHolder.mImageView);
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
