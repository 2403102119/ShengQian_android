package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;


public class GiftActivity extends BaseActivity implements View.OnClickListener{

   private TextView tv_submit;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_gift);
        setTopTitle("申请赠送单品代理");
        tv_submit = findViewById(R.id.tv_submit);
    }

    @Override
    protected void initEvent() {
        tv_submit.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_submit:
                Intent intent = new Intent(GiftActivity.this,PayActivity.class);
                startActivity(intent);
            break;
        }
    }
}
