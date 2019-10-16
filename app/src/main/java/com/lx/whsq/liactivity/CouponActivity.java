package com.lx.whsq.liactivity;

import android.content.Intent;
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
import com.lx.whsq.home4.BeanonFragment;
import com.lx.whsq.home4.NotonFragment;
import com.lx.whsq.home4.StaleFragment;

public class CouponActivity extends BaseActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Fragment[] mFragmentArrays = new Fragment[3];
    private String[] mTabTitles = new String[3];


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_coupon);
        rightText.setVisibility(View.VISIBLE);
        setTopTitle("优惠券管理");
        rightText.setText("添加");
    }

    @Override
    protected void initEvent() {
        viewPager = findViewById(R.id.tab_viewpager);
        tabLayout = findViewById(R.id.tablayout);

        mTabTitles[0] = "未上架";
        mTabTitles[1] = "已上架";
        mTabTitles[2] = "已过期";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);
        mFragmentArrays[0] = NotonFragment.newInstance();
        mFragmentArrays[1] = BeanonFragment.newInstance();
        mFragmentArrays[2] = StaleFragment.newInstance();
        //TODO https://www.cnblogs.com/zhangqie/p/6404890.html
        PagerAdapter pagerAdapter = new CouponActivity.MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void initData() {
        rightText.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rightText://编辑代金券
                Intent intent = new Intent(CouponActivity.this,RedactActivity.class);
                startActivity(intent);
                break;
        }
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
