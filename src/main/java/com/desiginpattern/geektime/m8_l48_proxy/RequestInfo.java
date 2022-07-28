/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package main.java.com.desiginpattern.geektime.m8_l48_proxy;

/**
 * xxx
 *
 * @author y00290641
 * @since 2021/12/9
 */
public class RequestInfo {

    private String requestName;

    private long startTime;

    private long respTime;

    public RequestInfo(String requestName, long respTime, long startTime) {
        this.requestName = requestName;
        this.respTime = respTime;
        this.startTime = startTime;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getRespTime() {
        return respTime;
    }

    public void setRespTime(long respTime) {
        this.respTime = respTime;
    }
}
