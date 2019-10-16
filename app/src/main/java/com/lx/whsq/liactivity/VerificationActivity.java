package com.lx.whsq.liactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;
import com.lx.whsq.home4.AllorderFragment;
import com.lx.whsq.home4.BeanUsedFragment;
import com.lx.whsq.home4.UsedFragment;

public class VerificationActivity extends BaseActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Fragment[] mFragmentArrays = new Fragment[3];
    private String[] mTabTitles = new String[3];


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_verification);
        setTopTitle("订单中心");
    }

    @Override
    protected void initEvent() {
        viewPager = findViewById(R.id.tab_viewpager);
        tabLayout = findViewById(R.id.tablayout);

        mTabTitles[0] = "全部订单";
        mTabTitles[1] = "待使用";
        mTabTitles[2] = "已使用";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);
        mFragmentArrays[0] = AllorderFragment.newInstance();
        mFragmentArrays[1] = UsedFragment.newInstance();
        mFragmentArrays[2] = BeanUsedFragment.newInstance();
        //TODO https://www.cnblogs.com/zhangqie/p/6404890.html
        PagerAdapter pagerAdapter = new VerificationActivity.MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);
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
