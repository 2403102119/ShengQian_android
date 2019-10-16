package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class InviteActivity extends BaseActivity implements View.OnClickListener{

   private ImageView back;
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_invite);
        baseTop.setVisibility(View.GONE);
        back = findViewById(R.id.back_1);


    }

    @Override
    protected void initEvent() {
        back.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.back_1:
                 finish();
                 break;
         }
    }
}
