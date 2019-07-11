package com.asuper.outsourcemaster.moduel.me;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.asuper.outsourcemaster.BaseActivity;
import com.asuper.outsourcemaster.R;

/**
 * Created by shubei on 2017/9/14.
 */

public class PersonJoinActivity extends BaseActivity {

    private Button btn_copy;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_person_join);
    }

    @Override
    public void initView() {
        btn_copy = (Button) findViewById(R.id.btn_copy);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String copyUrl = "http://www.waibaodashi.com/login?role=yi";
                ClipboardManager cbm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData myClip = ClipData.newPlainText("text", copyUrl);
                cbm.setPrimaryClip(myClip);
                Toast.makeText(mContext, "已复制", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
