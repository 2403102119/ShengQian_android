package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;


public class ProductActivity extends BaseActivity implements View.OnClickListener{

    private TextView tv_submit;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_product);
        setTopTitle("申请单品代理");
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
            case R.id.tv_submit://提交申请
                Intent intent = new Intent(ProductActivity.this,PayActivity.class);
                startActivity(intent);
                break;
        }
    }
}
