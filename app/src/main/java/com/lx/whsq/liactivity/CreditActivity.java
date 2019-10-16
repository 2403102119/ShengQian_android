package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lx.whsq.R;
import com.lx.whsq.adapter.CreditAdapter;
import com.lx.whsq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreditActivity extends BaseActivity implements View.OnClickListener{

    private RecyclerView recycle;
    LinearLayoutManager layoutManager;
    CreditAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_credit);
        rightText.setText("办卡记录");
        rightText.setVisibility(View.VISIBLE);
        rightText.setTextColor(getResources().getColor(R.color.red_them));
        recycle = findViewById(R.id.recycle);
    }

    @Override
    protected void initEvent() {
        rightText.setOnClickListener(this);

        layoutManager = new LinearLayoutManager(CreditActivity.this);
        recycle.setLayoutManager(layoutManager);
        adapter = new CreditAdapter(CreditActivity.this, list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new CreditAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {

            }

            @Override
            public void OnApply(int position) {//极速申请
                Intent intent = new Intent(CreditActivity.this,ApplyActivity.class);
                startActivity(intent);
            }


        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rightText://办卡记录
                Intent intent = new Intent(CreditActivity.this,Card_recordsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
