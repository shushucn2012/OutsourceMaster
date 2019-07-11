package com.asuper.outsourcemaster.moduel.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.asuper.outsourcemaster.R;
import com.asuper.outsourcemaster.common.set.GlobalParam;
import com.asuper.outsourcemaster.common.tool.DateTool;
import com.asuper.outsourcemaster.common.tool.ImageManager;
import com.asuper.outsourcemaster.moduel.home.ProjectDetailsActivity;
import com.asuper.outsourcemaster.moduel.home.SourceDetailsActivity;
import com.asuper.outsourcemaster.moduel.home.bean.ProjectBean;
import com.asuper.outsourcemaster.moduel.home.bean.SourceBean;

import java.util.List;

/**
 * Created by shubei on 2017/9/12.
 */
public class MyProjListAdapter extends BaseAdapter {

    private List<ProjectBean> mList;
    private Context mContext;
    private LayoutInflater factory;

    public MyProjListAdapter(Context _context, List<ProjectBean> _list) {
        this.mList = _list;
        this.mContext = _context;
        factory = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public ProjectBean getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = factory.inflate(R.layout.project_list_item, null);
            holder = new ViewHolder();
            holder.tv_p_title = (TextView) convertView.findViewById(R.id.tv_p_title);
            holder.tv_p_type = (TextView) convertView.findViewById(R.id.tv_p_type);
            holder.tv_p_hangye = (TextView) convertView.findViewById(R.id.tv_p_hangye);
            holder.tv_p_week = (TextView) convertView.findViewById(R.id.tv_p_week);
            holder.tv_p_createtime = (TextView) convertView.findViewById(R.id.tv_p_createtime);
            holder.tv_p_money = (TextView) convertView.findViewById(R.id.tv_p_money);
            holder.area_top_space = convertView.findViewById(R.id.area_top_space);
            holder.area_content = convertView.findViewById(R.id.area_content);
            holder.tv_solve = (TextView) convertView.findViewById(R.id.tv_solve);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final ProjectBean projectBean = mList.get(position);
        holder.tv_p_title.setText(projectBean.getName());
        if (projectBean.getCategory_1() != null)
            holder.tv_p_type.setText(projectBean.getCategory_1().getName());
        else
            holder.tv_p_type.setText("");
        if (projectBean.getIndustry_1() != null)
            holder.tv_p_hangye.setText(projectBean.getIndustry_1().getName());
        else
            holder.tv_p_hangye.setText("");
        holder.tv_p_week.setText(GlobalParam.termMap.get(projectBean.getTerm()));
        holder.tv_p_createtime.setText(DateTool.parseTime(projectBean.getCreate_time()));
        holder.tv_p_money.setText(projectBean.getBudget() + "万元");
        if (position == 0) {
            holder.area_top_space.setVisibility(View.VISIBLE);
        } else {
            holder.area_top_space.setVisibility(View.GONE);
        }
        if (projectBean.getPackage_id() > 0) {
            holder.tv_solve.setVisibility(View.VISIBLE);
        } else {
            holder.tv_solve.setVisibility(View.GONE);
        }
        holder.area_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(mContext, ProjectDetailsActivity.class);
                it.putExtra("pid", projectBean.getId());
                mContext.startActivity(it);
            }
        });
        return convertView;
    }

    class ViewHolder {
        TextView tv_p_title;
        TextView tv_p_type;
        TextView tv_p_hangye;
        TextView tv_p_week;
        TextView tv_p_createtime;
        TextView tv_p_money;
        TextView tv_solve;
        View area_top_space, area_content;
    }
}
