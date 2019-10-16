package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lx.whsq.R;
import com.lx.whsq.adapter.Recharge_recordAdapter;
import com.lx.whsq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Recharge_recordActivity extends BaseActivity implements View.OnClickListener{

    private RecyclerView recycle;
    LinearLayoutManager layoutManager;
    Recharge_recordAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_recharge_record);
        setTopTitle("充值记录");
        recycle = findViewById(R.id.recycle);
    }

    @Override
    protected void initEvent() {
        layoutManager = new LinearLayoutManager(Recharge_recordActivity.this);
        recycle.setLayoutManager(layoutManager);
        adapter = new Recharge_recordAdapter(Recharge_recordActivity.this, list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new Recharge_recordAdapter.OnItemClickListener() {
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
