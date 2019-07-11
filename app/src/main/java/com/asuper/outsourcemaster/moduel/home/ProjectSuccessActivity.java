package com.asuper.outsourcemaster.moduel.home;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.asuper.outsourcemaster.BaseActivity;
import com.asuper.outsourcemaster.R;

/**
 * Created by shubei on 2017/9/14.
 */

public class ProjectSuccessActivity extends BaseActivity {

    private Button btn_look;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_p_success);
    }

    @Override
    public void initView() {
        btn_look = (Button) findViewById(R.id.btn_look);
    }

    @Override
    public void initData() {
    }

    @Override
    public void initListener() {
        btn_look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, MyProjectListActivity.class));
                finish();
            }
        });
    }
}
