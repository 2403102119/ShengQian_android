package com.lx.whsq.home1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class BianjiChengCheRenActivity extends BaseActivity {
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.bianjichengcheren_activity);
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
        titleName.setText("编辑乘车人");
        TextView tuiJianTV = findViewById(R.id.tuiJianTV);
        tuiJianTV.setVisibility(View.VISIBLE);
        tuiJianTV.setTextSize(16);
        tuiJianTV.setText("确定");
        tuiJianTV.setTextColor(getResources().getColor(R.color.rightTV));
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }
}
