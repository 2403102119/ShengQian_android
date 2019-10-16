package com.lx.whsq.home1;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;

public class HuoChePiaoSelectPopActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.huochepiaoselectpop_activity);
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
        titleName.setText("05.03 周二 车次信息页面");

        TextView View1 = findViewById(R.id.View1);
        View1.setOnClickListener(this);

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }


    // 声明PopupWindow
    private PopupWindow popupWindow;
    // 声明PopupWindow对应的视图
    private View popupView;
    // 声明平移动画
    private TranslateAnimation animation;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.View1:
                //修改/添加乘车人
                tanPop1();
                lightoff();
                break;
        }
    }

    private void tanPop1() {
        if (popupWindow == null) {
            popupView = View.inflate(mContext, R.layout.item_pop_layout, null);
            // 参数2,3：指明popupwindow的宽度和高度
            popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.WRAP_CONTENT);

            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    lighton();
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
            popupView.findViewById(R.id.View1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                    startActivity(new Intent(mContext,BianjiChengCheRenActivity.class));

                }
            });
            popupView.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });


            popupView.findViewById(R.id.okID).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();


                }
            });



        }

        // 在点击之后设置popupwindow的销毁
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
            lighton();
        }

        // 设置popupWindow的显示位置，此处是在手机屏幕底部且水平居中的位置
        popupWindow.showAtLocation(findViewById(R.id.setting), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        popupView.startAnimation(animation);
    }

    /**
     * 设置手机屏幕亮度变暗
     */
    private void lightoff() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.3f;
        getWindow().setAttributes(lp);
    }

    /**
     * 设置手机屏幕亮度显示正常
     */
    private void lighton() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 1f;
        getWindow().setAttributes(lp);
    }
}
