package com.lx.whsq.common;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.lx.whsq.R;
import com.lx.whsq.base.SPTool;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

public class MyApplication extends Application {

    public static boolean isDebug = true;


    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }


    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    public static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
        SPTool.init(mContext, "我惠省钱");
        // 主要是添加下面这句代码
        MultiDex.install(this); //65536



        //极光
        /*JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        String registrationID = JPushInterface.getRegistrationID(this);
        SPTool.addSessionMap(ContextAndSP.JupshID, registrationID);*/


        /**
         * 设置组件化的Log开关
         * 参数: boolean 默认为false，如需查看LOG设置为true
         */
        //UMConfigure.setLogEnabled(true);

        /**
         * 设置日志加密
         * 参数：boolean 默认为false（不加密）
         */
        //UMConfigure.setEncryptEnabled(false);

        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数3:Push推送业务的secret
         */
        //初始化友盟,Key在清单文件写过这里就不在需要了,推送不需要传入空字符串
        //UMConfigure.init(this, "5d3a983e570df35d7f00033d", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "");

        //三方登录
        //PlatformConfig.setWeixin("wx95cd1c8712ab503b", "fa244653749750442ced2b83f76f46f6");
        //PlatformConfig.setQQZone("1109701032", "2bLKfnAllFT6Dqwm");//
        //PlatformConfig.setSinaWeibo("353419546", "a091c5a7c817086d9c7b1b5fc654810f", "https://api.weibo.com/oauth2/default.html");

        //PlatformConfig.setSinaWeibo("353419546", "a091c5a7c817086d9c7b1b5fc654810f", "https://api.weibo.com/oauth2/default.html");

    }
}
