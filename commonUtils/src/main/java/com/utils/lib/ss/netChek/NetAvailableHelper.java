package com.utils.lib.ss.netChek;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.utils.lib.ss.common.ThreadPool;

public class NetAvailableHelper {

    private static WifiManager WifiManager = null;

    public static void onNetCheck(final Context context , final OnNetAvailableListener onNetAvailableListener){
        ThreadPool.add(new Runnable() {
            @Override
            public void run() {
                //先判断是否可以访问网络
                boolean isNetworkOnline = isNetworkOnline();
                if (isNetworkOnline){
                    //有网络,判断网络类型，有线，无线
                    int isNetworkAvailable = isNetworkAvailable(context);
                    if (isNetworkAvailable == NetworkConnectType.Wired.type){
                        //有线网络：接网线
                        onNetAvailableListener.onNetWorkEnabled(NetworkConnectType.Wired , null , 2);

                    }else if (isNetworkAvailable == NetworkConnectType.Wireless.type){
                        //无线网络，检测Wifi，wifi名称
                        initWifiManager(context);
                        boolean isWifiEnabled = WifiManager.isWifiEnabled();
                        if (isWifiEnabled){
                            //在有网络的情况下返回Wifi分级
                            WifiInfo wifiInfo = WifiManager.getConnectionInfo();
                            //wifi信号强度
                            int signalLevel = WifiManager.calculateSignalLevel(wifiInfo.getRssi(), 4);

                            onNetAvailableListener.onNetWorkEnabled(NetworkConnectType.Wireless , formatWifiName(wifiInfo.getSSID())  , signalLevel);
                        }
                    }else{
                        //假网
                        onNetAvailableListener.onError();
                    }
                }else{
                    //没有网络
                    int isNetworkAvailable = isNetworkAvailable(context);
                    if (isNetworkAvailable == NetworkConnectType.Wireless.type){
                        //假Wifi
                        onNetAvailableListener.onError();
                    }else if (isNetworkAvailable == NetworkConnectType.Wired.type){
                        //假有线
                        onNetAvailableListener.onError();
                    }else{
                        //网线没接，Wifi没有连接任何网络
                        onNetAvailableListener.onDisabled();
                    }
                }

            }
        });
    }

    private static void initWifiManager(Context context){
        if (null == WifiManager){
            WifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        }
    }

    private static String formatWifiName(String wifiName){
        if (null == wifiName || wifiName.isEmpty()){
            return "";
        }
        //去掉两边的引号
        if (wifiName.startsWith("\"") && wifiName.endsWith("\"")){
            int length = wifiName.length();
            String ssid = wifiName.substring(1 , length - 1);
            return ssid;
        }
        return wifiName;
    }

    private static boolean isNetworkOnline(){
        try{
            Runtime runtime = Runtime.getRuntime();
            Process ipProcess = runtime.exec("ping -c 3 www.baidu.com");
            int exitValue = ipProcess.waitFor();
            return 0 == exitValue;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private static int isNetworkAvailable(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ethNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_ETHERNET);
        NetworkInfo wifiNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (null != ethNetInfo && ethNetInfo.isConnected()){
            return NetworkConnectType.Wired.type;
        }else if (null != wifiNetInfo && wifiNetInfo.isConnected()){
            return NetworkConnectType.Wireless.type;
        }
        return NetworkConnectType.None.type;
    }

    public String getConnectedSSid(Context context){
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo connectionInfo =wifiManager.getConnectionInfo();
        if (null == connectionInfo){
            return "";
        }
        String ssid = connectionInfo.getSSID();
        if (null == ssid || ssid.isEmpty()){
            return "";
        }
        //去掉两边的引号
        if (ssid.startsWith("\"") && ssid.endsWith("\"")){
            int length = ssid.length();
            ssid = ssid.substring(1 , length - 1);
        }
        return ssid;
    }


}
