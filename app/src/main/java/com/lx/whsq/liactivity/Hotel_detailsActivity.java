package com.lx.whsq.liactivity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;
import com.lx.whsq.home4.DetailFragment;
import com.lx.whsq.home4.House_typeFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class Hotel_detailsActivity extends BaseActivity implements View.OnClickListener{

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Fragment[] mFragmentArrays = new Fragment[2];
    private String[] mTabTitles = new String[2];
    private Banner banner;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;

    private ImageView im_return;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_hotel_details);
        baseTop.setVisibility(View.GONE);
        im_return = findViewById(R.id.im_return);
    }

    @Override
    protected void initEvent() {
        viewPager = findViewById(R.id.tab_viewpager);
        tabLayout = findViewById(R.id.tablayout);
        banner = findViewById(R.id.banner);
        im_return = findViewById(R.id.im_return);

        mTabTitles[0] = "房型";
        mTabTitles[1] = "详情";
        im_return.setOnClickListener(this);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);
        mFragmentArrays[0] = House_typeFragment.newInstance();
        mFragmentArrays[1] = DetailFragment.newInstance();

        //TODO https://www.cnblogs.com/zhangqie/p/6404890.html
        PagerAdapter pagerAdapter = new Hotel_detailsActivity.MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void initData() {
        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();

        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");
        list_title.add("好好学习");
        list_title.add("好好学习");
        list_title.add("好好学习");
        list_title.add("好好学习");
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new Hotel_detailsActivity.MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_return:
                finish();
                break;
        }
    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
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
