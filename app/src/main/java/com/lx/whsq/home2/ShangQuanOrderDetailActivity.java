package com.lx.whsq.home2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;
import com.lx.whsq.view.MyDialog;

public class ShangQuanOrderDetailActivity extends BaseActivity {
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.shangquanorderdetail_activity);
        init();
    }

    private void init() {
        ImageView finishBack = findViewById(R.id.finishBack);
        TextView titleName = findViewById(R.id.titleName);
        finishBack.setVisibility(View.VISIBLE);
        finishBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleName.setText("商圈订单详情");

        findViewById(R.id.tv4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出二维码

                View view = getLayoutInflater().inflate(R.layout.mydialog_layout_code, null);
                final MyDialog mMyDialog = new MyDialog(ShangQuanOrderDetailActivity.this, 0, 0, view, R.style.DialogTheme2);
                mMyDialog.setCancelable(true);
                mMyDialog.show();


            }
        });
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }
}
