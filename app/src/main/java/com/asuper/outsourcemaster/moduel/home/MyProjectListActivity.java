package com.asuper.outsourcemaster.moduel.home;

import android.view.View;
import android.widget.ListView;

import com.asuper.outsourcemaster.BaseActivity;
import com.asuper.outsourcemaster.R;
import com.asuper.outsourcemaster.common.set.AppUrl;
import com.asuper.outsourcemaster.common.set.GlobalParam;
import com.asuper.outsourcemaster.common.set.ParamBuild;
import com.asuper.outsourcemaster.common.tool.ViewInitTool;
import com.asuper.outsourcemaster.moduel.home.adapter.MyProjListAdapter;
import com.asuper.outsourcemaster.moduel.home.adapter.SourceListAdapter;
import com.asuper.outsourcemaster.moduel.home.bean.ProjectBean;
import com.asuper.outsourcemaster.moduel.home.bean.SourceBean;
import com.asuper.outsourcemaster.net.base.Request;
import com.asuper.outsourcemaster.net.request.interfa.BaseRequestListener;
import com.asuper.outsourcemaster.net.request.interfa.JsonRequestListener;
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
 * Created by shubei on 2017/9/13.
 */
public class MyProjectListActivity extends BaseActivity {

    private int PAGE_NUM = 1;
    private final int PAGE_SIZE = 10;

    private PullToRefreshListView mPullRefreshListView;

    private MyProjListAdapter mAdapter;
    private List<ProjectBean> dataList;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_myproject_list);
    }

    @Override
    public void initView() {
        mPullRefreshListView = (PullToRefreshListView) findViewById(R.id.pull_refresh_list);
        ViewInitTool.initPullToRefresh(mPullRefreshListView, mContext);
        dataList = new ArrayList<ProjectBean>();
        mAdapter = new MyProjListAdapter(mContext, dataList);
        mPullRefreshListView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        asyncGetProjectList();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        area_right.setVisibility(View.GONE);
        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                PAGE_NUM = 1;
                asyncGetProjectList();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                PAGE_NUM++;
                asyncGetProjectList();
            }
        });
    }

    private void asyncGetProjectList() {
        String wholeUrl = AppUrl.host + AppUrl.project_lists;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("is_index_show", "1");
        map.put("per_page", PAGE_SIZE);
        map.put("page", PAGE_NUM);
        map.put("token", GlobalParam.userToken);
        String requestBodyData = ParamBuild.buildParams(map);
        netRequest.startRequest(wholeUrl, Request.Method.POST, requestBodyData, 0, listener);
    }

    BaseRequestListener listener = new JsonRequestListener() {

        @Override
        public void onStart(int requestId) {
            if (PAGE_NUM == 1) {
                showDialog();
            }
        }

        @Override
        public void onError(int requestId, String errorCode, String errorMsg) {
            dismissDialog();
            ViewInitTool.listStopLoadView(mPullRefreshListView);
            showShortToast(errorMsg);
            if (PAGE_NUM > 1) {
                PAGE_NUM--;
            }
        }

        @Override
        public void onSuccess(int requestId, String url, JSONObject jsonResult) {
            dismissDialog();
            ViewInitTool.listStopLoadView(mPullRefreshListView);
            ArrayList<ProjectBean> currentPageList = new ArrayList<ProjectBean>();
            JSONArray actJay = jsonResult.optJSONArray("list");
            // 第一次查询的时候没有数据，则提示没有数据，页面置空
            if (PAGE_NUM == 1 && (actJay == null || actJay.length() <= 0)) {
                dataList.clear();
                mAdapter.notifyDataSetChanged();
                //ViewInitTool.setListEmptyTipByDefaultPic(mContext, mPullRefreshListView.getRefreshableView(), "");
                //mPullRefreshListView.getRefreshableView().setEmptyView(findViewById(R.id.img_empty_tip));
                findViewById(R.id.img_empty_tip).setVisibility(View.VISIBLE);
                ViewInitTool.setPullToRefreshViewEnd(mPullRefreshListView);
                return;
            }
            // 首次加载清空所有项列表,并重置控件为可下滑
            if (PAGE_NUM == 1) {
                dataList.clear();
                ViewInitTool.setPullToRefreshViewBoth(mPullRefreshListView);
            }
            // 如果当前页已经是最后一页，则列表控件置为不可下滑
           /* if (PAGE_NUM >= jsonResult.optInt("totalPage")) {
                ViewInitTool.setPullToRefreshViewEnd(mPullRefreshListView);
            }*/
            if (PAGE_NUM >= 1 && actJay.length() < PAGE_SIZE) {
                ViewInitTool.setPullToRefreshViewEnd(mPullRefreshListView);
            }
            for (int i = 0; i < actJay.length(); i++) {
                JSONObject actJot = actJay.optJSONObject(i);
                ProjectBean c = new Gson().fromJson(actJot.toString(), ProjectBean.class);
                currentPageList.add(c);
            }
            dataList.addAll(currentPageList);
            mAdapter.notifyDataSetChanged();
        }
    };
}
