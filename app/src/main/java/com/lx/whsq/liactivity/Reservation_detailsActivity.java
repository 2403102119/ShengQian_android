package com.lx.whsq.liactivity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class Reservation_detailsActivity extends BaseActivity implements View.OnClickListener{

    private ImageView im_gantan;
    PopupWindow state2;
    private LinearLayout state_xxx;
    private RelativeLayout state3;
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContainer(R.layout.activity_reservation_details);
        setTopTitle("预订详情");
        im_gantan = findViewById(R.id.im_gantan);
    }

    @Override
    protected void initEvent() {
        im_gantan.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_gantan:
                state();
                state_xxx.startAnimation(AnimationUtils.loadAnimation(this,R.anim.activity_translate_in));
                state2.showAtLocation(v, Gravity.BOTTOM,0,0);
                break;
        }
    }
    public  void  state() {
        state2 = new PopupWindow(this);
        View view = getLayoutInflater().inflate(R.layout.coin_no, null);
        state_xxx = view.findViewById(R.id.state_xx);
        state2.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        state2.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        state2.setBackgroundDrawable(new BitmapDrawable());
        state2.setFocusable(true);
        state2.setOutsideTouchable(true);
        state2.setContentView(view);
        state3 = view.findViewById(R.id.state_xxx);
        state3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state2.dismiss();
                state_xxx.clearAnimation();
            }
        });

    }

    }
