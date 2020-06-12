package com.utils.lib.ss.netChek;

public enum NetworkConnectType {

    Wireless(0), //无线
    Wired(1), //有线
    None(2); //无网

    int type = 0;

    NetworkConnectType(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }

}
