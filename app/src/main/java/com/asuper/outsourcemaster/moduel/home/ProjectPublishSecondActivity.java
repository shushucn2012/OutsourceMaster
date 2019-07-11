package com.asuper.outsourcemaster.moduel.home;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.asuper.outsourcemaster.BaseActivity;
import com.asuper.outsourcemaster.R;
import com.asuper.outsourcemaster.common.set.AppUrl;
import com.asuper.outsourcemaster.common.set.GlobalParam;
import com.asuper.outsourcemaster.common.set.ParamBuild;
import com.asuper.outsourcemaster.common.tool.ExitAppUtils;
import com.asuper.outsourcemaster.moduel.home.bean.ChosenConfigCache;
import com.asuper.outsourcemaster.net.base.Request;
import com.asuper.outsourcemaster.net.request.interfa.BaseRequestListener;
import com.asuper.outsourcemaster.net.request.interfa.JsonRequestListener;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shubei on 2017/9/14.
 */

public class ProjectPublishSecondActivity extends BaseActivity {

    private EditText edit_p_name, edit_p_introduce, edit_p_example;
    private Button btn_next;


    @Override
    public void setLayout() {
        setContentView(R.layout.activity_p_publish_second);
    }

    @Override
    public void initView() {
        edit_p_name = (EditText) findViewById(R.id.edit_p_name);
        edit_p_introduce = (EditText) findViewById(R.id.edit_p_introduce);
        edit_p_example = (EditText) findViewById(R.id.edit_p_example);

        btn_next = (Button) findViewById(R.id.btn_next);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edit_p_name.getText().toString().trim())) {
                    showShortToast("项目名称未输入！");
                    return;
                }
                if (TextUtils.isEmpty(edit_p_introduce.getText().toString().trim())) {
                    showShortToast("项目简介未输入！");
                    return;
                }
                if (TextUtils.isEmpty(edit_p_example.getText().toString().trim())) {
                    showShortToast("参考网站/产品未输入！");
                    return;
                }
                ChosenConfigCache.getInstance().name = edit_p_name.getText().toString().trim();
                ChosenConfigCache.getInstance().description = edit_p_introduce.getText().toString().trim();
                ChosenConfigCache.getInstance().demo_website = edit_p_example.getText().toString().trim();
                if (GlobalParam.userToken == null) {
                    startActivity(new Intent(mContext, ProjectPublishThirdActivity.class));
                } else {
                    asyncPublish();
                }
            }
        });
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
        map.put("token", GlobalParam.userToken);
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
            startActivity(new Intent(mContext, ProjectSuccessActivity.class));
            if (ExitAppUtils.getInstance().getBeforeActivity() != null) {
                ExitAppUtils.getInstance().getBeforeActivity().finish();
            }
            finish();
        }
    };
}
