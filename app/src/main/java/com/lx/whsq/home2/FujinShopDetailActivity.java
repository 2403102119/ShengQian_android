package com.lx.whsq.home2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class FujinShopDetailActivity extends BaseActivity {


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fujinshopdetail_activity);
        init();
    }

    private void init() {
        ImageView finishBack = findViewById(R.id.finishBack);
        TextView titleName = findViewById(R.id.titleName);
        finishBack.setVisibility(View.VISIBLE);
        finishBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleName.setText("附近商家----进入的详情页面");


    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }
}
