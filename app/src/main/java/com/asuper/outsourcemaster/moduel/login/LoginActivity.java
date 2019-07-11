package com.asuper.outsourcemaster.moduel.login;


import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.asuper.outsourcemaster.BaseActivity;
import com.asuper.outsourcemaster.R;
import com.asuper.outsourcemaster.common.set.AppUrl;
import com.asuper.outsourcemaster.common.set.GlobalParam;
import com.asuper.outsourcemaster.common.set.ParamBuild;
import com.asuper.outsourcemaster.common.tool.DateTool;
import com.asuper.outsourcemaster.common.tool.RegexValidator;
import com.asuper.outsourcemaster.moduel.home.bean.SourceBean;
import com.asuper.outsourcemaster.moduel.login.bean.UserBean;
import com.asuper.outsourcemaster.moduel.login.bean.UserManager;
import com.asuper.outsourcemaster.net.base.Request;
import com.asuper.outsourcemaster.net.request.interfa.BaseRequestListener;
import com.asuper.outsourcemaster.net.request.interfa.JsonRequestListener;
import com.asuper.outsourcemaster.widget.textview.AccoutSafeTimeTextView;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shubei on 2017/6/24.
 */

public class LoginActivity extends BaseActivity {
    public static boolean isWXLogin = false;// 是否微信登陆
    public static String WX_CODE = "";// 微信登陆授权返回code

    public static final String FILE_NAME = "USER_INFO";

    private Button btn_get_vcode, btn_login;
    private EditText edit_username, edit_checkcode;
    private AccoutSafeTimeTextView ttv_time;

    private String mobile, vcode, stime;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_login);
    }

    @Override
    public void initView() {
        btn_get_vcode = (Button) findViewById(R.id.btn_get_vcode);
        btn_login = (Button) findViewById(R.id.btn_login);
        ttv_time = (AccoutSafeTimeTextView) findViewById(R.id.ttv_time);
        edit_username = (EditText) findViewById(R.id.edit_username);
        edit_checkcode = (EditText) findViewById(R.id.edit_checkcode);
    }

    @Override
    public void initData() {
        btn_get_vcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateGetRegVcode())
                    return;
                //asyncGetRegVcode();
                asyncGetSTime();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!validateReg())
                    return;
                asyncLogin();
            }
        });
    }

    protected boolean validateGetRegVcode() {
        mobile = edit_username.getText().toString().trim();
        if (TextUtils.isEmpty(mobile)) {
            showShortToast("登录手机号没有填写！");
            return false;
        }
        if (!RegexValidator.isMobile(mobile)) {
            showShortToast("手机号输入有误！");
            return false;
        }
        return true;
    }

    protected boolean validateReg() {
        mobile = edit_username.getText().toString().trim();
        vcode = edit_checkcode.getText().toString().trim();
        if (TextUtils.isEmpty(mobile)) {
            showShortToast("登录手机号没有填写！");
            return false;
        }
        if (!RegexValidator.isMobile(mobile)) {
            showShortToast("手机号输入有误！");
            return false;
        }
        if (TextUtils.isEmpty(vcode)) {
            showShortToast("验证码没有填写！");
            return false;
        }
        return true;
    }

    @Override
    public void initListener() {

    }

    /**
     * 日期字符串
     */
    protected void asyncGetSTime() {
        String wholeUrl = "http://59.110.44.184:8677" + AppUrl.getCurrentTime;
        netRequest.startRequest(wholeUrl, Request.Method.POST, "", 0, tLsner);
    }

    BaseRequestListener tLsner = new JsonRequestListener() {

        @Override
        public void onStart(int requestId) {
            showDialog();
        }

        @Override
        public void onError(int requestId, String errorCode, String errorMsg) {
            dismissDialog();
            showShortToast(errorMsg);
        }

        @Override
        public void onSuccess(int requestId, String url, JSONObject jsonResult) {
            dismissDialog();
            stime = jsonResult.optString("time");
            asyncGetRegVcode();
        }
    };

    /**
     * 发送验证码
     */
    protected void asyncGetRegVcode() {
        String wholeUrl = AppUrl.host + AppUrl.sendSms;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mobile", mobile);
        map.put("secret", ParamBuild.encodeMD5(stime + "waibaodashi"));
        String requestBodyData = ParamBuild.buildParams(map);
        netRequest.startRequest(wholeUrl, Request.Method.POST, requestBodyData, 0, getRegVcodeLsner);
    }

    BaseRequestListener getRegVcodeLsner = new JsonRequestListener() {

        @Override
        public void onStart(int requestId) {
            showDialog();
        }

        @Override
        public void onError(int requestId, String errorCode, String errorMsg) {
            dismissDialog();
            showShortToast(errorMsg);
        }

        @Override
        public void onSuccess(int requestId, String url, JSONObject jsonResult) {
            dismissDialog();
            showShortToast("验证码已发送！");
            reStartMyTimer();
        }
    };

    /**
     * 开始计时
     */
    public void reStartMyTimer() {
        if (!ttv_time.isRun()) {
            btn_get_vcode.setVisibility(View.GONE);
            ttv_time.setVisibility(View.VISIBLE);
            ttv_time.setTimes(new long[]{0, 0, 0, 61});
            ttv_time.run();
            ttv_time.setOnTimeEndLsner(new AccoutSafeTimeTextView.OnTimeEnd() {
                @Override
                public void onEnd() {
                    btn_get_vcode.setVisibility(View.VISIBLE);
                    ttv_time.setVisibility(View.GONE);
                }
            });
        }
    }


    /**
     * 登录
     */
    private void asyncLogin() {
        String wholeUrl = AppUrl.host + AppUrl.login;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mobile", mobile);
        map.put("check_code", vcode);
        String requestBodyData = ParamBuild.buildParams(map);
        netRequest.startRequest(wholeUrl, Request.Method.POST, requestBodyData, 0, loginLsner);
    }

    BaseRequestListener loginLsner = new JsonRequestListener() {

        @Override
        public void onStart(int requestId) {
            showDialog();
        }

        @Override
        public void onError(int requestId, String errorCode, String errorMsg) {
            dismissDialog();
            showShortToast(errorMsg);
        }

        @Override
        public void onSuccess(int requestId, String url, JSONObject jsonResult) {
            dismissDialog();
            UserBean userBean = new Gson().fromJson(jsonResult.toString(), UserBean.class);
            userBean.setMobile(mobile);
            GlobalParam.userToken = userBean.getToken();
            GlobalParam.CurUser = userBean;
            saveCurrentUserName();
            showShortToast("登录成功！");
            finish();
        }
    };

    /**
     * 保存用户名，避免登录再输
     */
    protected void saveCurrentUserName() {
        SharedPreferences spf = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.putString("username", mobile);
        editor.putString("logindate", DateTool.getCurrentDate());
        editor.putString("usertoken", GlobalParam.userToken);
        editor.commit();
        UserManager.getInstance().setAccountInfo(GlobalParam.CurUser, mContext);
    }

}
