package com.example.administrator.recyclerviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.administrator.rxjavademo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/30.
 */

public class ChooseActivity extends Activity {

    @BindView(R.id.recycle_button1)
    Button recycleButton1;
    @BindView(R.id.recycle_button2)
    Button recycleButton2;
    @BindView(R.id.recycle_button3)
    Button recycleButton3;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ButterKnife.bind(this);
    }


@OnClick({R.id.recycle_button1,R.id.recycle_button2,R.id.recycle_button3})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recycle_button1:
                Log.e("mrgao", "dianjile");
                startActivity(new Intent(ChooseActivity.this, ListViewDemo.class));
                break;
            case R.id.recycle_button2:
                startActivity(new Intent(ChooseActivity.this, GrideViewDemo.class));
                break;
            case R.id.recycle_button3:
                startActivity(new Intent(ChooseActivity.this, RecyClerViewDemo.class));
                break;
        }
    }
}
