package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class Voucher_centerActivity extends BaseActivity implements View.OnClickListener{



    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_voucher_center);
        setTopTitle("充值中心");
        setTopPrimaryColor(TOP_PRIMARY_COLOR);
        rightText.setVisibility(View.VISIBLE);
        rightText.setText("充值记录");
        rightText.setTextColor(getResources().getColor(R.color.white));
    }

    @Override
    protected void initEvent() {
        rightText.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rightText://充值记录
                Intent intent = new Intent(Voucher_centerActivity.this,Recharge_recordActivity.class);
                startActivity(intent);
                break;
        }
    }
}
