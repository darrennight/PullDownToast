package com.dk.util;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;


public class PullDownToastUtil {

    private static final int MESSAGE_CODE = 101;

    private static PopupWindow mPop;

    private static Handler mHandler;

    protected static int mResourceId = -1;
    protected static int mTextColor = -1;

    public static void init() {
        mHandler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                mPop.dismiss();
            };
        };
    }

    private static PopupWindow getPopUpWindow(Context context, String content) {

        if (mPop == null) {
            mPop = new PopupWindow(context);
            mPop.setBackgroundDrawable(context.getResources().getDrawable(android.R.color.transparent));
            TextView tv = new TextView(context);
            tv.setPadding(10, 10, 10, 10);
            tv.setTextSize(14);
            tv.setTextColor(0xffffffff);

            // mPop.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.style_pop));
            if (mResourceId > 0) {
                tv.setBackgroundResource(mResourceId);
            }

            if (mTextColor > 0) {
                tv.setTextColor(mTextColor);
            }

            tv.setGravity(Gravity.CENTER_HORIZONTAL);
            mPop.setContentView(tv);
            mPop.setWidth(LayoutParams.MATCH_PARENT);
            mPop.setHeight(LayoutParams.WRAP_CONTENT);
            mPop.setFocusable(false);
            mPop.setOutsideTouchable(true);
            mPop.setContentView(tv);
        }
        ((TextView)mPop.getContentView()).setText(content);
        return mPop;
    }

    public static void showMessage(View anchor, String content) {
        PopupWindow message = getPopUpWindow(anchor.getContext(), content);
        message.showAsDropDown(anchor);
        // message.setAnimationStyle(R.anim.pull_down_show);
        mHandler.sendEmptyMessageDelayed(MESSAGE_CODE, 2000);
    }

    public static void showMessage(View anchor, String content, View parent, int gravity, int x, int y) {
        PopupWindow message = getPopUpWindow(anchor.getContext(), content);
        message.showAtLocation(parent, gravity, x, y);
        mHandler.sendEmptyMessageDelayed(MESSAGE_CODE, 2000);
    }

    public static void setBackgroundResource(int resourceId) {
        mResourceId = resourceId;
    }

    public static void setTextColor(int color) {
        mTextColor = color;
    }

    /**
     * TO DO
     * 
     * @param attributeSet
     */
    public static void setStyles(AttributeSet attributeSet) {

    }

}
