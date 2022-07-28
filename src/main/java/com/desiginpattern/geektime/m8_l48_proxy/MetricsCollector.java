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
public class MetricsCollector {

    private MetricsCollector() {
    }

    private static volatile MetricsCollector instance;

    public static MetricsCollector getInstance() {
        if (instance == null) {
            synchronized (MetricsCollector.class) {
                if (instance == null) {
                    instance = new MetricsCollector();
                }
            }
        }
        return instance;
    }

    public void recordRequest(RequestInfo reqInfo) {
        System.out.println("[MetricsCollector] " + reqInfo.getRequestName() + "," + reqInfo.getStartTime() + ","
            + reqInfo.getRespTime());
    }

}
