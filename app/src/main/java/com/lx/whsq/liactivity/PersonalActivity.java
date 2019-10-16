package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;


public class PersonalActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout ll_amend,ll_bindin;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_personal);
        setTopTitle("个人信息");
        ll_amend = findViewById(R.id.ll_amend);
        ll_bindin = findViewById(R.id.ll_bindin);
    }

    @Override
    protected void initEvent() {
        ll_amend.setOnClickListener(this);
        ll_bindin.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_amend://修改昵称
                Intent intent = new Intent(PersonalActivity.this,Amend_sActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_bindin://修改手机号
                Intent intent1 = new Intent(PersonalActivity.this,BindingActivity.class);
                intent1.putExtra("type","set");
                startActivity(intent1);
                break;
        }
    }
}
