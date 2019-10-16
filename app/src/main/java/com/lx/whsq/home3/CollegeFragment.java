package com.lx.whsq.home3;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lx.whsq.R;
import com.lx.whsq.adapter.CollAdapter;
import com.lx.whsq.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/10 0010.
 */

public class CollegeFragment extends BaseFragment implements View.OnClickListener {
    private RecyclerView recycle;
    LinearLayoutManager layoutManager;
    CollAdapter adapter;
    List<Map<String,Object>> list=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_college, container, false);
        initView(view);
        initData();
        return view;
    }
    private void initView(View view) {
        recycle = view.findViewById(R.id.recycle);

        layoutManager = new LinearLayoutManager(getContext());
        recycle.setLayoutManager(layoutManager);
        adapter = new CollAdapter(getContext(), list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new CollAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {

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
