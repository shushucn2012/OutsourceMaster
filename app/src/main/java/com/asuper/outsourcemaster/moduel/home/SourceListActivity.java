package com.asuper.outsourcemaster.moduel.home;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;

import com.asuper.outsourcemaster.BaseActivity;
import com.asuper.outsourcemaster.R;
import com.asuper.outsourcemaster.common.set.AppUrl;
import com.asuper.outsourcemaster.common.set.ParamBuild;
import com.asuper.outsourcemaster.common.tool.ViewInitTool;
import com.asuper.outsourcemaster.moduel.home.adapter.SourceListAdapter;
import com.asuper.outsourcemaster.moduel.home.bean.SourceBean;
import com.asuper.outsourcemaster.net.base.Request;
import com.asuper.outsourcemaster.net.request.interfa.BaseRequestListener;
import com.asuper.outsourcemaster.net.request.interfa.JsonRequestListener;
import com.asuper.outsourcemaster.widget.SharePopWin;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shubei on 2017/9/12.
 */

public class SourceListActivity extends BaseActivity {

    private int PAGE_NUM = 1;
    private final int PAGE_SIZE = 10;

    private PullToRefreshListView mPullRefreshListView;
    private View area_network;

    private SourceListAdapter mAdapter;
    private List<SourceBean> dataList;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_source_list);
    }

    @Override
    public void initView() {
        area_network = findViewById(R.id.area_network);
        mPullRefreshListView = (PullToRefreshListView) findViewById(R.id.pull_refresh_list);
        ViewInitTool.initPullToRefresh(mPullRefreshListView, mContext);
        dataList = new ArrayList<SourceBean>();
        mAdapter = new SourceListAdapter(mContext, dataList);
        mPullRefreshListView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        asyncGetSourceList();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        area_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //http://www.waibaodashi.com
                shareUrl = AppUrl.demoHost_share + "/service/list";
                sharePic = AppUrl.SHARE_APP_ICON;
                shareTitle = "互联网外包从完整解决方案开始";
                shareDescription = "外包大师，产品外包第一站，提供成熟产品解决方案";
                Intent it = new Intent(mContext, SharePopWin.class);
                it.putExtra("shareUrl", shareUrl);
                it.putExtra("picUrl", sharePic);
                it.putExtra("title", shareTitle);
                it.putExtra("description", shareDescription);
                startActivity(it);
            }
        });
        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                PAGE_NUM = 1;
                asyncGetSourceList();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                PAGE_NUM++;
                asyncGetSourceList();
            }
        });
    }

    private void asyncGetSourceList() {
        String wholeUrl = AppUrl.host + AppUrl.package_lists;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("kind", "0");
        map.put("per_page", PAGE_SIZE);
        map.put("page", PAGE_NUM);
        String requestBodyData = ParamBuild.buildParams(map);
        netRequest.startRequest(wholeUrl, Request.Method.POST, requestBodyData, 0, listener);
    }

    BaseRequestListener listener = new JsonRequestListener() {

        @Override
        public void onStart(int requestId) {
            if (PAGE_NUM == 1) {
                showDialog();
            }
            area_network.setVisibility(View.GONE);
            mPullRefreshListView.setVisibility(View.VISIBLE);
        }

        @Override
        public void onError(int requestId, String errorCode, String errorMsg) {
            dismissDialog();
            ViewInitTool.listStopLoadView(mPullRefreshListView);
            showShortToast(errorMsg);
            if (PAGE_NUM > 1) {
                PAGE_NUM--;
            }
            area_network.setVisibility(View.VISIBLE);
            mPullRefreshListView.setVisibility(View.GONE);
        }

        @Override
        public void onSuccess(int requestId, String url, JSONObject jsonResult) {
            dismissDialog();
            ViewInitTool.listStopLoadView(mPullRefreshListView);
            ArrayList<SourceBean> currentPageList = new ArrayList<SourceBean>();
            JSONArray actJay = jsonResult.optJSONArray("packageInfo");
            // 第一次查询的时候没有数据，则提示没有数据，页面置空
            if (PAGE_NUM == 1 && (actJay == null || actJay.length() <= 0)) {
                dataList.clear();
                mAdapter.notifyDataSetChanged();
                ViewInitTool.setListEmptyTipByDefaultPic(mContext, mPullRefreshListView.getRefreshableView(), "");
                ViewInitTool.setPullToRefreshViewEnd(mPullRefreshListView);
                return;
            }
            // 首次加载清空所有项列表,并重置控件为可下滑
            if (PAGE_NUM == 1) {
                dataList.clear();
                ViewInitTool.setPullToRefreshViewBoth(mPullRefreshListView);
            }
            // 如果当前页已经是最后一页，则列表控件置为不可下滑
            /*if (PAGE_NUM >= jsonResult.optInt("totalPage")) {
                ViewInitTool.setPullToRefreshViewEnd(mPullRefreshListView);
            }*/
            if (PAGE_NUM >= 1 && actJay.length() < PAGE_SIZE) {
                ViewInitTool.setPullToRefreshViewEnd(mPullRefreshListView);
            }
            for (int i = 0; i < actJay.length(); i++) {
                JSONObject actJot = actJay.optJSONObject(i);
                SourceBean c = new Gson().fromJson(actJot.toString(), SourceBean.class);
                currentPageList.add(c);
            }
            dataList.addAll(currentPageList);
            mAdapter.notifyDataSetChanged();
        }
    };
}
