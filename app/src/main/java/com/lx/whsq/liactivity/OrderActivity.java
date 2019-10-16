package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;
import com.lx.whsq.home4.AfterFragment;
import com.lx.whsq.home4.DropFragment;
import com.lx.whsq.home4.ReceivedFragment;
import com.lx.whsq.home4.SellFragment;

public class OrderActivity extends BaseActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Fragment[] mFragmentArrays = new Fragment[4];
    private String[] mTabTitles = new String[4];


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_order);
        setTopTitle("客户订单");
        setTopPrimaryColor(TOP_PRIMARY_COLOR);
    }

    @Override
    protected void initEvent() {
        viewPager = findViewById(R.id.tab_viewpager);
        tabLayout = findViewById(R.id.tablayout);

        mTabTitles[0] = "全部";
        mTabTitles[1] = "待发货";
        mTabTitles[2] = "已收货";
        mTabTitles[3] = "售后退款";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);
        mFragmentArrays[0] = SellFragment.newInstance();
        mFragmentArrays[1] = DropFragment.newInstance();
        mFragmentArrays[2] = ReceivedFragment.newInstance();
        mFragmentArrays[3] = AfterFragment.newInstance();
        //TODO https://www.cnblogs.com/zhangqie/p/6404890.html
        PagerAdapter pagerAdapter = new OrderActivity.MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

    }
    final class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentArrays[position];
        }


        @Override
        public int getCount() {
            return mFragmentArrays.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles[position];

        }
    }
}
