package com.lx.whsq.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseFragment;
import com.lx.whsq.liactivity.AboutActivity;
import com.lx.whsq.liactivity.CollectActivity;
import com.lx.whsq.liactivity.EntityActivity;
import com.lx.whsq.liactivity.FaqActivity;
import com.lx.whsq.liactivity.GeneyActivity;
import com.lx.whsq.liactivity.GiftActivity;
import com.lx.whsq.liactivity.InviteActivity;
import com.lx.whsq.liactivity.ManageActivity;
import com.lx.whsq.liactivity.MessageActivity;
import com.lx.whsq.liactivity.NationwideActivity;
import com.lx.whsq.liactivity.PersonalActivity;
import com.lx.whsq.liactivity.ProductActivity;
import com.lx.whsq.liactivity.RecommendActivity;
import com.lx.whsq.liactivity.SetActivity;
import com.lx.whsq.liactivity.ShopActivity;
import com.lx.whsq.liactivity.ShoppingActivity;
import com.lx.whsq.liactivity.VenderActivity;

public class Home4Fragment extends BaseFragment implements View.OnClickListener{

    private ImageView im_message,im_set,tv_nationwide;
    private LinearLayout ll_about,ll_inquire,ll_personal_details,ll_product,ll_gift,ll_recommend,ll_my_shop,ll_collect,ll_vender,ll_entity,ll_manage,ll_invite,ll_geney,ll_faq,ll_Shopping;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        initView(view);
        initData();
        return view;
    }
    private void initView(View view) {
        im_message = view.findViewById(R.id.im_message);
        im_set = view.findViewById(R.id.im_set);
        ll_personal_details = view.findViewById(R.id.ll_personal_details);
        ll_product = view.findViewById(R.id.ll_product);
        ll_gift = view.findViewById(R.id.ll_gift);
        tv_nationwide = view.findViewById(R.id.tv_nationwide);
        ll_recommend = view.findViewById(R.id.ll_recommend);
        ll_my_shop = view.findViewById(R.id.ll_my_shop);
        ll_collect = view.findViewById(R.id.ll_collect);
        ll_vender = view.findViewById(R.id.ll_vender);
        ll_entity = view.findViewById(R.id.ll_entity);
        ll_manage = view.findViewById(R.id.ll_manage);
        ll_invite = view.findViewById(R.id.ll_invite);
        ll_geney = view.findViewById(R.id.ll_geney);
        ll_faq = view.findViewById(R.id.ll_faq);
        ll_Shopping = view.findViewById(R.id.ll_Shopping);
        ll_inquire = view.findViewById(R.id.ll_inquire);
        ll_about = view.findViewById(R.id.ll_about);


    }
    private void initData() {
        im_message.setOnClickListener(this);
        im_set.setOnClickListener(this);
        ll_personal_details.setOnClickListener(this);
        ll_product.setOnClickListener(this);
        ll_gift.setOnClickListener(this);
        tv_nationwide.setOnClickListener(this);
        ll_recommend.setOnClickListener(this);
        ll_my_shop.setOnClickListener(this);
        ll_collect.setOnClickListener(this);
        ll_vender.setOnClickListener(this);
        ll_entity.setOnClickListener(this);
        ll_manage.setOnClickListener(this);
        ll_invite.setOnClickListener(this);
        ll_geney.setOnClickListener(this);
        ll_faq.setOnClickListener(this);
        ll_Shopping.setOnClickListener(this);
        ll_inquire.setOnClickListener(this);
        ll_about.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_message://消息
                Intent intent = new Intent(getActivity(), MessageActivity.class);
                startActivity(intent);
                break;
            case R.id.im_set://设置
                Intent intent1 = new Intent(getActivity(), SetActivity.class);
                startActivity(intent1);
                break;
            case R.id.ll_personal_details://个人信息
                Intent intent2 = new Intent(getActivity(), PersonalActivity.class);
                startActivity(intent2);
                break;
            case R.id.ll_product://申请单品代理
                Intent intent3 = new Intent(getActivity(), ProductActivity.class);
                startActivity(intent3);
                break;
            case R.id.ll_gift://申请赠品单品代理
                Intent intent4 = new Intent(getActivity(), GiftActivity.class);
                startActivity(intent4);
                break;
            case R.id.tv_nationwide://申请全国商家总店
                Intent intent5 = new Intent(getActivity(), NationwideActivity.class);
                startActivity(intent5);
                break;
            case R.id.ll_recommend://推荐店铺
                Intent intent6 = new Intent(getActivity(), RecommendActivity.class);
                startActivity(intent6);
                break;
            case R.id.ll_my_shop://我的小店
                Intent intent7 = new Intent(getActivity(), ShopActivity.class);
                startActivity(intent7);
                break;
            case R.id.ll_collect://收藏的店
                Intent intent8 = new Intent(getActivity(), CollectActivity.class);
                startActivity(intent8);
                break;
            case R.id.ll_vender://厂家入驻
                Intent intent9 = new Intent(getActivity(), VenderActivity.class);
                startActivity(intent9);
                break;
            case R.id.ll_entity://实体厂家入驻
                Intent intent10 = new Intent(getActivity(), EntityActivity.class);
                startActivity(intent10);
                break;
            case R.id.ll_manage://店铺管理
                Intent intent11 = new Intent(getActivity(), ManageActivity.class);
                startActivity(intent11);
                break;
            case R.id.ll_invite://邀请
                Intent intent12 = new Intent(getActivity(), InviteActivity.class);
                startActivity(intent12);
                break;
            case R.id.ll_geney://实体店铺管理
                Intent intent13 = new Intent(getActivity(), GeneyActivity.class);
                startActivity(intent13);
                break;
            case R.id.ll_faq://常见问题
                Intent intent14 = new Intent(getActivity(), FaqActivity.class);
                startActivity(intent14);
                break;
            case R.id.ll_Shopping://购物车
                Intent intent15 = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent15);
                break;
            case R.id.ll_inquire://已有单品代理查询
                Intent intent16 = new Intent(getActivity(), ShopActivity.class);
                startActivity(intent16);
                break;
            case R.id.ll_about://关于我们
                Intent intent17 = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent17);
                break;
        }
    }




    @Override
    public void onResume() {
        super.onResume();
    }
}
