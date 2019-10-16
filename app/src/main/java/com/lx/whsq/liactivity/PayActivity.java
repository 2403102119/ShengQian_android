package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class PayActivity extends BaseActivity implements View.OnClickListener {
    private TextView tv_pay;
   private LinearLayout ll_alipy,tv_wechat;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_pay);
        setTopTitle("选择支付方式");
        setTopPrimaryColor(TOP_PRIMARY_COLOR);
        tv_pay = findViewById(R.id.tv_pay);
        ll_alipy = findViewById(R.id.ll_alipy);
        tv_wechat = findViewById(R.id.tv_wechat);

    }

    @Override
    protected void initEvent() {
        tv_pay.setOnClickListener(this);
        ll_alipy.setOnClickListener(this);
        tv_wechat.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_alipy:
                Intent intent = new Intent(PayActivity.this,Payment_successActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_wechat:
                Intent intent1 = new Intent(PayActivity.this,Payment_successActivity.class);
                startActivity(intent1);
                break;
        }

    }
}
