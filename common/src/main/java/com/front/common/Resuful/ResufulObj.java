package com.front.common.Resuful;

/** Resultful 返回结果封装对象
 * Created by XKR on 2017/7/4.
 */
public class ResufulObj {
    private int code;
    private String message;
    private Object data;

    public ResufulObj() {
    }

    public ResufulObj(StateEnum code,String message, Object data) {
        this.code = code.ordinal();
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
