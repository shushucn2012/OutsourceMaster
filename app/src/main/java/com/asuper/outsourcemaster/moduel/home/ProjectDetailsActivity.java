package com.asuper.outsourcemaster.moduel.home;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.asuper.outsourcemaster.BaseActivity;
import com.asuper.outsourcemaster.R;
import com.asuper.outsourcemaster.common.set.AppUrl;
import com.asuper.outsourcemaster.common.set.GlobalParam;
import com.asuper.outsourcemaster.common.set.ParamBuild;
import com.asuper.outsourcemaster.common.tool.DateTool;
import com.asuper.outsourcemaster.common.tool.HtmlParserTool;
import com.asuper.outsourcemaster.common.tool.ImageManager;
import com.asuper.outsourcemaster.moduel.home.bean.ChosenConfigCache;
import com.asuper.outsourcemaster.moduel.home.bean.ProjectDetailBean;
import com.asuper.outsourcemaster.moduel.home.bean.SourceDetailBean;
import com.asuper.outsourcemaster.net.base.Request;
import com.asuper.outsourcemaster.net.request.interfa.BaseRequestListener;
import com.asuper.outsourcemaster.net.request.interfa.JsonRequestListener;
import com.asuper.outsourcemaster.widget.SharePopWin;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shubei on 2017/9/15.
 */

public class ProjectDetailsActivity extends BaseActivity {

    private String pid;
    private ProjectDetailBean mProjectDetailBean;

    private TextView tv_p_title, tv_p_type, tv_p_hangye, tv_p_week, tv_p_createtime, tv_p_state, tv_manager_state, tv_contact_phone,
            tv_detail;

   /* private ImageView img_package;

    private WebView webview;
    private Button btn_put_order;*/

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_project_details);
    }

    @Override
    public void initView() {
//        img_package = (ImageView) findViewById(R.id.img_package);
        tv_p_title = (TextView) findViewById(R.id.tv_p_title);
        tv_p_type = (TextView) findViewById(R.id.tv_p_type);
        tv_p_hangye = (TextView) findViewById(R.id.tv_p_hangye);
        tv_p_week = (TextView) findViewById(R.id.tv_p_week);
        tv_p_createtime = (TextView) findViewById(R.id.tv_p_createtime);
        tv_p_state = (TextView) findViewById(R.id.tv_p_state);
        tv_manager_state = (TextView) findViewById(R.id.tv_manager_state);
        tv_contact_phone = (TextView) findViewById(R.id.tv_contact_phone);
        tv_detail = (TextView) findViewById(R.id.tv_detail);
    }

    @Override
    public void initData() {
        pid = getIntent().getStringExtra("pid");
        asyncGetPDetail();
    }

    @Override
    public void initListener() {
        /*btn_put_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChosenConfigCache.getInstance().clear();
                ChosenConfigCache.getInstance().package_id = mSourceDetailBean.getId();
                ChosenConfigCache.getInstance().category_1 = mSourceDetailBean.getType();
                ChosenConfigCache.getInstance().industry_1 = mSourceDetailBean.getIndustry();
                Intent it = new Intent(mContext, ProjectPublishFirstActivity.class);
                startActivity(it);
            }
        });*/
        area_right.setVisibility(View.GONE);
        /*area_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareUrl = "http://www.baidu.com";
                sharePic = AppUrl.SHARE_APP_ICON;
                shareTitle = "外包大师";
                shareDescription = "解决方案";
                Intent it = new Intent(mContext, SharePopWin.class);
                it.putExtra("shareUrl", shareUrl);
                it.putExtra("picUrl", sharePic);
                it.putExtra("title", shareTitle);
                it.putExtra("description", shareDescription);
                startActivity(it);
            }
        });*/
    }

    private void asyncGetPDetail() {
        String wholeUrl = AppUrl.host + AppUrl.project_detail;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", GlobalParam.userToken);
        map.put("pid", pid);
        String requestBodyData = ParamBuild.buildParams(map);
        netRequest.startRequest(wholeUrl, Request.Method.POST, requestBodyData, 0, listener);
    }

    BaseRequestListener listener = new JsonRequestListener() {

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
            mProjectDetailBean = new Gson().fromJson(jsonResult.toString(), ProjectDetailBean.class);
            tv_p_title.setText(mProjectDetailBean.getName());
            if (mProjectDetailBean.getCategory_1() != null)
                tv_p_type.setText(mProjectDetailBean.getCategory_1().getName());
            if (mProjectDetailBean.getIndustry_1() != null)
                tv_p_hangye.setText(mProjectDetailBean.getIndustry_1().getName());
            tv_p_week.setText(GlobalParam.termMap.get(mProjectDetailBean.getTerm()));
            tv_p_createtime.setText(DateTool.parseTime(mProjectDetailBean.getCreate_time()));
            tv_p_state.setText(mProjectDetailBean.getStatus());
            tv_manager_state.setText(mProjectDetailBean.getManager().getTrue_name());
            tv_contact_phone.setText(mProjectDetailBean.getManager().getMobile());
            tv_detail.setText(mProjectDetailBean.getDescription());
           /* ImageManager.getInstance().displayImg(mContext, img_package, mSourceDetailBean.getMain_pic());
            tv_name.setText(mSourceDetailBean.getName());
            tv_summary.setText(mSourceDetailBean.getSummary());
            tv_price.setText("￥" + mSourceDetailBean.getPrice());
            String htmlDetailsStr = "";
            try {
                htmlDetailsStr = HtmlParserTool.replaceImgStr(mSourceDetailBean.getIntro());
            } catch (Exception e) {
                e.printStackTrace();
            }
            webview.loadDataWithBaseURL(null, htmlDetailsStr, "text/html", "utf-8", null);*/
        }
    };
}
