package com.utils.lib.ss.netChek.broad;

import android.content.Context;
import android.content.Intent;

public class NetworkBroadcastHelper {

    //网络可用
    private static Intent onNetworkEnabledIntent = new Intent("onSdkNetworkEnabled");
    //网络不可用
    private static Intent onNetworkDisEnabledIntent = new Intent("onSdkNetworkDisEnabled");
    //网络不可用
    private static Intent onNetworkErrorIntent = new Intent("onSdkNetworkError");

    public static void onNetworkEnabled(Context context, Integer networkConnectType , String wifiName , Integer signalLevel){
        onNetworkEnabledIntent.putExtra("networkConnectType" , networkConnectType);
        onNetworkEnabledIntent.putExtra("wifiName" , wifiName);
        onNetworkEnabledIntent.putExtra("signalLevel" , signalLevel);
        context.sendBroadcast(onNetworkEnabledIntent);
    }

    public static void onNetworkDisEnabled(Context context){
        context.sendBroadcast(onNetworkDisEnabledIntent);
    }

    public static void onNetworkError(Context context){
        context.sendBroadcast(onNetworkErrorIntent);
    }

}
