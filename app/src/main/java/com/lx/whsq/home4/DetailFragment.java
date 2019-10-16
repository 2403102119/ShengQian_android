package com.lx.whsq.home4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lx.whsq.R;
import com.lx.whsq.adapter.DetailFragmentAdapter;
import com.lx.whsq.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/14 0014.
 */

public class DetailFragment extends BaseFragment implements View.OnClickListener {
    public static Fragment newInstance() {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }
    private RecyclerView recycle;
    StaggeredGridLayoutManager layoutManager;
    DetailFragmentAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        initView(view);
        initData();
        return view;
    }
    private void initView(View view) {

        recycle = view.findViewById(R.id.recycle);

        layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recycle.setLayoutManager(layoutManager);
        adapter = new DetailFragmentAdapter(getContext(), list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new DetailFragmentAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {

            }

            @Override
            public void onDeliver(int position) {

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
