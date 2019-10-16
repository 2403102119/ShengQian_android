package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class WalletActivity extends BaseActivity implements View.OnClickListener{

    private TextView tv_withdraw;
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_wallet);
        setTopTitle("我的钱包");
        rightText.setVisibility(View.VISIBLE);
        rightText.setText("账单记录");

        tv_withdraw = findViewById(R.id.tv_withdraw);
    }

    @Override
    protected void initEvent() {
        rightText.setOnClickListener(this);
        tv_withdraw.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rightText://账单记录
                Intent intent = new Intent(WalletActivity.this, RecordActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_withdraw://提现
                Intent intent1 = new Intent(WalletActivity.this,WithdrawActivity.class);
                startActivity(intent1);
                break;
        }

    }
}
