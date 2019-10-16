package com.lx.whsq.home1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class HuoChePiaoActivity extends BaseActivity {
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.huochepiao_activity);
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
        titleName.setText("火车票");
        TextView tuiJianTV = findViewById(R.id.tuiJianTV);
        tuiJianTV.setVisibility(View.VISIBLE);
        tuiJianTV.setTextSize(16);
        tuiJianTV.setText("订单查询");
        tuiJianTV.setTextColor(getResources().getColor(R.color.rightTV));
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }
}
