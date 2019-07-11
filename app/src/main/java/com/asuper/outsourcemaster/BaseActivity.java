package com.asuper.outsourcemaster;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.asuper.outsourcemaster.R;
import com.asuper.outsourcemaster.common.set.Log;
import com.asuper.outsourcemaster.common.tool.ExitAppUtils;
import com.asuper.outsourcemaster.common.tool.ToastUtil;
import com.asuper.outsourcemaster.net.request.StringNetRequest;
import com.asuper.outsourcemaster.widget.dialog.CommonProgressDialog;
import com.asuper.outsourcemaster.widget.dialog.DoubleDialog;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.umeng.analytics.MobclickAgent;

/**
 * 基础activity类
 *
 * @author super
 */
public abstract class BaseActivity extends FragmentActivity {
    public Context mContext;
    /**
     * log打印需要用到的标签
     */
    public String Tag = "BaseActivity";
    public String actTag;// 网络请求标记，用于标识请求以便取消
    /**
     * 传入参数为字符串拼接方式的网络请求实例
     */
    public StringNetRequest netRequest;
    public CommonProgressDialog commonProgressDialog;
    public DoubleDialog dDialog;

    public View area_left, area_right;
    public TextView page_title;
    public DisplayImageOptions options;

    public String shareUrl = "", sharePic = "", shareTitle = "", shareDescription = "";

    public OnClickListener rOnClickListener;

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setLayout();
        ExitAppUtils.getInstance().addActivity(this);
        Tag = this.getClass().getSimpleName();
        logout("Tag------onCreate-----" + Tag);
        actTag = Tag + System.currentTimeMillis();
        netRequest = StringNetRequest.getInstance(mContext);
        netRequest.setActTag(actTag);
        commonProgressDialog = new CommonProgressDialog(mContext);
        // 进度框不可取消
        setCancelable(false);
        dDialog = new DoubleDialog(mContext);
        options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.default_pic)
                .showImageOnLoading(R.mipmap.default_pic)
                .showImageOnFail(R.mipmap.default_pic)
                .cacheInMemory(true).cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .delayBeforeLoading(100)
                .build();
        initView();
        initData();
        initTopBar();
        initListener();
    }

    private void initTopBar() {
        area_left = findViewById(R.id.area_left);
        area_right = findViewById(R.id.area_right);
        if (area_left != null) {
            area_left.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
        if (area_right != null) {
            area_right.setOnClickListener(rOnClickListener);
        }
    }

    public void setROnClickListener(OnClickListener lsner) {
        rOnClickListener = lsner;
    }

    @Override
    protected void onResume() {
        super.onResume();
        netRequest.setActTag(actTag);
        MobclickAgent.onPageStart(Tag);
        MobclickAgent.onResume(mContext);
    }

    @Override
    protected void onPause() {
        super.onPause();
        logout("Tag------onPause-----" + Tag);
        MobclickAgent.onPageEnd(Tag);
        MobclickAgent.onPause(mContext);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        netRequest.setActTag(actTag);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        netRequest.cancelAllRequest(actTag);
        logout("---onDestroy---netRequest---cancelAllRequest---" + actTag);
        ExitAppUtils.getInstance().delActivity(this);
    }

    /**
     * 设置布局
     */
    public abstract void setLayout();

    /**
     * 初始化视图
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化监听事件
     */
    public abstract void initListener();

    /**
     * 设置页面标题
     */
    public void setPagTitle(String str) {
        page_title = (TextView) findViewById(R.id.page_title);
        page_title.setText(str);
    }

    /**
     * 打印日志
     */
    public void logout(String msg) {
        Log.out(msg);
    }


    /**
     * toast短提示
     */
    public void showShortToast(String text) {
        //Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();

        ToastUtil toastUtil = new ToastUtil();
        toastUtil.Short(mContext, text).setToastBackground(Color.WHITE, R.drawable.toast_radius).show();
        toastUtil.getToast().setGravity(Gravity.TOP, 0, 0);
        toastUtil.show();
    }

    public void showDialog() {
        try {
            if (commonProgressDialog.isShow()) {
                return;
            } else {
                commonProgressDialog.showDialog(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showDialog(String msg) {
        try {
            if (commonProgressDialog.isShow()) {
                commonProgressDialog.setMessage(msg);
            } else {
                commonProgressDialog.showDialog(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCancelable(boolean is) {
        commonProgressDialog.setCancelable(is);
    }

    public void dismissDialog() {
        try {
            if (commonProgressDialog.isShow()) {
                commonProgressDialog.dialogDismiss();
            } else {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isDialogShowing() {
        return commonProgressDialog.isShow();
    }

}
