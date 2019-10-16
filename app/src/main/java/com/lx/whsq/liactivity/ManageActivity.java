package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class ManageActivity extends BaseActivity implements View.OnClickListener{

    private LinearLayout ll_commodity,ll_order;


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_manage);
        setTopTitle("店铺管理");
        ll_commodity = findViewById(R.id.ll_commodity);
        ll_order = findViewById(R.id.ll_order);
    }

    @Override
    protected void initEvent() {
        ll_commodity.setOnClickListener(this);
        ll_order.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_commodity://商品管理
                Intent intent = new Intent(ManageActivity.this,CommodityActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_order://订单管理
                Intent intent1 = new Intent(ManageActivity.this,OrderActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
