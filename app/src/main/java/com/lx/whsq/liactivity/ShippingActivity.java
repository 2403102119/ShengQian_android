package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.adapter.ShippingAdapter;
import com.lx.whsq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShippingActivity extends BaseActivity implements View.OnClickListener{

    private TextView tv_add;
    private RecyclerView recycle;
    LinearLayoutManager layoutManager;
    ShippingAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_shipping);
        setTopTitle("收货地址");
        recycle = findViewById(R.id.recycle);
        tv_add = findViewById(R.id.tv_add);
    }

    @Override
    protected void initEvent() {
        tv_add.setOnClickListener(this);

        layoutManager = new LinearLayoutManager(ShippingActivity.this);
        recycle.setLayoutManager(layoutManager);
        adapter = new ShippingAdapter(ShippingActivity.this, list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new ShippingAdapter.OnItemClickListener() {
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
        switch (v.getId()){
            case R.id.tv_add://添加新的收货地址
                Intent intent = new Intent(ShippingActivity.this,Add_addressActivity.class);
                startActivity(intent);
                break;
        }
    }
}
