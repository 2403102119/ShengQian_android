package com.lx.whsq.home4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lx.whsq.R;
import com.lx.whsq.adapter.SaleAdapter;
import com.lx.whsq.base.BaseFragment;
import com.lx.whsq.liactivity.Commodity_detailsActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/10 0010.
 */

public class SaleFragment extends BaseFragment implements View.OnClickListener{
    public static Fragment newInstance() {
        SaleFragment fragment = new SaleFragment();
        return fragment;
    }
    private RecyclerView recycle;
    LinearLayoutManager layoutManager;
    SaleAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sale, container, false);
        initView(view);
        initData();
        return view;
    }
    private void initView(View view) {

        recycle = view.findViewById(R.id.recycle);

        layoutManager = new LinearLayoutManager(getContext());
        recycle.setLayoutManager(layoutManager);
        adapter = new SaleAdapter(getContext(), list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new SaleAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {//商品详情
                Intent intent = new Intent(getActivity(), Commodity_detailsActivity.class);
                startActivity(intent);
            }



        });


    }
    private void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


        }
    }




    @Override
    public void onResume() {
        super.onResume();
    }
}
