package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lx.whsq.R;
import com.lx.whsq.adapter.Recycle_oneAdapter;
import com.lx.whsq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EvaluateActivity extends BaseActivity implements View.OnClickListener{

    private RecyclerView re_1;
    LinearLayoutManager layoutManager;
    Recycle_oneAdapter adapter;

    List<Map<String,Object>> list=new ArrayList<>();
    List<Map<String,Object>> list2=new ArrayList<>();


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_evaluate);
        setTopTitle("用户评价（20）");
        re_1 = findViewById(R.id.recycle);
    }

    @Override
    protected void initEvent() {

        layoutManager = new LinearLayoutManager(EvaluateActivity.this);
        re_1.setLayoutManager(layoutManager);
        adapter = new Recycle_oneAdapter(EvaluateActivity.this, list);
        re_1.setAdapter(adapter);
        adapter.setOnItemClickListener(new Recycle_oneAdapter.OnItemClickListener() {
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
