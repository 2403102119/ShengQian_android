package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.view.View;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class RedactActivity extends BaseActivity implements View.OnClickListener{



    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_redact);
        setTopTitle("编辑优惠券");
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}
