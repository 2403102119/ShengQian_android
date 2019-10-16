package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.adapter.SelectAdapter;
import com.lx.whsq.adapter.Select_onAdapter;
import com.lx.whsq.base.BaseActivity;
import com.lx.whsq.view.ActionDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelectActivity extends BaseActivity implements View.OnClickListener{
    private RecyclerView recycle,recycle_1;
    private TextView tv_word;
    LinearLayoutManager layoutManager,layoutManager1;
    SelectAdapter adapter;
    Select_onAdapter selectOnAdapter;
    List<Map<String,Object>> list=new ArrayList<>();
    List<Map<String,Object>> list2=new ArrayList<>();

    private ActionDialog actionDialog;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_select);
        setTopTitle("选择商铺");
        recycle = findViewById(R.id.recycle);
        recycle_1 = findViewById(R.id.recycle_1);
        tv_word = findViewById(R.id.tv_word);

        actionDialog = new ActionDialog(SelectActivity.this,"提示","CK2521563464","您确定选中当前云店铺编码作为全国厂家总店吗？","取消","确定");
        actionDialog.setOnActionClickListener(new ActionDialog.OnActionClickListener() {
            @Override
            public void onLeftClick() {
                actionDialog.dismiss();
            }

            @Override
            public void onRightClick() {

            }
        });
    }

    @Override
    protected void initEvent() {
        layoutManager = new LinearLayoutManager(SelectActivity.this);
        recycle.setLayoutManager(layoutManager);
        adapter = new SelectAdapter(SelectActivity.this, list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new SelectAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {


            }

            @Override
            public void onCheck(int position, boolean ischeck) {
                tv_word.setText("店铺编码  *******  商品");
                recycle.setVisibility(View.GONE);
                recycle_1.setVisibility(View.VISIBLE);

            }
        });

        layoutManager1 = new LinearLayoutManager(SelectActivity.this);
        recycle_1.setLayoutManager(layoutManager1);
        selectOnAdapter = new Select_onAdapter(SelectActivity.this, list);
        recycle_1.setAdapter(selectOnAdapter);
        selectOnAdapter.setOnItemClickListener(new Select_onAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {

                actionDialog.show();
            }

        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}
