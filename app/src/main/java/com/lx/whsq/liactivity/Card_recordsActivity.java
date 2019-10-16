package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lx.whsq.R;
import com.lx.whsq.adapter.Card_recordsAdapter;
import com.lx.whsq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Card_recordsActivity extends BaseActivity {

    private RecyclerView recycle;
    LinearLayoutManager layoutManager;
    Card_recordsAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_card_records);
        setTopTitle("办卡记录");
        recycle = findViewById(R.id.recycle);
    }

    @Override
    protected void initEvent() {
        layoutManager = new LinearLayoutManager(Card_recordsActivity.this);
        recycle.setLayoutManager(layoutManager);
        adapter = new Card_recordsAdapter(Card_recordsActivity.this, list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new Card_recordsAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {

            }

        });
    }

    @Override
    protected void initData() {

    }
}
