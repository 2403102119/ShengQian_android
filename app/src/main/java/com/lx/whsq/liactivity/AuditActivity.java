package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class AuditActivity extends BaseActivity implements View.OnClickListener{


    private TextView tv_return;
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_audit);
        setTopPrimaryColor(TOP_PRIMARY_COLOR);
        setTopTitle("提现审核");
        tv_return = findViewById(R.id.tv_return);
    }

    @Override
    protected void initEvent() {
        tv_return .setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_return:
                finish();
                break;
        }
    }
}
