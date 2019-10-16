package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;
import com.lx.whsq.common.MainActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private TextView tv_login,tv_forget,tv_regist;
    private ImageView im_wechat;
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_login);
        baseTop.setVisibility(View.GONE);
        tv_login = findViewById(R.id.tv_login);
        tv_forget = findViewById(R.id.tv_forget);
        tv_regist = findViewById(R.id.tv_regist);
        im_wechat = findViewById(R.id.im_wechat);
    }

    @Override
    protected void initEvent() {
        tv_login .setOnClickListener(this);
        tv_forget .setOnClickListener(this);
        tv_regist .setOnClickListener(this);
        im_wechat .setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login://登录
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_forget://忘记密码
                Intent intent1 = new Intent(LoginActivity.this,ForgetActivity.class);
                intent1.putExtra("type","2");
                startActivity(intent1);
                break;
            case R.id.tv_regist://注册
                Intent intent2 = new Intent(LoginActivity.this,RegistActivity.class);
                startActivity(intent2);
                break;
            case R.id.im_wechat://绑定手机号
                Intent intent3 = new Intent(LoginActivity.this,BindingActivity.class);
                intent3.putExtra("type","login");
                startActivity(intent3);
                break;
        }
    }
}
