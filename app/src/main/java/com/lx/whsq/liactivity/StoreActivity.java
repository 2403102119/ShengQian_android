package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.lx.whsq.R;
import com.lx.whsq.adapter.ProductAdapter;
import com.lx.whsq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StoreActivity extends BaseActivity implements View.OnClickListener{

    private RecyclerView recycle;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    ProductAdapter productAdapter;
    List<Map<String,Object>> list3=new ArrayList<>();

    private ImageView im_return;
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_store);
        baseTop.setVisibility(View.GONE);
        recycle = findViewById(R.id.recycle);
        im_return = findViewById(R.id.im_return);
    }

    @Override
    protected void initEvent() {

        im_return.setOnClickListener(this);

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recycle.setLayoutManager(staggeredGridLayoutManager);
        productAdapter = new ProductAdapter(StoreActivity.this, list3);
        recycle.setAdapter(productAdapter);
        productAdapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
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
        switch (v.getId()){
            case R.id.im_return:
                finish();
                break;
        }
    }
}
