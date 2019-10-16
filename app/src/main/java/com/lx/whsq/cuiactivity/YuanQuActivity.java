package com.lx.whsq.cuiactivity;

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
import com.lx.whsq.home1.YuQu1Fragment;
import com.lx.whsq.home1.YuQu2Fragment;
import com.lx.whsq.home1.YuQu3Fragment;

public class YuanQuActivity extends BaseActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Fragment[] mFragmentArrays = new Fragment[3];
    private String[] mTabTitles = new String[3];

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.yuanqu_activity);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.tab_viewpager);

        mTabTitles[0] = "9.9元区";
        mTabTitles[1] = "6.9元区";
        mTabTitles[2] = "3.9元区";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);
        mFragmentArrays[0] = YuQu1Fragment.newInstance();
        mFragmentArrays[1] = YuQu2Fragment.newInstance();
        mFragmentArrays[2] = YuQu3Fragment.newInstance();
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

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

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
