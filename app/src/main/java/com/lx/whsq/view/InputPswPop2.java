package com.lx.whsq.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lx.whsq.R;
import com.lx.whsq.base.ToastFactory;


/**
 * Created by kxn on 2019/5/13 0013.
 */
public class InputPswPop2 extends PopupWindow {

    int checkPosition = -1;
    private static final String TAG = "InputPswPop";
    private final View view;
    boolean ischeck = false;

  /*  @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvMoney)
    TextView tvMoney;
    @BindView(R.id.tvAllCoin)
    TextView tvAllCoin;
    @BindView(R.id.inputEt)
    PayPsdInputView inputEt;
    @BindView(R.id.tvFindbackPsw)
    TextView tvFindbackPsw;
    @BindView(R.id.tvErrorHint)
    TextView tvErrorHint;*/

    public InputPswPop2(final Activity context, String title, String num, final OnSuccessListener onSuccessListener) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.pop_input_paypswtext, null);
        //ButterKnife.bind(this, view);

        LinearLayout ll = view.findViewById(R.id.ll);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvMoney = view.findViewById(R.id.tvMoney);
        TextView tvAllCoin = view.findViewById(R.id.tvAllCoin);
        final PayPsdInputViewMi inputEt = view.findViewById(R.id.inputEt);
        final TextView tvFindbackPsw = view.findViewById(R.id.tvFindbackPsw);
        final TextView tvErrorHint = view.findViewById(R.id.tvErrorHint);
        final TextView tv_cancel = view.findViewById(R.id.tv_cancel);//取消
        final TextView tv_ok = view.findViewById(R.id.tv_ok);//确定
        final TextView tvFei = view.findViewById(R.id.tvFei);//手续费
        final LinearLayout View2 = view.findViewById(R.id.View2);//手续费布局
        final CheckBox check2 = view.findViewById(R.id.check2);//是否使用积分

        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ischeck = isChecked;
            }
        });

        tvFei.setText(num);
        tvTitle.setText(title);
        //tvMoney.setText("￥ " + num);
        //tvAllCoin.setText("测试文本");


        tvFindbackPsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastFactory.getToast(view.getContext(), "点到找回密码").show();
                //context.startActivity(new Intent(context, ZhaoHuiPayActivity.class));


            }
        });
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        /*tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastFactory.getToast(view.getContext(), "确认支付").show();
            }
        });*/



        /*tvFindbackPsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ToastFactory.getToast(view.getContext(), "点到找回密码").show();
                //校验支付密码是否正确
                //jiaoyanPay(MoGuNetMethod.checkPayWord, MD5Util.encrypt(inputEt.getText().toString().trim()), SPTool.getSessionValue(MoGuSP.uid));
            }

            *//*校验支付密码*//*
            private void jiaoyanPay(String checkPayWord, String payWord, String uid) {
                String jsonValue = "{\"cmd\":\"" + checkPayWord + "\",\"payWord\":\"" + payWord + "\",\"uid\":\"" + uid + "\"}";


                Log.i(TAG, "校验支付密码: " + jsonValue + "----" + NetClass.BASE_URL + "----");
                OkHttpUtils.post().url(NetClass.BASE_URL).addParams("json", jsonValue)
                        .build().execute(new StringCallback() {

                    @Override
                    public void onError(Call call, Exception e, int id) {

                        Log.i(TAG, "onError: 校验支付密码" + e.toString());
                        //ToastFactory.getToast(XuPayActivity.this, "网络错误,请稍后重试").show();
                        return;
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        //dismissLoading();
                        Log.i(TAG, "onResponse: 校验支付密码--------" + response);

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String resultNote = (String) jsonObject.get("resultNote");
                            String result = (String) jsonObject.get("result");
                            if (result.equals("0")) {
                                onSuccessListener.onSuccesss();
                                dismiss();
                            } else if (result.equals("1")) {
                                inputEt.cleanPsd();
                                ToastFactory.getToast(view.getContext(), resultNote).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });*/
        inputEt.requestFocus();
        inputEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == 6) {
//                    if (MD5Util.encrypt(editable.toString().trim()).equals(SPTool.getSessionValue(MoGuSP.payPaw))) {
                    if (!TextUtils.isEmpty(editable.toString())) {

                        //dismiss();
                    } else {
                        tvErrorHint.setVisibility(View.VISIBLE);
                        inputEt.setText("");
                    }
                }
            }
        });
        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputEt.getText().toString().length() == 6) {
                    onSuccessListener.onSuccesss(inputEt.getText().toString(), inputEt, ischeck);
                    dismiss();
                } else {
                    ToastFactory.getToast(context, "请输入6位密码").show();
                    return;
                }
            }
        });
        this.setContentView(view);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewPager.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewPager.LayoutParams.WRAP_CONTENT);
        // 在PopupWindow里面就加上下面两句代码，让键盘弹出时，不会挡住pop窗口。
        this.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        // 设置popupWindow以外可以触摸
        this.setOutsideTouchable(true);
        // 以下两个设置点击空白处时，隐藏掉pop窗口
        this.setFocusable(true);
        this.setBackgroundDrawable(new BitmapDrawable());
        // 设置popupWindow以外为半透明0-1 0为全黑,1为全白
//        backgroundAlpha(0.3f);
//        // 添加pop窗口关闭事件
//        setOnDismissListener(new PushTieFra.poponDismissListener());
        // 设置动画--这里按需求设置成系统输入法动画
        this.setAnimationStyle(R.style.AnimBottom);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = view.findViewById(R.id.ll)
                        .getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });
    }

    public interface OnSuccessListener {
        void onSuccesss(String paw, PayPsdInputViewMi inputView, boolean isChecked);
    }
}