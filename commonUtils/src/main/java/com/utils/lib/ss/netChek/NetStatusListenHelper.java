package com.utils.lib.ss.netChek;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.utils.lib.ss.netChek.broad.NetworkBroadcastHelper;

public class NetStatusListenHelper {

    private Context context = null;

    public NetStatusListenHelper(Context context){
        this.context = context;
    }

    private Handler mHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1039){
                checkNetStatus();
            }
        }
    };

    private void checkNetStatus(){
        NetAvailableHelper.onNetCheck(context , new OnNetAvailableListener(){
            @Override
            public void onChecking() {

            }

            @Override
            public void onDisabled() {
                NetworkBroadcastHelper.onNetworkDisEnabled(context);
            }
            @Override
            public void onError() {
                NetworkBroadcastHelper.onNetworkError(context);
            }
            @Override
            public void onNetWorkEnabled(NetworkConnectType connectType, String wifiName, Integer signalLevel) {
                NetworkBroadcastHelper.onNetworkEnabled(context, connectType.type , wifiName ,  signalLevel);
            }
        });

        //最小间隔2秒
        mHandler.removeMessages(1039);
        mHandler.sendEmptyMessageDelayed(1039 , delayMillis < 2000 ? 2000 : delayMillis);
    }

    private long delayMillis = 8000;

    public void setDelayMillis(long delayMillis) {
        this.delayMillis = delayMillis;
    }

    private void stopCheckNetStatus(){
        mHandler.removeMessages(1039);
    }

    public void startListen(){
        checkNetStatus();
    }

    public void stopListen(){
        stopCheckNetStatus();
    }


}
