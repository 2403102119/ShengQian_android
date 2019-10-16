package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class GeneyActivity extends BaseActivity implements View.OnClickListener{


    private LinearLayout ll_synopsis,ll_wallet,ll_order,ll_commodity,ll_verification;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_geney);
        setTopPrimaryColor(TOP_PRIMARY_COLOR);
        view.setVisibility(View.GONE);
        setTopTitle("店铺管理");

        ll_synopsis = findViewById(R.id.ll_synopsis);
        ll_wallet = findViewById(R.id.ll_wallet);
        ll_order = findViewById(R.id.ll_order);
        ll_commodity = findViewById(R.id.ll_commodity);
        ll_verification = findViewById(R.id.ll_verification);
    }

    @Override
    protected void initEvent() {
        ll_synopsis.setOnClickListener(this);
        ll_wallet.setOnClickListener(this);
        ll_order.setOnClickListener(this);
        ll_commodity.setOnClickListener(this);
        ll_verification.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_synopsis://店铺简介
                Intent intent = new Intent(GeneyActivity.this,SynopsisActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_wallet://钱包
                Intent intent1 = new Intent(GeneyActivity.this,WalletActivity.class);
                startActivity(intent1);
                break;
            case R.id.ll_order://订单管理
                Intent intent2 = new Intent(GeneyActivity.this,VerificationActivity.class);
                startActivity(intent2);
                break;
            case R.id.ll_commodity://优惠券管理
                Intent intent3 = new Intent(GeneyActivity.this,CouponActivity.class);
                startActivity(intent3);
                break;
            case R.id.ll_verification://核销
//                Intent intent4 = new Intent(GeneyActivity.this,VerificationActivity.class);
//                startActivity(intent4);
                showToast("扫描二维码：核销");
                break;
        }
    }
}
