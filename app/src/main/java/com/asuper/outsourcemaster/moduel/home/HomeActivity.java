package com.asuper.outsourcemaster.moduel.home;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.asuper.outsourcemaster.BaseActivity;
import com.asuper.outsourcemaster.R;
import com.asuper.outsourcemaster.common.set.AppUrl;
import com.asuper.outsourcemaster.common.set.GlobalParam;
import com.asuper.outsourcemaster.common.set.ParamBuild;
import com.asuper.outsourcemaster.common.tool.ImageManager;
import com.asuper.outsourcemaster.common.tool.ViewInitTool;
import com.asuper.outsourcemaster.moduel.home.bean.ChosenConfigCache;
import com.asuper.outsourcemaster.moduel.home.bean.SourceBean;
import com.asuper.outsourcemaster.moduel.login.LoginActivity;
import com.asuper.outsourcemaster.moduel.login.bean.UserManager;
import com.asuper.outsourcemaster.moduel.me.JoinLoginActivity;
import com.asuper.outsourcemaster.moduel.me.PersonJoinActivity;
import com.asuper.outsourcemaster.net.base.Request;
import com.asuper.outsourcemaster.net.request.interfa.BaseRequestListener;
import com.asuper.outsourcemaster.net.request.interfa.JsonRequestListener;
import com.asuper.outsourcemaster.widget.pw.CourseChoosePlanPopWin;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created by shubei on 2017/9/10.
 */

public class HomeActivity extends BaseActivity {

    private ViewPager vp_pager;
    private TextView tv_login, tv_mobile, tv_person_join;
    private View area_mobile;
    private WindowManager.LayoutParams params;
    private Button btn_publish;

    private List<SourceBean> dataList;
    private int mTouchSlop;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_home);
    }

    @Override
    public void initView() {
        vp_pager = (ViewPager) findViewById(R.id.vp_pager);
        vp_pager.setOffscreenPageLimit(3);
        vp_pager.setPageTransformer(true, new ZoomOutPageTransformer());
        vp_pager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.page_margin));

        tv_login = (TextView) findViewById(R.id.tv_login);
        tv_mobile = (TextView) findViewById(R.id.tv_mobile);
        area_mobile = findViewById(R.id.area_mobile);
        btn_publish = (Button) findViewById(R.id.btn_publish);
        tv_person_join = (TextView) findViewById(R.id.tv_person_join);
    }

    @Override
    public void initData() {
        dataList = new ArrayList<>();
        asyncGetSourceList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (GlobalParam.userToken != null) {
            tv_mobile.setText(GlobalParam.CurUser.getMobile());
            area_mobile.setVisibility(View.VISIBLE);
            tv_login.setVisibility(View.GONE);
        } else {
            area_mobile.setVisibility(View.GONE);
            tv_login.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void initListener() {
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, LoginActivity.class));
            }
        });
        area_mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopFormBottom();
            }
        });
        btn_publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChosenConfigCache.getInstance().clear();
                startActivity(new Intent(mContext, ProjectPublishFirstActivity.class));
            }
        });
        tv_person_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GlobalParam.userToken == null) {
                    startActivity(new Intent(mContext, JoinLoginActivity.class));
                } else {
                    startActivity(new Intent(mContext, PersonJoinActivity.class));
                }
            }
        });

       /* ViewConfiguration configuration = ViewConfiguration.get(mContext);
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);

        vp_pager.setOnTouchListener(new View.OnTouchListener() {
            int touchFlag = 0;
            float x = 0, y = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        touchFlag = 0;
                        x = event.getX();
                        y = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float xDiff = Math.abs(event.getX() - x);
                        float yDiff = Math.abs(event.getY() - y);
                        if (xDiff < mTouchSlop && xDiff >= yDiff)
                            touchFlag = 0;
                        else
                            touchFlag = -1;
                        break;
                    case MotionEvent.ACTION_UP:
                        if (touchFlag == 0) {
                            int currentItem = vp_pager.getCurrentItem();
                            Intent it = new Intent();
                            it.setClass(mContext, SourceDetailsActivity.class);
                            it.putExtra("id", dataList.get(currentItem).getId());
                            startActivity(it);
                        }
                        break;
                }
                return false;
            }
        });*/
    }

    private void asyncGetSourceList() {
        String wholeUrl = AppUrl.host + AppUrl.package_lists;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("is_index_show", "1");
        map.put("per_page", 5);
        map.put("page", 1);
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
            JSONArray actJay = jsonResult.optJSONArray("packageInfo");
            for (int i = 0; i < actJay.length(); i++) {
                JSONObject actJot = actJay.optJSONObject(i);
                SourceBean c = new Gson().fromJson(actJot.toString(), SourceBean.class);
                dataList.add(c);
            }
            MyViewPagerAdapter mAdapter = new MyViewPagerAdapter();
            vp_pager.setAdapter(mAdapter);
            vp_pager.setOffscreenPageLimit(mAdapter.getCount());
            try {
                Field mField;
                mField = ViewPager.class.getDeclaredField("mScroller");
                mField.setAccessible(true);
                FixedSpeedScroller mScroller = new FixedSpeedScroller(mContext, new AccelerateInterpolator());
                mScroller.setmDuration(300);
                mField.set(vp_pager, mScroller);
            } catch (Exception e) {
                e.printStackTrace();
            }
            startAutoPlay();
        }
    };

    private int num = 400;
    private boolean isAutoPlay;//是否自动播放
    private int count = 0;
    private int WHAT_AUTO_PLAY = 1000;
    private int DELAY_MILLIS = 4000;
    private boolean isForward = true;

    private final Handler viewHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == WHAT_AUTO_PLAY) {
                if (isForward && vp_pager.getCurrentItem() == 5) {
                    isForward = false;
                } else if (!isForward && vp_pager.getCurrentItem() == 0) {
                    isForward = true;
                }
                if (isForward) {
                    vp_pager.setCurrentItem(vp_pager.getCurrentItem() + 1, true);
                } else {
                    vp_pager.setCurrentItem(vp_pager.getCurrentItem() - 1, true);
                }
                viewHandler.sendEmptyMessageDelayed(WHAT_AUTO_PLAY, DELAY_MILLIS);
            }
            super.handleMessage(msg);
        }
    };

    /**
     * 开始自动轮播
     */
    public void startAutoPlay() {
        if (!isAutoPlay) {
            viewHandler.sendEmptyMessageDelayed(WHAT_AUTO_PLAY, DELAY_MILLIS);
            isAutoPlay = true;
        }
    }

    /**
     * 停止自动轮播
     */
    public void stopAutoPlay() {
        if (isAutoPlay) {
            viewHandler.removeMessages(WHAT_AUTO_PLAY);
            isAutoPlay = false;
        }
    }

    /**
     * Viewpager数据适配器
     */
    class MyViewPagerAdapter extends PagerAdapter {

        //view复用
        private LinkedList<View> mViewCache = null;

        public MyViewPagerAdapter() {
            mViewCache = new LinkedList<>();
        }

        @Override
        public int getCount() {
            return dataList.size() + 1;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            ViewHolder holder = null;
            View convertView = null;
            if (mViewCache.size() == 0) {
                convertView = View.inflate(mContext, R.layout.item_viewpager, null);
                holder = new ViewHolder();
                holder.tv_project_title = (TextView) convertView.findViewById(R.id.tv_project_title);
                holder.tv_price = (TextView) convertView.findViewById(R.id.tv_price);
                holder.img_project_pic = (ImageView) convertView.findViewById(R.id.img_project_pic);
                holder.area_more = convertView.findViewById(R.id.area_more);
                convertView.setTag(holder);
            } else {
                convertView = mViewCache.removeFirst();
                holder = (ViewHolder) convertView.getTag();
            }

            if (position == dataList.size()) {
                holder.area_more.setVisibility(View.VISIBLE);
                holder.area_more.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(mContext, SourceListActivity.class));
                    }
                });
            } else {
                holder.area_more.setVisibility(View.GONE);
                holder.tv_project_title.setText(dataList.get(position).getName());
                holder.tv_price.setText(dataList.get(position).getPrice());
                ImageManager.getInstance().displayImg(mContext, holder.img_project_pic, dataList.get(position).getMain_pic());
               /* holder.img_project_pic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent it = new Intent(mContext, SourceDetailsActivity.class);
                        it.putExtra("id", dataList.get(position).getId());
                        mContext.startActivity(it);
                    }
                });*/
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent it = new Intent(mContext, SourceDetailsActivity.class);
                        it.putExtra("id", dataList.get(position).getId());
                        mContext.startActivity(it);
                    }
                });
            }
            container.addView(convertView);
            return convertView;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            mViewCache.add((View) object);
        }

        //View复用
        public final class ViewHolder {
            public TextView tv_project_title;
            public TextView tv_price;
            public ImageView img_project_pic;
            public View area_more;
        }
    }

    public void showPopFormBottom() {
        final CourseChoosePlanPopWin takePhotoPopWin = new CourseChoosePlanPopWin(mContext);
        // 设置Popupwindow显示位置（从底部弹出）
        takePhotoPopWin.showAtLocation(findViewById(R.id.main_view), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        params = getWindow().getAttributes();
        //当弹出Popupwindow时，背景变半透明
        params.alpha = 0.7f;
        getWindow().setAttributes(params);
        //设置Popupwindow关闭监听，当Popupwindow关闭，背景恢复1f
        takePhotoPopWin.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                params = getWindow().getAttributes();
                params.alpha = 1f;
                getWindow().setAttributes(params);
            }
        });
        takePhotoPopWin.getTv_outlogin().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoginOutDialog();
                takePhotoPopWin.dismiss();
            }
        });
        takePhotoPopWin.getTv_to_myproject().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, MyProjectListActivity.class));
                takePhotoPopWin.dismiss();
            }
        });
    }

    public void showLoginOutDialog() {
        dDialog.showDialog("提示", "确定要退出登录吗？", "取消", "确定", new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dDialog.dismissDialog();

            }
        }, new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dDialog.dismissDialog();
                UserManager.getInstance().deleteAccountInfo(mContext);
                GlobalParam.CurUser = null;
                GlobalParam.userToken = null;
                area_mobile.setVisibility(View.GONE);
                tv_login.setVisibility(View.VISIBLE);
            }
        });
    }
}
