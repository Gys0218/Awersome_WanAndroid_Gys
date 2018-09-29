package com.example.lenovo.awersome_wanandroid_gys.bean;

public class HttpResult<T> {

    private int errorCode;
    private String errorMsg;
    private T data;

    @Override
    public String toString() {
        return "HttpResult{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HttpResult(int errorCode, String errorMsg, T data) {

        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }
}
