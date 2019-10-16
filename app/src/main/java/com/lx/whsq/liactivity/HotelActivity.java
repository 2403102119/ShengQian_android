package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class HotelActivity extends BaseActivity implements View.OnClickListener {
    private EditText ed_hotel;
    private TextView tv_te_city;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_hotel);
        setTopTitle("酒店");
        rightText.setVisibility(View.VISIBLE);
        rightText.setText("订单查询");
        rightText.setTextColor(getResources().getColor(R.color.black));

        ed_hotel = findViewById(R.id.ed_hotel);
        tv_te_city = findViewById(R.id.tv_te_city);
    }

    @Override
    protected void initEvent() {
        ed_hotel.setOnClickListener(this);
        rightText.setOnClickListener(this);
        tv_te_city.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ed_hotel:
                Intent intent = new Intent(HotelActivity.this,Hotel_listActivity.class);
                startActivity(intent);
                break;
            case R.id.rightText://我的订单
                Intent intent1 = new Intent(HotelActivity.this,Hotel_orderActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_te_city://选择位置
                Intent intent2 = new Intent(HotelActivity.this,CitySelectActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
