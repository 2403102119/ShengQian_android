package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lx.whsq.R;
import com.lx.whsq.adapter.ParticularsAdapter;
import com.lx.whsq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecommendActivity extends BaseActivity implements View.OnClickListener {
    private RecyclerView recycle;
    LinearLayoutManager layoutManager;
    ParticularsAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_recommend);
        setTopTitle("推荐店铺");
        recycle = findViewById(R.id.recycle);
    }

    @Override
    protected void initEvent() {
        layoutManager = new LinearLayoutManager(RecommendActivity.this);
        recycle.setLayoutManager(layoutManager);
        adapter = new ParticularsAdapter(RecommendActivity.this, list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new ParticularsAdapter.OnItemClickListener() {
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
