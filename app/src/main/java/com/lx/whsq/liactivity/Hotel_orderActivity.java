package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lx.whsq.R;
import com.lx.whsq.adapter.Hotel_orderAdapter;
import com.lx.whsq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hotel_orderActivity extends BaseActivity implements View.OnClickListener{


    private RecyclerView recycle;
    LinearLayoutManager layoutManager;
    Hotel_orderAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_hotel_order);
        setTopTitle("我的订单");
        recycle = findViewById(R.id.recycle);
    }

    @Override
    protected void initEvent() {
        layoutManager = new LinearLayoutManager(Hotel_orderActivity.this);
        recycle.setLayoutManager(layoutManager);
        adapter = new Hotel_orderAdapter(Hotel_orderActivity.this, list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new Hotel_orderAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {
                Intent intent = new Intent(Hotel_orderActivity.this,Hotel_order_detailsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

    }
}
