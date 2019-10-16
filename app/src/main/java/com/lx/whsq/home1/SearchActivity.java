package com.lx.whsq.home1;

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

public class SearchActivity extends BaseActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Fragment[] mFragmentArrays = new Fragment[4];
    private String[] mTabTitles = new String[4];

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.search_activity);
        init();
    }

    private void init() {
        findViewById(R.id.finishBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.tab_viewpager);

        mTabTitles[0] = "我惠云店";
        mTabTitles[1] = "淘宝";
        mTabTitles[2] = "京东";
        mTabTitles[3] = "拼多多";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);
        mFragmentArrays[0] = SearchFragment.newInstance();
        mFragmentArrays[1] = SearchFragment.newInstance();
        mFragmentArrays[2] = SearchFragment.newInstance();
        mFragmentArrays[3] = SearchFragment.newInstance();
        //TODO https://www.cnblogs.com/zhangqie/p/6404890.html
        PagerAdapter pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);

        findViewById(R.id.finishBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
