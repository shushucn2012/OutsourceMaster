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
import com.asuper.outsourcemaster.common.set.ParamBuild;
import com.asuper.outsourcemaster.common.tool.HtmlParserTool;
import com.asuper.outsourcemaster.common.tool.ImageManager;
import com.asuper.outsourcemaster.moduel.home.bean.ChosenConfigCache;
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

public class SourceDetailsActivity extends BaseActivity {

    private String id;
    private SourceDetailBean mSourceDetailBean;

    private ImageView img_package;
    private TextView tv_name, tv_summary, tv_price;
    private WebView webview;
    private Button btn_put_order;
    private View area_content, area_network;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_source_details);
    }

    @Override
    public void initView() {
        img_package = (ImageView) findViewById(R.id.img_package);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_summary = (TextView) findViewById(R.id.tv_summary);
        tv_price = (TextView) findViewById(R.id.tv_price);
        webview = (WebView) findViewById(R.id.webview);
        btn_put_order = (Button) findViewById(R.id.btn_put_order);
        area_content = findViewById(R.id.area_content);
        area_network = findViewById(R.id.area_network);
    }

    @Override
    public void initData() {
        id = getIntent().getStringExtra("id");
        asyncGetPackageDetail();
    }

    @Override
    public void initListener() {
        btn_put_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChosenConfigCache.getInstance().clear();
                ChosenConfigCache.getInstance().package_id = mSourceDetailBean.getId();
                ChosenConfigCache.getInstance().category_1 = mSourceDetailBean.getType();
                ChosenConfigCache.getInstance().industry_1 = mSourceDetailBean.getIndustry();
                Intent it = new Intent(mContext, ProjectPublishFirstActivity.class);
                startActivity(it);
            }
        });
        area_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //http://www.waibaodashi.com
                shareUrl = AppUrl.demoHost_share + "/service/detail/"+id;
                sharePic = AppUrl.SHARE_APP_ICON;
                shareTitle = mSourceDetailBean.getName();
                shareDescription = "外包大师，产品外包第一站，提供成熟产品解决方案";
                Intent it = new Intent(mContext, SharePopWin.class);
                it.putExtra("shareUrl", shareUrl);
                it.putExtra("picUrl", sharePic);
                it.putExtra("title", shareTitle);
                it.putExtra("description", shareDescription);
                startActivity(it);
            }
        });
    }

    private void asyncGetPackageDetail() {
        String wholeUrl = AppUrl.host + AppUrl.package_detail;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        String requestBodyData = ParamBuild.buildParams(map);
        netRequest.startRequest(wholeUrl, Request.Method.POST, requestBodyData, 0, listener);
    }

    BaseRequestListener listener = new JsonRequestListener() {

        @Override
        public void onStart(int requestId) {
            showDialog();
            area_content.setVisibility(View.VISIBLE);
            area_network.setVisibility(View.GONE);
        }

        @Override
        public void onError(int requestId, String errorCode, String errorMsg) {
            dismissDialog();
            showShortToast(errorMsg);
            area_content.setVisibility(View.GONE);
            area_network.setVisibility(View.VISIBLE);
        }

        @Override
        public void onSuccess(int requestId, String url, JSONObject jsonResult) {
            dismissDialog();
            mSourceDetailBean = new Gson().fromJson(jsonResult.toString(), SourceDetailBean.class);
            ImageManager.getInstance().displayImg(mContext, img_package, mSourceDetailBean.getMain_pic());
            tv_name.setText(mSourceDetailBean.getName());
            tv_summary.setText(mSourceDetailBean.getSummary());
            tv_price.setText("￥" + mSourceDetailBean.getPrice());
            String htmlDetailsStr = "";
            try {
                htmlDetailsStr = HtmlParserTool.replaceImgStr(mSourceDetailBean.getIntro());
            } catch (Exception e) {
                e.printStackTrace();
            }
            webview.loadDataWithBaseURL(null, htmlDetailsStr, "text/html", "utf-8", null);
        }
    };
}
