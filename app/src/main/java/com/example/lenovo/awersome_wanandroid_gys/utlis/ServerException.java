package com.example.lenovo.awersome_wanandroid_gys.utlis;

public class ServerException extends Exception {

    private int mCode;

    public ServerException(int mCode, String message){
        super(message);
        mCode = mCode;
    }

    public ServerException(int mCode, String message, Throwable throwable){
        super(message);
        this.mCode = mCode;
    }

    public int getmCode() {
        return mCode;
    }
}
