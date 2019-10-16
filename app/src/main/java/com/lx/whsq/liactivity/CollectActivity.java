package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lx.whsq.R;
import com.lx.whsq.adapter.CollectAdapter;
import com.lx.whsq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CollectActivity extends BaseActivity {
    private RecyclerView recycle;
    LinearLayoutManager layoutManager;
    CollectAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_collect);
        setTopTitle("收藏的店");
        recycle = findViewById(R.id.recycle);
    }

    @Override
    protected void initEvent() {
        layoutManager = new LinearLayoutManager(CollectActivity.this);
        recycle.setLayoutManager(layoutManager);
        adapter = new CollectAdapter(CollectActivity.this, list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new CollectAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {

            }



        });
    }

    @Override
    protected void initData() {

    }
}
