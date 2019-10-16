package com.lx.whsq.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.lx.whsq.R;


/**
 * kylin on 2017/12/16.
 */

public class ActionDialog extends Dialog {

    Context context;//上下文
    private TextView dialog_title,dialog_content,dialog_left,dialog_right,tv_context,tv_context_two;
    private ImageView tip;

    private View henXian;

    public TextView getTitleText(){
        return dialog_title;
    }

    public TextView getLeftText(){
        return dialog_left;
    }

    public TextView getRightText(){
        return dialog_right;
    }

    private OnActionClickListener onActionClickListener;
    public interface OnActionClickListener{
        void onLeftClick();
        void onRightClick();
    }
    public void setOnActionClickListener(OnActionClickListener onActionClickListener){
        this.onActionClickListener = onActionClickListener;
    }


    public ActionDialog(Context context, String title,String text,String text_two, String left, String right) {
        super(context, R.style.processDialog);
        this.context = context;

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_action, null);
        dialog_title = view.findViewById(R.id.tv_title);
        dialog_left = view.findViewById(R.id.dialog_action_cancle);
        dialog_right = view.findViewById(R.id.dialog_action_confirm);
        henXian = view.findViewById(R.id.henXian);
        tv_context = view.findViewById(R.id.tv_context);
        tv_context_two = view.findViewById(R.id.tv_context_two);

        dialog_title.setText(title);
        dialog_left.setText(left);
        dialog_right.setText(right);
        tv_context.setText(text);
        tv_context_two.setText(text_two);

        dialog_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onActionClickListener!=null){
                    onActionClickListener.onLeftClick();
                }
                dismiss();
            }
        });

        dialog_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onActionClickListener!=null){
                    onActionClickListener.onRightClick();
                }
                dismiss();
            }
        });

        this.setContentView(view);
        this.setCancelable(false);
        this.setCanceledOnTouchOutside(false);

        Window window = this.getWindow();
        window.setGravity(Gravity.CENTER);
        //window.setWindowAnimations(R.style.actionDialog);
        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }





    private View divider;

    public ActionDialog(Context context , String titleStr,String text ,String rightStr, boolean cancleAble) {
        super(context, R.style.processDialog);
        this.context = context;

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_update, null);
        dialog_title = view.findViewById(R.id.tv_title);
        tv_context = view.findViewById(R.id.tv_context);
        dialog_left = view.findViewById(R.id.dialog_action_cancle);
        dialog_right = view.findViewById(R.id.dialog_action_confirm);
        henXian = view.findViewById(R.id.henXian);
        dialog_title.setText(titleStr);
        tv_context.setText(text);
        dialog_left.setText("取消");
        dialog_right.setText(rightStr);

        dialog_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onActionClickListener!=null){
                    onActionClickListener.onLeftClick();
                }
                dismiss();
            }
        });

        dialog_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onActionClickListener!=null){
                    onActionClickListener.onRightClick();
                }
                //dismiss();
            }
        });

        this.setContentView(view);
        this.setCancelable(cancleAble);
        this.setCanceledOnTouchOutside(false);

        Window window = this.getWindow();
        window.setGravity(Gravity.CENTER);
        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    public void setShowCancle(boolean b){
        if (b){
            dialog_left.setVisibility(View.VISIBLE);
            divider.setVisibility(View.VISIBLE);
        }else{
            dialog_left.setVisibility(View.GONE);
            divider.setVisibility(View.GONE);
        }
    }


    /*更新时的是否可取消*/
    public void setShowAction(boolean b){
        if (b){
            dialog_right.setVisibility(View.GONE);
            dialog_left.setVisibility(View.VISIBLE);
            divider.setVisibility(View.GONE);
            henXian.setVisibility(View.VISIBLE);
        }else{
            dialog_right.setVisibility(View.GONE);
            dialog_left.setVisibility(View.GONE);
            divider.setVisibility(View.GONE);
            henXian.setVisibility(View.GONE);
        }
    }


}
