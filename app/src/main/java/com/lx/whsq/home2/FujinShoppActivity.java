package com.lx.whsq.home2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class FujinShoppActivity extends BaseActivity {

    private Fragment[] mFragmentArrays = new Fragment[3];

    private String[] mTabTitles = new String[3];

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fujinshopp_activity);

        TabLayout tablayout2 = findViewById(R.id.tablayout2);
        ViewPager tabViewpager = findViewById(R.id.tabViewpager);

        mTabTitles[0] = "综合排序";
        mTabTitles[1] = "离我最近";
        mTabTitles[2] = "折扣最低";

        tablayout2.setTabMode(TabLayout.MODE_FIXED);
        mFragmentArrays[0] = new FujinShopFragment1();
        mFragmentArrays[1] = new FujinShopFragment2();
        mFragmentArrays[2] = new FujinShopFragment3();

        //TODO https://www.cnblogs.com/zhangqie/p/6404890.html
        PagerAdapter pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        tabViewpager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        tablayout2.setupWithViewPager(tabViewpager);

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

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }
}
