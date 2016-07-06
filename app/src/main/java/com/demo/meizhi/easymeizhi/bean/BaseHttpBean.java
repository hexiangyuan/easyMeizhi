package com.demo.meizhi.easymeizhi.bean;

/**
 * Created by 何祥源 on 16/7/6.
 * Desc:
 */
public class BaseHttpBean<T> {
    public String resultcode;
    public String reason;
    public T result;
    public int error_code;
}
