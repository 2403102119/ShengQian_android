package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class DeliverActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_login;
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_deliver);
        setTopPrimaryColor(TOP_PRIMARY_COLOR);
        setTopTitle("订单详情");
        tv_login = findViewById(R.id.tv_login);
    }

    @Override
    protected void initEvent() {
        tv_login.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login:
                Intent intent = new Intent(DeliverActivity.this,Order_detalActivity.class);
                startActivity(intent);
                break;
        }
    }
}
