package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lx.whsq.R;
import com.lx.whsq.adapter.ShopAdapter;
import com.lx.whsq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShopActivity extends BaseActivity {

    private RecyclerView recycle;
    LinearLayoutManager layoutManager;
    ShopAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_shop);
        setTopTitle("我的小店");
        recycle = findViewById(R.id.recycle);
    }

    @Override
    protected void initEvent() {
        layoutManager = new LinearLayoutManager(ShopActivity.this);
        recycle.setLayoutManager(layoutManager);
        adapter = new ShopAdapter(ShopActivity.this, list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new ShopAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {

            }



        });
    }

    @Override
    protected void initData() {

    }
}
