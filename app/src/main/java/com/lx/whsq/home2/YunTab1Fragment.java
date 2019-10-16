package com.lx.whsq.home2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lx.whsq.R;
import com.lx.whsq.cuiadapter.ContriAdapter;
import com.lx.whsq.cuiadapter.MultiAdapter;
import com.lx.whsq.cuiadapter.ProductAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//我惠云店精选
public class YunTab1Fragment extends Fragment {

    private View view;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;


    List<Map<String, Object>> list = new ArrayList<>();
    List<Map<String, Object>> list2 = new ArrayList<>();
    List<Map<String, Object>> list3 = new ArrayList<>();
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;

    ContriAdapter adapter;
    MultiAdapter multiAdapter;
    ProductAdapter productAdapter;
    private Banner banner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(container.getContext(), R.layout.yuntab1fragment, null);
        recyclerView1 = view.findViewById(R.id.RecyclerView1);
        recyclerView2 = view.findViewById(R.id.RecyclerView2);
        recyclerView3 = view.findViewById(R.id.RecyclerView3);
        banner = view.findViewById(R.id.banner);
        initData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(layoutManager);
        adapter = new ContriAdapter(getContext(), list);
        recyclerView1.setAdapter(adapter);
        adapter.setOnItemClickListener(new ContriAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {

            }

        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 5);
        recyclerView2.setLayoutManager(gridLayoutManager);
        multiAdapter = new MultiAdapter(getContext(), list2);
        recyclerView2.setAdapter(multiAdapter);
        multiAdapter.setOnItemClickListener(new MultiAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {


            }


        });


        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView3.setLayoutManager(staggeredGridLayoutManager);
        productAdapter = new ProductAdapter(getContext(), list3);
        recyclerView3.setAdapter(productAdapter);
        productAdapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {


            }

        });

        return view;

    }

    private void initData() {
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



}
