package com.lx.whsq.home1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lx.whsq.R;
import com.lx.whsq.cuiadapter.ContriAdapter;
import com.lx.whsq.cuiadapter.MultiAdapter;
import com.lx.whsq.cuiadapter.ProductAdapter;
import com.lx.whsq.base.BaseActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

//我惠----所有统一的页面
public class WoHuiAllActivity extends BaseActivity {
    @BindView(R.id.finishBack)
    ImageView finishBack;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.shareTV)
    TextView shareTV;
    @BindView(R.id.tuiJianTV)
    TextView tuiJianTV;
    @BindView(R.id.image1)
    ImageView image1;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.top)
    RecyclerView top;
    @BindView(R.id.bottom)
    RecyclerView bottom;

    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    List<Map<String, Object>> list = new ArrayList<>();
    List<Map<String, Object>> list2 = new ArrayList<>();
    List<Map<String, Object>> list3 = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    ContriAdapter adapter;
    MultiAdapter multiAdapter;
    ProductAdapter productAdapter;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.wohuiall_activity);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        ImageView finishBack = findViewById(R.id.finishBack);
        TextView titleName = findViewById(R.id.titleName);
        finishBack.setVisibility(View.VISIBLE);
        finishBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleName.setText("统一的标题");
        initDataBanner();

        /*layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        top.setLayoutManager(layoutManager);
        adapter = new ContriAdapter(mContext, list);
        top.setAdapter(adapter);
        adapter.setOnItemClickListener(new ContriAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {

            }

        });*/

        gridLayoutManager = new GridLayoutManager(mContext, 5);
        top.setLayoutManager(gridLayoutManager);
        multiAdapter = new MultiAdapter(mContext, list2);
        top.setAdapter(multiAdapter);
        multiAdapter.setOnItemClickListener(new MultiAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {


            }


        });


        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        bottom.setLayoutManager(staggeredGridLayoutManager);
        productAdapter = new ProductAdapter(mContext, list3);
        bottom.setAdapter(productAdapter);
        productAdapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {


            }

        });


    }

    private void initDataBanner() {
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
        banner.setImageLoader(new MyLoader());
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

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }


}
