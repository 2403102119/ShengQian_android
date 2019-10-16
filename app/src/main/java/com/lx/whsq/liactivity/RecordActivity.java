package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lx.whsq.R;
import com.lx.whsq.adapter.RecordAdapter;
import com.lx.whsq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecordActivity extends BaseActivity {

    private RecyclerView recycle;
    LinearLayoutManager layoutManager;
    RecordAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_record);
        setTopTitle("我的账单");
        recycle = findViewById(R.id.recycle);
    }

    @Override
    protected void initEvent() {
        layoutManager = new LinearLayoutManager(RecordActivity.this);
        recycle.setLayoutManager(layoutManager);
        adapter = new RecordAdapter(RecordActivity.this, list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecordAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {

            }



        });
    }

    @Override
    protected void initData() {

    }
}
