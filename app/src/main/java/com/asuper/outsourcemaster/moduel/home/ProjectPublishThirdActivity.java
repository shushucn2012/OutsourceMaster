package com.asuper.outsourcemaster.moduel.home;

import android.content.Context;
import android.content.Intent;
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
import com.asuper.outsourcemaster.common.tool.ExitAppUtils;
import com.asuper.outsourcemaster.common.tool.RegexValidator;
import com.asuper.outsourcemaster.moduel.home.bean.ChosenConfigCache;
import com.asuper.outsourcemaster.moduel.login.LoginActivity;
import com.asuper.outsourcemaster.moduel.login.bean.UserBean;
import com.asuper.outsourcemaster.moduel.login.bean.UserManager;
import com.asuper.outsourcemaster.net.base.Request;
import com.asuper.outsourcemaster.net.request.interfa.BaseRequestListener;
import com.asuper.outsourcemaster.net.request.interfa.JsonRequestListener;
import com.asuper.outsourcemaster.widget.textview.AccoutSafeTimeTextView;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shubei on 2017/9/14.
 */

public class ProjectPublishThirdActivity extends BaseActivity {

    private Button btn_comit, btn_get_vcode;
    private EditText edit_p_company, edit_p_name, edit_p_mobile, edit_checkcode;
    private AccoutSafeTimeTextView ttv_time;

    private String company_name, true_name, mobile, check_code, stime;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_p_publish_third);
    }

    @Override
    public void initView() {
        btn_get_vcode = (Button) findViewById(R.id.btn_get_vcode);
        btn_comit = (Button) findViewById(R.id.btn_comit);
        edit_p_company = (EditText) findViewById(R.id.edit_p_company);
        edit_p_name = (EditText) findViewById(R.id.edit_p_name);
        edit_p_mobile = (EditText) findViewById(R.id.edit_p_mobile);
        edit_checkcode = (EditText) findViewById(R.id.edit_checkcode);
        ttv_time = (AccoutSafeTimeTextView) findViewById(R.id.ttv_time);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        btn_get_vcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateGetRegVcode())
                    return;
                //asyncGetRegVcode();
                asyncGetSTime();
            }
        });
        btn_comit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateReg())
                    return;
                asyncPublish();
            }
        });
    }

    protected boolean validateReg() {
        company_name = edit_p_company.getText().toString().trim();
        true_name = edit_p_name.getText().toString().trim();
        mobile = edit_p_mobile.getText().toString().trim();
        check_code = edit_checkcode.getText().toString().trim();
        if (TextUtils.isEmpty(true_name)) {
            showShortToast("联系人姓名没有填写！");
            return false;
        }
        if (TextUtils.isEmpty(mobile)) {
            showShortToast("登录手机号没有填写！");
            return false;
        }
        if (!RegexValidator.isMobile(mobile)) {
            showShortToast("手机号输入有误！");
            return false;
        }
        if (TextUtils.isEmpty(check_code)) {
            showShortToast("验证码没有填写！");
            return false;
        }
        return true;
    }

    protected boolean validateGetRegVcode() {
        mobile = edit_p_mobile.getText().toString().trim();
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

    /**
     * 日期字符串
     */
    protected void asyncGetSTime() {
        String wholeUrl = AppUrl.host + AppUrl.getCurrentTime;
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
     * 提交
     */
    protected void asyncPublish() {
        String wholeUrl = AppUrl.host + AppUrl.store;
        Map<String, Object> map = new HashMap<String, Object>();

        if (TextUtils.isEmpty(ChosenConfigCache.getInstance().package_id)) {
            map.put("package_id", "default");
        } else {
            map.put("package_id", ChosenConfigCache.getInstance().package_id);
        }
        map.put("category_1", ChosenConfigCache.getInstance().category_1);
        map.put("industry_1", ChosenConfigCache.getInstance().industry_1);
        map.put("name", ChosenConfigCache.getInstance().name);
        map.put("description", ChosenConfigCache.getInstance().description);
        map.put("demo_website", ChosenConfigCache.getInstance().demo_website);
        map.put("urgency", ChosenConfigCache.getInstance().urgency);
        map.put("budget", ChosenConfigCache.getInstance().budget);
        map.put("term", ChosenConfigCache.getInstance().term);
        //map.put("token", GlobalParam.userToken);
        map.put("mobile", mobile);
        map.put("true_name", true_name);
        map.put("company_name", company_name);
        map.put("check_code", check_code);

        String requestBodyData = ParamBuild.buildParams(map);
        netRequest.startRequest(wholeUrl, Request.Method.POST, requestBodyData, 0, plistener);
    }

    BaseRequestListener plistener = new JsonRequestListener() {

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
            String token = jsonResult.optString("token");
            UserBean userBean = new UserBean();
            userBean.setMobile(mobile);
            userBean.setToken(token);
            GlobalParam.userToken = userBean.getToken();
            GlobalParam.CurUser = userBean;
            saveCurrentUserName();
            startActivity(new Intent(mContext, ProjectSuccessActivity.class));
            if (ExitAppUtils.getInstance().getBeforeActivity() != null) {
                ExitAppUtils.getInstance().getBeforeActivity().finish();
            }
            if (ExitAppUtils.getInstance().getBeforePreActivity() != null) {
                ExitAppUtils.getInstance().getBeforePreActivity().finish();
            }
            finish();
        }
    };

    /**
     * 保存用户名，避免登录再输
     */
    protected void saveCurrentUserName() {
        SharedPreferences spf = getSharedPreferences(LoginActivity.FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.putString("username", mobile);
        editor.putString("logindate", DateTool.getCurrentDate());
        editor.putString("usertoken", GlobalParam.userToken);
        editor.commit();
        UserManager.getInstance().setAccountInfo(GlobalParam.CurUser, mContext);
    }
}
