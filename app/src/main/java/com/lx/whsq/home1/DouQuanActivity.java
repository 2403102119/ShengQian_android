package com.lx.whsq.home1;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.BaseActivity;
import com.lx.whsq.base.ToastFactory;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class DouQuanActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView recyclerView;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.douquan_activity);
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
        titleName.setText("抖券");

        recyclerView = findViewById(R.id.RecyclerView);
        LinearLayout View1 = findViewById(R.id.View1);
        LinearLayout View2 = findViewById(R.id.View2);
        View1.setOnClickListener(this);
        View2.setOnClickListener(this);

        JZVideoPlayerStandard jzVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
        jzVideoPlayerStandard.setUp("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4",
        //jzVideoPlayerStandard.setUp("http://7xjmzj.com1.z0.glb.clouddn.com/20171026175005_JObCxCE2.mp4",
                JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "抖券商品的名称");
        //jzVideoPlayerStandard.thumbImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");


    }


    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
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
            case R.id.View1:
                ToastFactory.getToast(mContext, "点到购买").show();
                break;
            case R.id.View2:
                ToastFactory.getToast(mContext, "点到分享----------").show();
                break;
        }
    }
}
