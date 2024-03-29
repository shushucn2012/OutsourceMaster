package com.asuper.outsourcemaster;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;

import com.asuper.outsourcemaster.common.set.AppUrl;
import com.asuper.outsourcemaster.common.set.GlobalParam;
import com.asuper.outsourcemaster.common.set.Log;
import com.asuper.outsourcemaster.moduel.home.HomeActivity;
import com.asuper.outsourcemaster.moduel.home.bean.MyTerm;
import com.asuper.outsourcemaster.moduel.home.bean.MyUrgency;
import com.asuper.outsourcemaster.moduel.login.bean.UserManager;


public class LoadingActivity extends Activity {

    private static final int REQUEST_CODE = 1001; // 请求码
    // 所需的全部权限
    private static final String[] PERMISSIONS = new String[]{
            //Manifest.permission.READ_PHONE_STATE,
            //Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private boolean userPermission = false;
    private boolean isFirstFlag = false;// 是否是首次启动
    //private LocationService locationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        // 判断是否是第一次进入APP
        SharedPreferences isFirstRunSp = getSharedPreferences("IsFirstFlag", Activity.MODE_PRIVATE);
        isFirstFlag = isFirstRunSp.getBoolean("IsFirstRun", true);

        //readBadWords();
        initConfig();
    }

    private void initConfig() {
        GlobalParam.termMap.put(1, "超过6个月");
        GlobalParam.termMap.put(2, "3-6个月");
        GlobalParam.termMap.put(3, "1-3个月");
        GlobalParam.termMap.put(4, "少于1个月");
        GlobalParam.termMap.put(5, "少于1周");

        GlobalParam.urgencyMap.put(1, "不紧急");
        GlobalParam.urgencyMap.put(2, "一般");
        GlobalParam.urgencyMap.put(3, "非常紧急");
    }

    /*private void readBadWords() {
        StringBuffer stringBuffer = new StringBuffer();
        AssetManager assetManager = getAssets();
        try {
            InputStream is = assetManager.open("sensitivewords.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = null;
            while ((str = br.readLine()) != null) {
                stringBuffer.append(str + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] ss = stringBuffer.toString().split("\n");
        for (int i = 0; i < ss.length; i++) {
            GlobalParam.badWordList.add(ss[i]);
        }
    }*/

    @Override
    public void onStart() {
        super.onStart();
        userPermission = RequestPermissionUtil.getRequestPermissionUtilInstance().checkPermissions(
                this, REQUEST_CODE, PERMISSIONS);
        if (userPermission) {
            afterLocationPermission();
        }
    }

    private void afterLocationPermission() {
       /* locationService = ((ITApplication) getApplication()).locationService;
        // 获取实例，建议应用中只初始化1个location实例
        locationService.registerListener(mListener);
        // 注册监听
        int type = getIntent().getIntExtra("from", 0);
        if (type == 0) {
            locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        } else if (type == 1) {
            locationService.setLocationOption(locationService.getOption());
        }
        locationService.start();
        startHomePage();*/


        startHomePage();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*if (locationService != null) {
            locationService.unregisterListener(mListener); // 注销掉监听
            locationService.stop(); // 停止定位服务
        }*/
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE: {
                if (grantResults.length > 1
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    afterLocationPermission();
                } else {
                    Toast.makeText(this, "手机定位或存储权限被拒绝,不能正常使用,请进行授权!", Toast.LENGTH_LONG).show();
                    LoadingActivity.this.finish();
                }
                return;
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * 定位结果回调，重写onReceiveLocation方法，可以直接拷贝如下代码到自己工程中修改
     */
    /*private BDLocationListener mListener = new BDLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation location) {
            Log.out("==============================111111111111111111111===============================");
            if (null != location && location.getLocType() != BDLocation.TypeServerError) {
                StringBuffer sb = new StringBuffer(256);
                sb.append("time : ");
                */

    /**
     * 时间也可以使用systemClock.elapsedRealtime()方法 获取的是自从开机以来，每次回调的时间；
     * location.getTime() 是指服务端出本次结果的时间，如果位置不发生变化，则时间不变
     *//*
                sb.append(location.getTime());
                sb.append("\nerror code : ");
                sb.append(location.getLocType());
                sb.append("\nlatitude : ");
                sb.append(location.getLatitude());
                GlobalParam.latitude = location.getLatitude();
                sb.append("\nlontitude : ");
                sb.append(location.getLongitude());
                GlobalParam.longitude = location.getLongitude();
                sb.append("\nradius : ");
                sb.append(location.getRadius());
                sb.append("\nCountryCode : ");
                sb.append(location.getCountryCode());
                sb.append("\nCountry : ");
                sb.append(location.getCountry());
                sb.append("\ncitycode : ");
                sb.append(location.getCityCode());
                sb.append("\ncity : ");
                sb.append(location.getCity());
                GlobalParam.locationCityStr = location.getCity();
                sb.append("\nDistrict : ");
                sb.append(location.getDistrict());
                GlobalParam.locationCountryStr = location.getDistrict();
                sb.append("\nStreet : ");
                sb.append(location.getStreet());
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                sb.append("\nDescribe: ");
                sb.append(location.getLocationDescribe());
                sb.append("\nDirection(not all devices have value): ");
                sb.append(location.getDirection());
                sb.append("\nPoi: ");
                if (location.getPoiList() != null && !location.getPoiList().isEmpty()) {
                    for (int i = 0; i < location.getPoiList().size(); i++) {
                        Poi poi = (Poi) location.getPoiList().get(i);
                        sb.append(poi.getName() + ";");
                    }
                }
                if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                    sb.append("\nspeed : ");
                    sb.append(location.getSpeed());// 单位：km/h
                    sb.append("\nsatellite : ");
                    sb.append(location.getSatelliteNumber());
                    sb.append("\nheight : ");
                    sb.append(location.getAltitude());// 单位：米
                    sb.append("\ndescribe : ");
                    sb.append("gps定位成功");
                } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                    // 运营商信息
                    sb.append("\noperationers : ");
                    sb.append(location.getOperators());
                    sb.append("\ndescribe : ");
                    sb.append("网络定位成功");
                } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                    sb.append("\ndescribe : ");
                    sb.append("离线定位成功，离线定位结果也是有效的");
                } else if (location.getLocType() == BDLocation.TypeServerError) {
                    sb.append("\ndescribe : ");
                    sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
                } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                    sb.append("\ndescribe : ");
                    sb.append("网络不同导致定位失败，请检查网络是否通畅");
                } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                    sb.append("\ndescribe : ");
                    sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
                }
                Log.out(sb.toString());
            }
        }
    };*/
    public void startHomePage() {
        GlobalParam.CurUser = UserManager.getInstance().getAccountInfo(LoadingActivity.this);
        if (GlobalParam.CurUser != null) {
            GlobalParam.userToken = GlobalParam.CurUser.getToken();
        }
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (isFirstFlag) {// 判断是否是首次运行，首次运行进入引导页
                    startActivity(new Intent(LoadingActivity.this, HomeActivity.class));
                } else {
                    startActivity(new Intent(LoadingActivity.this, HomeActivity.class));
                }
                finish();
            }
        }, 3000);
    }

}
