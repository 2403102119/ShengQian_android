package com.lx.whsq.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseFragment;
import com.lx.whsq.base.TabPagerAdapter;
import com.lx.whsq.home3.CollegeFragment;
import com.lx.whsq.home3.CopywriterFragment;

import java.util.ArrayList;
import java.util.List;


public class Home3Fragment extends BaseFragment implements View.OnClickListener{
    private ViewPager viewPager;
    private TabLayout tableLayout;
    private static String[] tabmap = {"我惠学院","文案"};
    private TabPagerAdapter tabPagerAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colleg, container, false);
        initView(view);
        initData();
        return view;
    }
    private void initView(View view) {
        viewPager = view.findViewById(R.id.tab_viewpager);
        tableLayout = view.findViewById(R.id.tablayout);


        fragmentList.add(new CollegeFragment());//我惠学院
        fragmentList.add(new CopywriterFragment());//文案

        tabPagerAdapter = new TabPagerAdapter(getChildFragmentManager(), tabmap, fragmentList);
        viewPager.setAdapter(tabPagerAdapter);
        tableLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);




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
