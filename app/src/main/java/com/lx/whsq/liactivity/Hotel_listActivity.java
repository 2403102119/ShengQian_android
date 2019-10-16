package com.lx.whsq.liactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lx.whsq.R;
import com.lx.whsq.adapter.HotelAdapter;
import com.lx.whsq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hotel_listActivity extends BaseActivity implements View.OnClickListener{

    private RecyclerView recycle;
    LinearLayoutManager layoutManager;
    HotelAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();

    private ImageView im_return;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_hotel_list);
        baseTop.setVisibility(View.GONE);
        recycle = findViewById(R.id.recycle);
        im_return = findViewById(R.id.im_return);
    }

    @Override
    protected void initEvent() {
        im_return.setOnClickListener(this);

        layoutManager = new LinearLayoutManager(Hotel_listActivity.this);
        recycle.setLayoutManager(layoutManager);
        adapter = new HotelAdapter(Hotel_listActivity.this, list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new HotelAdapter.OnItemClickListener(){
            @Override
            public void OnItemClickListener(int firstPosition) {
                Intent intent = new Intent(Hotel_listActivity.this,Hotel_detailsActivity.class);
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
            case R.id.im_return:
                finish();
                break;
        }
    }
}
