package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class ForgetActivity extends BaseActivity implements View.OnClickListener{


    private TextView tv_submit;
    private EditText rd_password,rd_password_1,et_a,et_b,ed_c;
    private View ve_rd_password,ve_rd_password_1,v_a,v_b,v_c;
    private String TYPE;
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_forget);
        setTopTitle("找回密码");
        tv_submit = findViewById(R.id.tv_submit);
        rd_password = findViewById(R.id.rd_password);
        ve_rd_password = findViewById(R.id.ve_rd_password);
        rd_password_1 = findViewById(R.id.rd_password_1);
        ve_rd_password_1 = findViewById(R.id.ve_rd_password_1);
        et_a = findViewById(R.id.et_a);
        et_b = findViewById(R.id.et_b);
        ed_c = findViewById(R.id.ed_c);
        v_c = findViewById(R.id.v_c);
        v_a = findViewById(R.id.v_a);
        v_b = findViewById(R.id.v_b);
    }

    @Override
    protected void initEvent() {
        tv_submit.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        TYPE = getIntent().getStringExtra("type");
        if (TYPE.equals("1")){
            setTopTitle("修改手机号");
            rd_password.setVisibility(View.GONE);
            ve_rd_password.setVisibility(View.GONE);
            rd_password_1.setVisibility(View.GONE);
            ve_rd_password_1.setVisibility(View.GONE);
            ed_c.setVisibility(View.GONE);
            v_c.setVisibility(View.GONE);
            et_a.setVisibility(View.VISIBLE);
            et_b.setVisibility(View.VISIBLE);
            v_a.setVisibility(View.VISIBLE);
            v_b.setVisibility(View.VISIBLE);

            tv_submit.setText("确定");
        }else {
            setTopTitle("找回密码");
            rd_password.setVisibility(View.VISIBLE);
            ve_rd_password.setVisibility(View.VISIBLE);
            rd_password_1.setVisibility(View.VISIBLE);
            ve_rd_password_1.setVisibility(View.VISIBLE);
            ed_c.setVisibility(View.VISIBLE);
            v_c.setVisibility(View.VISIBLE);
            et_a.setVisibility(View.GONE);
            et_b.setVisibility(View.GONE);
            v_a.setVisibility(View.GONE);
            v_b.setVisibility(View.GONE);
            tv_submit.setText("提交");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_submit://提交
                finish();
                break;
        }
    }
}
