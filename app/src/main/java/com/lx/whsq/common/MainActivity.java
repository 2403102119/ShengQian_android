package com.lx.whsq.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;
import com.lx.whsq.fragment.Home1FragmentTab1;
import com.lx.whsq.fragment.Home3Fragment;
import com.lx.whsq.fragment.Home4Fragment;
import com.lx.whsq.home2.YunTab1Fragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {


    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;
    private MyPagerAdapter adapter;
    private RadioButton rB1;
    private RadioButton rB2;
    private RadioButton rB3;
    private RadioButton rB4;
    private static final String TAG = "MainActivity";

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        setViews();
        setListeners();
        fragments = new ArrayList<>();
        fragments.add(new Home1FragmentTab1());
        fragments.add(new YunTab1Fragment());
        //fragments.add(new Home1FragmentTab3());
        fragments.add(new Home3Fragment());
        fragments.add(new Home4Fragment());

        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        viewPager.setOffscreenPageLimit(fragments.size());


    }


    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int arg0) {
            return fragments.get(arg0);
        }

        public int getCount() {
            return fragments.size();
        }
    }

    //通过监听viewpager滑动改变Checked的属性
    private void setListeners() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rB1.setChecked(true);
                        rB1.setTextColor(getResources().getColor(R.color.mainColor));
                        rB2.setTextColor(getResources().getColor(R.color.txt_orange2));
                        rB3.setTextColor(getResources().getColor(R.color.txt_orange2));
                        rB4.setTextColor(getResources().getColor(R.color.txt_orange2));

                        break;
                    case 1:
                        rB2.setChecked(true);
                        rB2.setTextColor(getResources().getColor(R.color.mainColor));
                        rB1.setTextColor(getResources().getColor(R.color.txt_orange2));
                        rB3.setTextColor(getResources().getColor(R.color.txt_orange2));
                        rB4.setTextColor(getResources().getColor(R.color.txt_orange2));
                        break;
                    case 2:
                        rB3.setChecked(true);
                        rB3.setTextColor(getResources().getColor(R.color.mainColor));
                        rB1.setTextColor(getResources().getColor(R.color.txt_orange2));
                        rB2.setTextColor(getResources().getColor(R.color.txt_orange2));
                        rB4.setTextColor(getResources().getColor(R.color.txt_orange2));
                        break;
                    case 3:
                        rB4.setChecked(true);
                        rB4.setTextColor(getResources().getColor(R.color.mainColor));
                        rB1.setTextColor(getResources().getColor(R.color.txt_orange2));
                        rB2.setTextColor(getResources().getColor(R.color.txt_orange2));
                        rB3.setTextColor(getResources().getColor(R.color.txt_orange2));
                        break;
                    default:
                }
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    private void setViews() {
        viewPager = findViewById(R.id.viewPager);
        rB1 = findViewById(R.id.RadioButton1);
        rB2 = findViewById(R.id.RadioButton2);
        rB3 = findViewById(R.id.RadioButton3);
        rB4 = findViewById(R.id.RadioButton4);
    }

    //监听RadioButton的点击
    public void doClick(View view) {
        switch (view.getId()) {
            case R.id.RadioButton1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.RadioButton2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.RadioButton3:
                viewPager.setCurrentItem(2);
                break;
            case R.id.RadioButton4:
                viewPager.setCurrentItem(3);
                break;
            default:
        }
    }


    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    /**
     * 第一种解决办法 通过监听keyUp
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                finish();
            }
        }

        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }
}
