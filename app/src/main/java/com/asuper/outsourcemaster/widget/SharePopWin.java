package com.asuper.outsourcemaster.widget;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.asuper.outsourcemaster.BaseActivity;
import com.asuper.outsourcemaster.R;
import com.asuper.outsourcemaster.common.set.GlobalParam;
import com.asuper.outsourcemaster.common.set.SinaConstants;
import com.asuper.outsourcemaster.common.tool.ImageManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.BaseResponse;
import com.sina.weibo.sdk.api.share.IWeiboHandler;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import java.util.UUID;

public class SharePopWin extends BaseActivity implements OnClickListener, IWeiboHandler.Response {

    public IWXAPI wxApi;
    private IWeiboShareAPI mWeiboShareAPI;

    private View view_wx_friend, view_wx_friends, view_sina, area_above;
    private String shareUrl;
    private String picUrl;
    private Bitmap weixinBmp;
    private String shareTitle;
    private String description;

    @Override
    public void setLayout() {
        setContentView(R.layout.popwin_share);
    }

    @Override
    public void initView() {
        view_wx_friend = findViewById(R.id.view_wx_friend);
        view_wx_friends = findViewById(R.id.view_wx_friends);
        view_sina = findViewById(R.id.view_sina);
        area_above = findViewById(R.id.area_above);
    }

    @Override
    public void initData() {
        weixinBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.logo2);
        shareUrl = getIntent().getStringExtra("shareUrl");
        picUrl = getIntent().getStringExtra("picUrl");
        shareTitle = getIntent().getStringExtra("title");
        description = getIntent().getStringExtra("description");
        ImageLoader.getInstance().loadImage(picUrl,
                new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        // 微信分享的图片有大小限制，必须压缩
                        weixinBmp = ImageManager.getInstance().createBitmapThumbnail(loadedImage, false);
                        super.onLoadingComplete(imageUri, view, loadedImage);
                    }
                });
    }

    @Override
    public void initListener() {
        view_wx_friends.setOnClickListener(this);
        view_wx_friend.setOnClickListener(this);
        view_sina.setOnClickListener(this);
        area_above.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.view_wx_friends:
                shareToWeiXin(1);
                break;
            case R.id.view_wx_friend:
                shareToWeiXin(0);
                break;
            case R.id.view_sina:
                mWeiboShareAPI = WeiboShareSDK.createWeiboAPI(this, SinaConstants.APP_KEY);
                mWeiboShareAPI.registerApp();   // 将应用注册到微博客户端

                if (!mWeiboShareAPI.isWeiboAppInstalled()) {
                    showShortToast("请安装新浪微博客户端！");
                    return;
                }

                WebpageObject webpageObject = new WebpageObject(); //分享网页是这个
                Bitmap thumb = BitmapFactory.decodeResource(this.getResources(), R.mipmap.logo2);
                webpageObject.setThumbImage(thumb); //注意，它会按照jpeg做85%的压缩，压缩后的大小不能超过32K
                webpageObject.title = shareTitle;//不能超过512
                webpageObject.actionUrl = shareUrl;// 不能超过512
                webpageObject.description = shareDescription;//不能超过1024
                webpageObject.identify = UUID.randomUUID().toString();//这个不知道做啥的
                webpageObject.defaultText = "外包大师";//这个也不知道做啥的
                //上面这些，一条都不能少，不然就会出现分享失败，主要是接口调用失败，而不会通过activity返回错误的intent

                //下面这个，就是用户在分享网页的时候，自定义的微博内容
                TextObject textObject = new TextObject();
                textObject.text = shareTitle;

                WeiboMultiMessage weiboMessage = new WeiboMultiMessage();//初始化微博的分享消息
                weiboMessage.mediaObject = webpageObject;
                weiboMessage.textObject = textObject;
                SendMultiMessageToWeiboRequest request = new SendMultiMessageToWeiboRequest();
                request.transaction = String.valueOf(System.currentTimeMillis());
                request.multiMessage = weiboMessage;
                mWeiboShareAPI.sendRequest(SharePopWin.this, request);//发送请求消息到微博，唤起微博分享界面
                break;
        }
    }

    public void shareToWeiXin(int way) {
        if (wxApi == null) {
            // 实例化
            wxApi = WXAPIFactory.createWXAPI(this, GlobalParam.WX_APP_ID);
            wxApi.registerApp(GlobalParam.WX_APP_ID);
        }

        if (!wxApi.isWXAppInstalled()) {
            showShortToast("请安装微信客户端！");
            return;
        }

        // 在需要分享的地方添加代码：
        wechatShare(way);// 0分享到微信好友;1分享到微信朋友圈
    }

    /**
     * 微信分享 （这里仅提供一个分享网页的示例，其它请参看官网示例代码）
     *
     * @param flag (0:分享到微信好友，1：分享到微信朋友圈)
     */
    private void wechatShare(int flag) {
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = shareUrl;
        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = shareTitle;
        msg.description = description;
        // 这里替换一张自己工程里的图片资源
        msg.setThumbImage(weixinBmp);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = msg;
        req.scene = flag == 0 ? SendMessageToWX.Req.WXSceneSession : SendMessageToWX.Req.WXSceneTimeline;
        wxApi.sendReq(req);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        // 从当前应用唤起微博并进行分享后，返回到当前应用时，需要在此处调用该函数
        // 来接收微博客户端返回的数据；执行成功，返回 true，并调用
        // {@link IWeiboHandler.Response#onResponse}；失败返回 false，不调用上述回调
        mWeiboShareAPI.handleWeiboResponse(intent, this);
    }

    /**
     * 接收微客户端博请求的数据。
     * 当微博客户端唤起当前应用并进行分享时，该方法被调用。
     *
     * @param baseResponse 微博请求数据对象
     * @see {@link IWeiboShareAPI#handleWeiboRequest}
     */
    @Override
    public void onResponse(BaseResponse baseResponse) {
        if (baseResponse != null) {
            switch (baseResponse.errCode) {
                case WBConstants.ErrorCode.ERR_OK:
                    Toast.makeText(this, "分享成功", Toast.LENGTH_LONG).show();
                    break;
                case WBConstants.ErrorCode.ERR_CANCEL:
                    Toast.makeText(this, "分享取消", Toast.LENGTH_LONG).show();
                    break;
                case WBConstants.ErrorCode.ERR_FAIL:
                    Toast.makeText(this, "分享失败，错误: " + baseResponse.errMsg, Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}
