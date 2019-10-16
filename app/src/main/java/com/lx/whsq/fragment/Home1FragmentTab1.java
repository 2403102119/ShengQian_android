package com.lx.whsq.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.lx.whsq.R;
import com.lx.whsq.cuiactivity.PinPaiShanGouActivity;
import com.lx.whsq.cuiadapter.ContriAdapter;
import com.lx.whsq.cuiadapter.MultiAdapter;
import com.lx.whsq.cuiadapter.ProductAdapter;
import com.lx.whsq.feiji.AirOrderListActivity;
import com.lx.whsq.feiji.FeijiShopDetailActivity;
import com.lx.whsq.feiji.FeijiShopListActivity;
import com.lx.whsq.home1.CheCiInfoActivity;
import com.lx.whsq.home1.DouQuanActivity;
import com.lx.whsq.home1.HuoChePiaoOrderDetailActivity;
import com.lx.whsq.home1.HuoChePiaoSelectPopActivity;
import com.lx.whsq.home1.TrainListActivity;
import com.lx.whsq.home1.WoHuiAllActivity;
import com.lx.whsq.home2.FuPinXianActivity;
import com.lx.whsq.home2.FujinShoppActivity;
import com.lx.whsq.home2.LiuYanActivity;
import com.lx.whsq.home2.ShangQuanOrderDetailActivity;
import com.lx.whsq.jiudian.SelectedDayActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Home1FragmentTab1 extends Fragment implements View.OnClickListener {

    private RecyclerView recycle, ry_multi, ry_product, ry_falls;
    private LinearLayoutManager layoutManager;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    ContriAdapter adapter;
    MultiAdapter multiAdapter;
    ProductAdapter productAdapter;
    private Banner banner;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    List<Map<String, Object>> list = new ArrayList<>();
    List<Map<String, Object>> list2 = new ArrayList<>();
    List<Map<String, Object>> list3 = new ArrayList<>();
    private Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_cui, container, false);
        initView(view);
        initData();

        return view;
    }

    private void initView(View view) {

        LinearLayout View1 = view.findViewById(R.id.View1);
        LinearLayout View2 = view.findViewById(R.id.View2);
        LinearLayout View3 = view.findViewById(R.id.View3);
        LinearLayout View4 = view.findViewById(R.id.View4);
        LinearLayout View5 = view.findViewById(R.id.View5);
        LinearLayout View6 = view.findViewById(R.id.View6);
        LinearLayout View7 = view.findViewById(R.id.View7);
        LinearLayout View8 = view.findViewById(R.id.View8);
        LinearLayout View9 = view.findViewById(R.id.View9);
        LinearLayout View10 = view.findViewById(R.id.View10);
        LinearLayout View11 = view.findViewById(R.id.View11);
        LinearLayout View12 = view.findViewById(R.id.View12);
        LinearLayout View13 = view.findViewById(R.id.View13);
        LinearLayout View14 = view.findViewById(R.id.View14);
        LinearLayout View15 = view.findViewById(R.id.View15);

        View1.setOnClickListener(this);
        View2.setOnClickListener(this);
        View3.setOnClickListener(this);
        View4.setOnClickListener(this);
        View5.setOnClickListener(this);
        View6.setOnClickListener(this);
        View7.setOnClickListener(this);
        View8.setOnClickListener(this);
        View9.setOnClickListener(this);
        View10.setOnClickListener(this);
        View11.setOnClickListener(this);
        View12.setOnClickListener(this);
        View13.setOnClickListener(this);
        View14.setOnClickListener(this);
        View15.setOnClickListener(this);


        recycle = view.findViewById(R.id.recycle);
        banner = view.findViewById(R.id.banner);
        ry_multi = view.findViewById(R.id.ry_multi);
        ry_product = view.findViewById(R.id.ry_product);
        ry_falls = view.findViewById(R.id.ry_falls);

        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycle.setLayoutManager(layoutManager);
        adapter = new ContriAdapter(getContext(), list);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new ContriAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {

            }

        });

        gridLayoutManager = new GridLayoutManager(getContext(), 5);
        ry_multi.setLayoutManager(gridLayoutManager);
        multiAdapter = new MultiAdapter(getContext(), list2);
        ry_multi.setAdapter(multiAdapter);
        multiAdapter.setOnItemClickListener(new MultiAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {


            }


        });

        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        ry_product.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(getContext(), list3);
        ry_product.setAdapter(productAdapter);
        productAdapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {


            }

        });

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        ry_falls.setLayoutManager(staggeredGridLayoutManager);
        productAdapter = new ProductAdapter(getContext(), list3);
        ry_falls.setAdapter(productAdapter);
        productAdapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {


            }

        });


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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.View1:
                //我惠云店
                //intent = new Intent(getActivity(), SettingActivity.class);
                //intent = new Intent(getActivity(), OrderOKActivity.class);
                intent = new Intent(getActivity(), FeijiShopDetailActivity.class);
                startActivity(intent);
                break;
            case R.id.View2:
                //我惠出行
                //intent = new Intent(getActivity(), MyOrderActivity.class);
                intent = new Intent(getActivity(), PinPaiShanGouActivity.class);
                startActivity(intent);
                break;
            case R.id.View3:
                //我惠逛街
                //intent = new Intent(getActivity(), KeHuOrderActivity.class);
                intent = new Intent(getActivity(), FuPinXianActivity.class);
                startActivity(intent);
                break;
            case R.id.View4:
                //我惠美食
                //intent = new Intent(getActivity(), ShenQingTuiMoneyActivity.class);
                intent = new Intent(getActivity(), LiuYanActivity.class);
                startActivity(intent);
                break;
            case R.id.View5:
                //我惠云超
                intent = new Intent(getActivity(), WoHuiAllActivity.class);
                startActivity(intent);
                break;
            case R.id.View6:
                //上天猫
                //intent = new Intent(getActivity(), TuiKuanDetailActivity.class);
                intent = new Intent(getActivity(), DouQuanActivity.class);
                startActivity(intent);
                break;
            case R.id.View7:
                //逛淘宝
                //intent = new Intent(getActivity(), OrderDetailActivity.class);
                intent = new Intent(getActivity(), ShangQuanOrderDetailActivity.class);
                startActivity(intent);
                break;
            case R.id.View8:
                //购京东
                //intent = new Intent(getActivity(), CancelOrderActivity.class);
                intent = new Intent(getActivity(), FujinShoppActivity.class);
                startActivity(intent);
                break;
            case R.id.View9:
                //聚划算
                //intent = new Intent(getActivity(), PaySuccessActivity.class);
                intent = new Intent(getActivity(), HuoChePiaoOrderDetailActivity.class);
                startActivity(intent);
                break;
            case R.id.View10:
                //拼多少
                intent = new Intent(getActivity(), SelectedDayActivity.class);
                startActivity(intent);
                break;
            case R.id.View11:
                //飞机票
                //intent = new Intent(getActivity(), FenLeiShopActivity.class);
                intent = new Intent(getActivity(), CheCiInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.View12:
                //火车票
                //intent = new Intent(getActivity(), YuanQuActivity.class);
                intent = new Intent(getActivity(), HuoChePiaoSelectPopActivity.class);
                startActivity(intent);
                break;
            case R.id.View13:
                //订酒店
                //intent = new Intent(getActivity(), SearchActivity.class);
                intent = new Intent(getActivity(), TrainListActivity.class);
                startActivity(intent);
                break;
            case R.id.View14:
                //充话费
                //intent = new Intent(getActivity(), SearchCityActivity.class);
                intent = new Intent(getActivity(), AirOrderListActivity.class);
                startActivity(intent);
                break;
            case R.id.View15:
                //信用卡
                //intent = new Intent(getActivity(), FenLeiActivity.class);
                //intent = new Intent(getActivity(), XianShiMiaoShaActivity.class);
                //intent = new Intent(getActivity(), RiLiActivity.class);
                intent = new Intent(getActivity(), FeijiShopListActivity.class);
                startActivity(intent);
                break;
            default:
        }
    }


}
