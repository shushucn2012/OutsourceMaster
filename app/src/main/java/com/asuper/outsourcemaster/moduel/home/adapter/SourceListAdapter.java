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
import com.asuper.outsourcemaster.common.tool.ImageManager;
import com.asuper.outsourcemaster.moduel.home.SourceDetailsActivity;
import com.asuper.outsourcemaster.moduel.home.bean.SourceBean;

import java.util.List;

/**
 * Created by shubei on 2017/9/12.
 */
public class SourceListAdapter extends BaseAdapter {

    private List<SourceBean> mList;
    private Context mContext;
    private LayoutInflater factory;

    public SourceListAdapter(Context _context, List<SourceBean> _list) {
        this.mList = _list;
        this.mContext = _context;
        factory = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public SourceBean getItem(int position) {
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
            convertView = factory.inflate(R.layout.source_list_item, null);
            holder = new ViewHolder();
            holder.area_content = convertView.findViewById(R.id.area_content);
            holder.img_project_pic = (ImageView) convertView.findViewById(R.id.img_project_pic);
            holder.tv_project_title = (TextView) convertView.findViewById(R.id.tv_project_title);
            holder.tv_price = (TextView) convertView.findViewById(R.id.tv_price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final SourceBean sourceBean = mList.get(position);
        ImageManager.getInstance().displayImg(mContext, holder.img_project_pic, sourceBean.getMain_pic());
        holder.tv_project_title.setText(sourceBean.getName());
        holder.tv_price.setText(sourceBean.getPrice());
        holder.area_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(mContext, SourceDetailsActivity.class);
                it.putExtra("id", sourceBean.getId());
                mContext.startActivity(it);
            }
        });
        return convertView;
    }

    class ViewHolder {
        ImageView img_project_pic;
        TextView tv_project_title;
        TextView tv_price;
        View area_content;
    }
}
