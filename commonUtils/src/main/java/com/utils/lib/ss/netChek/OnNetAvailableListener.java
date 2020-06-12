package com.utils.lib.ss.netChek;

public class OnNetAvailableListener {

    //正要检测网络状态
    public void onChecking(){}

    //WIFI关闭，且网络不可用
    public void onDisabled(){}

    //有网，用信号等级表示
    //只有无线网线时，才有wifiName，signalLevel
    public void onNetWorkEnabled(NetworkConnectType connectType, String wifiName , Integer signalLevel){}

    //假网
    public void onError(){}

}
