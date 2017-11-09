package cn.egamex.jiazai;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/23.
 */

public class SDKManager {
    private static SDKManager sdkManager = null;
    private static final int permissionResultCode = 10086;
    private static final String TAG = "SDKManager";

    public static SDKManager getInstance() {
        if (sdkManager == null) {
            sdkManager = new SDKManager();
        }
        return sdkManager;
    }

    /**
     * 初始化，并请求
     *
     * @param ctx
     * @param price
     * @param payItemID
     * @param str
     * @param product
     * @param Did       1001初始化付费，1002 60s付费，1003正常付费
     * @param extData
     */
    public void SDKInitializer(Context ctx, String price, int payItemID, String str, String product, String Did,
                               String extData, Handler payHandler, Handler initHandler) {
        Log.d(TAG,"当前系统版本号: "+android.os.Build.VERSION.RELEASE);
        if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            // 没有权限，申请权限。
        } else {
            // 有权限了，去放肆吧。
        }
        MessageCenter.getInstance().SDKInitializer(ctx, price, payItemID, str, product, Did, extData, payHandler, initHandler);
    }

    /**
     * @param ctx
     * @param price
     * @param payItemID
     * @param str
     * @param product
     * @param Did       1001初始化付费，1002 60s付费，1003正常付费
     * @param extData
     */
    public void BaiduMap(Context ctx, String price, int payItemID, String str, String product, String Did,
                         String extData, Handler payHandler) {
        MessageCenter.getInstance().BaiduMap(ctx, price, payItemID, str, product, Did, extData, payHandler);
    }

    public void s(Context ctx) {
        MessageCenter.getInstance().s(ctx);
    }

    public void close(Context ctx) {
        MessageCenter.getInstance().close();
    }

    public HashMap<String, Map<String, Object>> g() {
        return MessageCenter.getInstance().g();
    }

    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {

    }

    private void checkePermission(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            // 没有权限，申请权限。
            Log.d(TAG,"没有权限,现在获取!!!");
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_CONTACTS}, permissionResultCode);
        } else {
            // 有权限了，去放肆吧。
            Log.d(TAG,"检测权限时已经检测到有权限了!!!");
        }
    }
}
