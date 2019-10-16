package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lx.whsq.R;
import com.lx.whsq.adapter.FaqAdapter;
import com.lx.whsq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FaqActivity extends BaseActivity {

    private RecyclerView recycle;
    LinearLayoutManager layoutManager;
    FaqAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_faq);
        setTopTitle("常见问题");
        recycle = findViewById(R.id.recycle);
    }

    @Override
    protected void initEvent() {
        layoutManager = new LinearLayoutManager(FaqActivity.this);
        recycle.setLayoutManager(layoutManager);
        adapter = new FaqAdapter(FaqActivity.this, list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new FaqAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {

            }



        });
    }

    @Override
    protected void initData() {

    }
}
