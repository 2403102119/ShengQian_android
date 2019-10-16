package com.lx.whsq.liactivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lx.whsq.R;
import com.lx.whsq.adapter.Recycle_oneAdapter;
import com.lx.whsq.adapter.Recycle_twoAdapter;
import com.lx.whsq.base.BaseActivity;
import com.lx.whsq.common.MainActivity;
import com.lx.whsq.view.AmountView2;
import com.makeramen.roundedimageview.RoundedImageView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Commodity_detailsActivity extends BaseActivity implements View.OnClickListener{

    private Banner banner;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    private ImageView im_return;

    private RecyclerView re_1,re_2;
    LinearLayoutManager layoutManager,layoutManager1;
    Recycle_oneAdapter adapter;
    Recycle_twoAdapter adapter1;

    List<Map<String,Object>> list=new ArrayList<>();
    List<Map<String,Object>> list2=new ArrayList<>();

    private LinearLayout ll_evaluate,ll_store,ll_product_detail,ll_select_specification;
    private RadioButton RadioButton1;

    private PopupWindow popupWindow;// 声明PopupWindow
    private View popupView;// 声明PopupWindow对应的视图
    private TranslateAnimation animation;// 声明平移动画

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_commodity_details);
        baseTop.setVisibility(View.GONE);
        banner = findViewById(R.id.banner);
        re_1 = findViewById(R.id.re_1);
        re_2 = findViewById(R.id.re_2);
        ll_evaluate = findViewById(R.id.ll_evaluate);
        RadioButton1 = findViewById(R.id.RadioButton1);
        ll_store = findViewById(R.id.ll_store);
        ll_product_detail = findViewById(R.id.ll_product_detail);
        im_return = findViewById(R.id.im_return);
        ll_select_specification = findViewById(R.id.ll_select_specification);
    }

    @Override
    protected void initEvent() {

        ll_evaluate.setOnClickListener(this);
        RadioButton1.setOnClickListener(this);
        ll_store.setOnClickListener(this);
        ll_product_detail.setOnClickListener(this);
        im_return.setOnClickListener(this);
        ll_select_specification.setOnClickListener(this);

        layoutManager = new LinearLayoutManager(Commodity_detailsActivity.this);
        re_1.setLayoutManager(layoutManager);
        adapter = new Recycle_oneAdapter(Commodity_detailsActivity.this, list);
        re_1.setAdapter(adapter);
        adapter.setOnItemClickListener(new Recycle_oneAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {


            }



        });
        layoutManager1 = new LinearLayoutManager(Commodity_detailsActivity.this);
        re_2.setLayoutManager(layoutManager1);
        adapter1 = new Recycle_twoAdapter(Commodity_detailsActivity.this, list2);
        re_2.setAdapter(adapter1);
        adapter1.setOnItemClickListener(new Recycle_twoAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {


            }



        });
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
        banner.setImageLoader(new Commodity_detailsActivity.MyLoader());
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
        switch (v.getId()){
            case R.id.ll_evaluate://查看评价
                Intent intent = new Intent(Commodity_detailsActivity.this,EvaluateActivity.class);
                startActivity(intent);
                break;
            case R.id.RadioButton1://首页
                Intent intent1 = new Intent(Commodity_detailsActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.ll_store://进入店铺
                Intent intent2 = new Intent(Commodity_detailsActivity.this,StoreActivity.class);
                startActivity(intent2);
                break;
            case R.id.ll_product_detail://宝贝详情
                Intent intent3 = new Intent(Commodity_detailsActivity.this,Product_detailActivity.class);
                startActivity(intent3);
                break;
            case R.id.im_return:
                finish();
                break;
            case R.id.ll_select_specification://选择商品规格
                changeIconcar();
                break;
        }
    }

    /*加入购物车*/
    private void changeIconcar() {
        if (popupWindow == null) {
            popupView = View.inflate(Commodity_detailsActivity.this, R.layout.pop_layout_guige, null);

            final AmountView2 amount_view = popupView.findViewById(R.id.amount_view);
            final TextView tv1 = popupView.findViewById(R.id.tv1);
            final TextView tv2 = popupView.findViewById(R.id.tv2);
            final TextView tv3 = popupView.findViewById(R.id.tv3);
            final TextView tv4 = popupView.findViewById(R.id.tv4);
            RoundedImageView image2 = popupView.findViewById(R.id.image2);



//            name3 = popupView.findViewById(R.id.name3);
//            name3.setMaxSelectCount(1);
//            boolean clickable = name3.isClickable();
//            final List<String> stringList = new ArrayList<>();
//            for (int j = 0; j < flowData.size(); j++) {
//                stringList.add(flowData.get(j).getName());
//            }


//            TagAdapter tagAdapter = new TagAdapter<String>(stringList) {
//                @Override
//                public View getView(FlowLayout parent, int position, String s) {
//                    TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.tv, name3, false);
//                    tv.setText(s);
//                    return tv;
//                }
//
//                @Override
//                public void onSelected(int i, View view) {
//                    super.onSelected(i, view);
//
//
//                }
//
//                @Override
//                public void unSelected(int position, View view) {
//                    super.unSelected(position, view);
//                    Log.i(TAG, "unSelected: 未选中" + position);
//                }
//            };

//            tagAdapter.setSelectedList(0);
//            name3.setAdapter(tagAdapter);


            tv2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//在文字中间画横线


//            Picasso.with(mContext).load(caimoguDetailBean.getCover()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(image2);

            //处理下单数量
//            amount_view.setGoods_storage(MoGuSP.AmountView);//设置最大值

            amount_view.setOnAmountChangeListener(new AmountView2.OnAmountChangeListener() {
                @Override
                public void onAmountChange(View view, int amount) {

//                    if (isSelect) {
//                        goodNumber = amount + "";
//                    } else {
//
//                        ToastFactory.getToast(CuiCaiMoGuDetailActivity.this, "请先选择规格类型").show();
//                        return;
//                    }


                }
            });


            // 参数2,3：指明popupwindow的宽度和高度
            popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
//                    lighton();
                }
            });
            // 设置背景图片， 必须设置，不然动画没作用
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            popupWindow.setFocusable(true);
            // 设置点击popupwindow外屏幕其它地方消失
            popupWindow.setOutsideTouchable(true);

            // 平移动画相对于手机屏幕的底部开始，X轴不变，Y轴从1变0
            animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,
                    Animation.RELATIVE_TO_PARENT, 1, Animation.RELATIVE_TO_PARENT, 0);
            animation.setInterpolator(new AccelerateInterpolator());
            animation.setDuration(200);

            popupView.findViewById(R.id.cancle).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
//                    lighton();
                }
            });
            popupView.findViewById(R.id.okID).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO 下单,跳转页面




                }
            });








            /*处理分享部分完*/
        }
        // 在点击之后设置popupwindow的销毁
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
//            lighton();
        }
        // 设置popupWindow的显示位置，此处是在手机屏幕底部且水平居中的位置
        popupWindow.showAtLocation(Commodity_detailsActivity.this.findViewById(R.id.ll_on), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        popupView.startAnimation(animation);
    }
}
