package com.asuper.outsourcemaster.moduel.home;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.asuper.outsourcemaster.BaseActivity;
import com.asuper.outsourcemaster.R;
import com.asuper.outsourcemaster.common.set.AppUrl;
import com.asuper.outsourcemaster.moduel.home.bean.ChosenConfigCache;
import com.asuper.outsourcemaster.moduel.home.bean.ConfigBean;
import com.asuper.outsourcemaster.net.base.Request;
import com.asuper.outsourcemaster.net.request.interfa.BaseRequestListener;
import com.asuper.outsourcemaster.net.request.interfa.JsonRequestListener;
import com.asuper.outsourcemaster.widget.dialog.ComSelectDialog;
import com.google.gson.Gson;

import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by shubei on 2017/9/13.
 */

public class ProjectPublishFirstActivity extends BaseActivity implements View.OnClickListener {

    private View area_p_type, area_p_hangye, area_p_week, area_p_urgency;
    private ComSelectDialog mComSelectDialog;
    private TextView tv_p_type, tv_p_hangye, tv_p_week, tv_p_urgency;
    private Button btn_next;
    private EditText edit_p_money;
    private View area_content, area_network;

    private ConfigBean configBean;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_p_publish_first);
    }

    @Override
    public void initView() {
        area_p_type = findViewById(R.id.area_p_type);
        area_p_hangye = findViewById(R.id.area_p_hangye);
        area_p_week = findViewById(R.id.area_p_week);
        area_p_urgency = findViewById(R.id.area_p_urgency);

        tv_p_type = (TextView) findViewById(R.id.tv_p_type);
        tv_p_hangye = (TextView) findViewById(R.id.tv_p_hangye);
        tv_p_week = (TextView) findViewById(R.id.tv_p_week);
        tv_p_urgency = (TextView) findViewById(R.id.tv_p_urgency);

        edit_p_money = (EditText) findViewById(R.id.edit_p_money);
        btn_next = (Button) findViewById(R.id.btn_next);

        area_content = findViewById(R.id.area_content);
        area_network = findViewById(R.id.area_network);
    }

    @Override
    public void initData() {
        asyncGetConfig();
    }

    @Override
    public void initListener() {
        if (TextUtils.isEmpty(ChosenConfigCache.getInstance().package_id)) {
            area_p_type.setOnClickListener(this);
            area_p_hangye.setOnClickListener(this);
        }
        area_p_week.setOnClickListener(this);
        area_p_urgency.setOnClickListener(this);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ChosenConfigCache.getInstance().category_1 == 0) {
                    showShortToast("项目类型未选择！");
                    return;
                }
                if (ChosenConfigCache.getInstance().industry_1 == 0) {
                    showShortToast("所属行业未选择！");
                    return;
                }
                if (ChosenConfigCache.getInstance().term == 0) {
                    showShortToast("期望外包周期未选择！");
                    return;
                }
                if (ChosenConfigCache.getInstance().urgency == 0) {
                    showShortToast("紧急程度未选择！");
                    return;
                }
                if (TextUtils.isEmpty(edit_p_money.getText().toString().trim())) {
                    showShortToast("项目预算未填写！");
                    return;
                }
                ChosenConfigCache.getInstance().budget = edit_p_money.getText().toString().trim();
                startActivity(new Intent(mContext, ProjectPublishSecondActivity.class));
            }
        });
    }

    private void asyncGetConfig() {
        String wholeUrl = AppUrl.host + AppUrl.config;
        netRequest.startRequest(wholeUrl, Request.Method.POST, "", 0, listener);
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
            configBean = new Gson().fromJson(jsonResult.toString(), ConfigBean.class);

            if (!TextUtils.isEmpty(ChosenConfigCache.getInstance().package_id)) {
                for (int i = 0; i < configBean.getCategory().size(); i++) {
                    if (configBean.getCategory().get(i).getId() == ChosenConfigCache.getInstance().category_1) {
                        tv_p_type.setText(configBean.getCategory().get(i).getName());
                        findViewById(R.id.img_down_arrow_type).setVisibility(View.GONE);
                    }
                }
                for (int i = 0; i < configBean.getIndustry().size(); i++) {
                    if (configBean.getIndustry().get(i).getId() == ChosenConfigCache.getInstance().industry_1) {
                        tv_p_hangye.setText(configBean.getIndustry().get(i).getName());
                        findViewById(R.id.img_down_arrow_hangye).setVisibility(View.GONE);
                    }
                }
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.area_p_type:
                final List<String> slist = new ArrayList<String>();
                final List<Integer> idlist = new ArrayList<Integer>();
                for (int i = 0; i < configBean.getCategory().size(); i++) {
                    if (configBean.getCategory().get(i).getPid() == 0) {
                        slist.add(configBean.getCategory().get(i).getName());
                        idlist.add(configBean.getCategory().get(i).getId());
                    }
                }
                mComSelectDialog = new ComSelectDialog(mContext, slist);
                mComSelectDialog.setOnItemSelectLsner(new ComSelectDialog.OnItemSelectLsner() {
                    @Override
                    public void onSelect(int position) {
                        //showChooseTypeFinalDialog(idlist.get(position), slist.get(position));
                        tv_p_type.setText(slist.get(position));
                        tv_p_type.setTextColor(mContext.getResources().getColor(R.color.g333333));
                        ChosenConfigCache.getInstance().category_1 = idlist.get(position);
                    }
                });
                mComSelectDialog.showDialog();
                break;
            case R.id.area_p_hangye:
                final List<String> slistHangye = new ArrayList<String>();
                final List<Integer> idlistHangye = new ArrayList<Integer>();
                for (int i = 0; i < configBean.getIndustry().size(); i++) {
                    if (configBean.getIndustry().get(i).getPid() == 0) {
                        slistHangye.add(configBean.getIndustry().get(i).getName());
                        idlistHangye.add(configBean.getIndustry().get(i).getId());
                    }
                }
                mComSelectDialog = new ComSelectDialog(mContext, slistHangye);
                mComSelectDialog.setOnItemSelectLsner(new ComSelectDialog.OnItemSelectLsner() {
                    @Override
                    public void onSelect(int position) {
                        //showChooseIndustryFinalDialog(idlistHangye.get(position), slistHangye.get(position));
                        tv_p_hangye.setText(slistHangye.get(position));
                        tv_p_hangye.setTextColor(mContext.getResources().getColor(R.color.g333333));
                        ChosenConfigCache.getInstance().industry_1 = idlistHangye.get(position);
                    }
                });
                mComSelectDialog.showDialog();
                break;
            case R.id.area_p_week:
                final List<String> slistWeek = new ArrayList<String>();
                final List<Integer> idlistWeek = new ArrayList<Integer>();
                slistWeek.add("超过6个月");
                slistWeek.add("3-6个月");
                slistWeek.add("1-3个月");
                slistWeek.add("少于1个月");
                slistWeek.add("少于1周");
                idlistWeek.add(1);
                idlistWeek.add(2);
                idlistWeek.add(3);
                idlistWeek.add(4);
                idlistWeek.add(5);
                mComSelectDialog = new ComSelectDialog(mContext, slistWeek);
                mComSelectDialog.setOnItemSelectLsner(new ComSelectDialog.OnItemSelectLsner() {
                    @Override
                    public void onSelect(int position) {
                        tv_p_week.setText(slistWeek.get(position));
                        tv_p_week.setTextColor(mContext.getResources().getColor(R.color.g333333));
                        ChosenConfigCache.getInstance().term = idlistWeek.get(position);
                    }
                });
                mComSelectDialog.showDialog();
                break;
            case R.id.area_p_urgency:
                final List<String> slistUrgency = new ArrayList<String>();
                final List<Integer> idlistUrgency = new ArrayList<Integer>();
                slistUrgency.add("不紧急");
                slistUrgency.add("一般");
                slistUrgency.add("非常紧急");
                idlistUrgency.add(1);
                idlistUrgency.add(2);
                idlistUrgency.add(3);
                mComSelectDialog = new ComSelectDialog(mContext, slistUrgency);
                mComSelectDialog.setOnItemSelectLsner(new ComSelectDialog.OnItemSelectLsner() {
                    @Override
                    public void onSelect(int position) {
                        tv_p_urgency.setText(slistUrgency.get(position));
                        tv_p_urgency.setTextColor(mContext.getResources().getColor(R.color.g333333));
                        ChosenConfigCache.getInstance().urgency = idlistUrgency.get(position);
                    }
                });
                mComSelectDialog.showDialog();
                break;
        }
    }

    /*private void showChooseTypeFinalDialog(final int pid, final String pname) {
        final List<String> slist2 = new ArrayList<String>();
        final List<Integer> idlist2 = new ArrayList<Integer>();
        for (int i = 0; i < configBean.getCategory().size(); i++) {
            if (configBean.getCategory().get(i).getPid() == pid) {
                slist2.add(configBean.getCategory().get(i).getName());
                idlist2.add(configBean.getCategory().get(i).getId());
            }
        }
        mComSelectDialog = new ComSelectDialog(mContext, slist2);
        mComSelectDialog.setOnItemSelectLsner(new ComSelectDialog.OnItemSelectLsner() {
            @Override
            public void onSelect(int position) {
                tv_p_type.setText(pname + " " + slist2.get(position));
                ChosenConfigCache.getInstance().category_1 = idlist2.get(position);
            }
        });
        mComSelectDialog.showDialog();
    }*/

    /*private void showChooseIndustryFinalDialog(final int pid, final String pname) {
        final List<String> slist2 = new ArrayList<String>();
        final List<Integer> idlist2 = new ArrayList<Integer>();
        for (int i = 0; i < configBean.getIndustry().size(); i++) {
            if (configBean.getIndustry().get(i).getPid() == pid) {
                slist2.add(configBean.getIndustry().get(i).getName());
                idlist2.add(configBean.getIndustry().get(i).getId());
            }
        }
        mComSelectDialog = new ComSelectDialog(mContext, slist2);
        mComSelectDialog.setOnItemSelectLsner(new ComSelectDialog.OnItemSelectLsner() {
            @Override
            public void onSelect(int position) {
                tv_p_hangye.setText(pname + " " + slist2.get(position));
                ChosenConfigCache.getInstance().industry_1 = idlist2.get(position);
            }
        });
        mComSelectDialog.showDialog();
    }*/
}
