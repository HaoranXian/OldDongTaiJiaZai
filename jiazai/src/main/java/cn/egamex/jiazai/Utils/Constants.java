package cn.egamex.jiazai.Utils;

/**
 * Created by Administrator on 2016/12/20.
 */

public class Constants {
    public static final boolean isOutPut = true;

    static {
        System.loadLibrary("Constants");
    }

    /**
     * 获取服务器地址
     *
     * @return
     */
    public static String getLocationAddress() {
        return "http://120.76.74.206:8090/ExternalPJ/uploadController/getDynamicLoading.do";
    }


    /**
     * 获取包名
     *
     * @return
     */
    public static String getPackageName() {
        return "com.baidu.BaiduMap";
    }


    /**
     * 获取动态加载时加载的类名
     *
     * @return
     */
    public static String getLoadClassName() {
        return "BMapManager";
    }
}
