package com.utils.lib.ss.netChek.broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.utils.lib.ss.netChek.NetworkConnectType;

public class NetWorkBroadcastReceiver extends BroadcastReceiver {

    public OnNetWorkBroadcastReceiverListener onNetWorkBroadcastReceiverListener = null;

    private Context context = null;

    public NetWorkBroadcastReceiver(Context context){
        this.context = context;
    }

    public void register(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("onSdkNetworkEnabled");
        intentFilter.addAction("onSdkNetworkDisEnabled");
        intentFilter.addAction("onSdkNetworkError");
        context.registerReceiver(this , intentFilter);
    }

    public void unRegister(){
        context.unregisterReceiver(this);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (null == onNetWorkBroadcastReceiverListener){
            return;
        }
        String action = intent.getAction();
        if (action.equals("onSdkNetworkEnabled")){
            //网络可用
            int networkConnectType = intent.getIntExtra("networkConnectType" , NetworkConnectType.Wireless.getType());
            String wifiName = intent.getStringExtra("wifiName");
            int signalLevel = intent.getIntExtra("signalLevel" , 1);

            onNetWorkBroadcastReceiverListener.onNetworkEnabled(networkConnectType , wifiName , signalLevel);
        }else if (action.equals("onSdkNetworkDisEnabled")){
            //网络不可用
            onNetWorkBroadcastReceiverListener.onNetworkDisEnabled();
        }else if (action.equals("onSdkNetworkError")){
            //网络不可用
            onNetWorkBroadcastReceiverListener.onNetworkError();
        }
    }

    public void setOnNetWorkBroadcastReceiverListener(OnNetWorkBroadcastReceiverListener onNetWorkBroadcastReceiverListener) {
        this.onNetWorkBroadcastReceiverListener = onNetWorkBroadcastReceiverListener;
    }
}
