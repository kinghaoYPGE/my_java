package com.myspringboot.ajax.dto;

/**
 * 封装ajax请求返回对象
 */
public class ResultBean {

    private int code;
    private String data;

    public ResultBean(int code, String data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
