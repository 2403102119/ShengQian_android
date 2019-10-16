package com.lx.whsq.cuiactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;
import com.lx.whsq.base.ToastFactory;
import com.lx.whsq.cuiorder.OrderFragment1;
import com.lx.whsq.cuiorder.OrderFragment2;
import com.lx.whsq.cuiorder.OrderFragment3;
import com.lx.whsq.cuiorder.OrderFragment4;
import com.lx.whsq.cuiorder.OrderFragment5;
import com.lx.whsq.cuiorder.OrderFragment6;

//我的订单
public class MyOrderActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MyOrderActivity";

    PageInfo[] pageInfos = new PageInfo[]{
            new PageInfo("全部", new OrderFragment1()),
            new PageInfo("待付款", new OrderFragment2()),
            new PageInfo("待发货", new OrderFragment3()),
            new PageInfo("待收货", new OrderFragment4()),
            new PageInfo("已完成", new OrderFragment5()),
            new PageInfo("待评价", new OrderFragment6()),
    };

    TabLayout tabLayout;
    public ViewPager viewPager;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.myorder_activity);
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);


        findViewById(R.id.finishBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(new MainAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                ToastFactory.getToast(mContext, "点到云订单").show();
                break;
            case R.id.tv2:
                ToastFactory.getToast(mContext, "点到淘客订单").show();
                break;
            case R.id.tv3:
                ToastFactory.getToast(mContext, "点到拼团订单").show();
                break;
        }
    }

    class MainAdapter extends FragmentPagerAdapter {

        public MainAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return pageInfos[i].fragment;
        }

        @Override
        public int getCount() {
            return pageInfos.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return pageInfos[position].title;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewPager.removeAllViews();
        viewPager = null;
        pageInfos = null;
    }
}
