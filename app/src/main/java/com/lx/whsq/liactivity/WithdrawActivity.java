package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class WithdrawActivity extends BaseActivity implements View.OnClickListener{


    private TextView tv_login;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_withdraw);
        setTopTitle("提现");
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
            case R.id.tv_login://提现
                Intent intent = new Intent(WithdrawActivity.this,AuditActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
