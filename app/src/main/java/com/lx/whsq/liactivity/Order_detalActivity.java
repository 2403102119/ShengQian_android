package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lx.whsq.R;
import com.lx.whsq.adapter.Order_datalAdapter;
import com.lx.whsq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order_detalActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView recycle;
    LinearLayoutManager layoutManager;
    Order_datalAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_order_detal);
        setTopPrimaryColor(TOP_PRIMARY_COLOR);
        setTopTitle("订单详情");
        recycle = findViewById(R.id.recycle);
    }

    @Override
    protected void initEvent() {
        layoutManager = new LinearLayoutManager(Order_detalActivity.this);
        recycle.setLayoutManager(layoutManager);
        adapter = new Order_datalAdapter(Order_detalActivity.this, list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new Order_datalAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {

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
