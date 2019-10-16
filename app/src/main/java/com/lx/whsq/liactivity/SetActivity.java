package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;


public class SetActivity extends BaseActivity implements View.OnClickListener{

    private RelativeLayout rel1,rel2,rel3;
    private TextView logout;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_set);
        setTopTitle("设置");
        rel1 = findViewById(R.id.rel1);
        rel2 = findViewById(R.id.rel2);
        rel3 = findViewById(R.id.rel3);
        logout = findViewById(R.id.logout);

    }

    @Override
    protected void initEvent() {
        rel1.setOnClickListener(this);
        rel2.setOnClickListener(this);
        rel3.setOnClickListener(this);
        logout.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rel1://手机号修改
                Intent intent = new Intent(SetActivity.this,ForgetActivity.class);
                intent.putExtra("type","1");
                startActivity(intent);
                break;
            case R.id.rel2://密码修改
                Intent intent1 = new Intent(SetActivity.this,AmendActivity.class);
                startActivity(intent1);
                break;
            case R.id.rel3://收货地址管理
                Intent intent2 = new Intent(SetActivity.this,ShippingActivity.class);
                startActivity(intent2);
                break;
            case R.id.logout://退出登录
                Intent intent3 = new Intent(SetActivity.this,LoginActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
