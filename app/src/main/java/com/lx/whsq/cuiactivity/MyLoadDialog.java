package com.lx.whsq.cuiactivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.lx.whsq.R;


/**
 * [进度加载对话框]用来设置相关的对话框
 *
 * @author: mashidong
 * @version: 1.0
 * @date: 20190213
 */
public class MyLoadDialog extends Dialog {

    /**
     * LoadDialog
     */
    private static MyLoadDialog loadDialog;
    /**
     * cancelable, the dialog dimiss or undimiss flag
     */
    private boolean cancelable;
    /**
     * if the dialog don't dimiss, what is the tips.
     */
    private String tipMsg;

    /**
     * the LoadDialog constructor
     *
     * @param ctx        Context
     * @param cancelable boolean
     * @param tipMsg     String
     */

    public MyLoadDialog(final Context ctx, boolean cancelable, String tipMsg) {
        super(ctx);
        if (null != ctx) {
            Log.e("当前展示覆辙页面", "MyLoadDialog: " + ctx.getClass().getName());
            this.cancelable = cancelable;
            this.tipMsg = tipMsg;
            this.getContext().setTheme(android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth);
            setContentView(R.layout.dialog_layout);
            // 必须放在加载布局后
            setparams();
            /*ImageView iv = findViewById(R.id.loading_progress);
            new ImageLoadHelper((Activity) ctx, iv).showLocalImage(R.drawable.load);*/
        }
    }

    private void setparams() {
        this.setCancelable(false);
        this.setCanceledOnTouchOutside(false);
        WindowManager windowManager = getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        // Dialog宽度
        lp.width = (int) (display.getWidth());
        lp.height = (int) (display.getHeight());
        Window window = getWindow();
        window.setAttributes(lp);
        window.getDecorView().getBackground().setAlpha(0);


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!cancelable) {
                Toast.makeText(getContext(), tipMsg, Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * show the dialog
     *
     * @param context
     */
    public static void show(Context context) {
        show(context, null, true);
    }

    /**
     * show the dialog
     *
     * @param context Context
     * @param message String
     */
    public static void show(Context context, String message) {
        show(context, message, true);
    }

    /**
     * show the dialog
     *
     * @param context    Context
     * @param resourceId resourceId
     */
    public static void show(Context context, int resourceId) {
        show(context, context.getResources().getString(resourceId), true);
    }

    /**
     * show the dialog
     *
     * @param context    Context
     * @param message    String, show the message to user when isCancel is true.
     * @param cancelable boolean, true is can't dimiss，false is can dimiss
     */
    private static void show(Context context, String message, boolean cancelable) {
        if (context instanceof Activity) {
            if (((Activity) context).isFinishing()) {
                return;
            }
        }
        if (loadDialog != null && loadDialog.isShowing()) {
            return;
        }
        loadDialog = new MyLoadDialog(context, cancelable, message);
        loadDialog.show();
    }

    /**
     * dismiss the dialog
     */
    public static void dismiss(Context context) {
        try {
            if (context instanceof Activity) {
                if (((Activity) context).isFinishing()) {
                    loadDialog = null;
                    return;
                }
            }

            if (loadDialog != null && loadDialog.isShowing()) {
                Context loadContext = loadDialog.getContext();
                if (loadContext instanceof Activity) {
                    if (((Activity) loadContext).isFinishing()) {
                        loadDialog = null;
                        return;
                    }
                }
                loadDialog.dismiss();
                loadDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            loadDialog = null;
        }
    }
}
