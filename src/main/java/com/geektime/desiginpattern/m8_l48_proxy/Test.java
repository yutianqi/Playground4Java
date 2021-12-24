/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package main.java.com.geektime.desiginpattern.m8_l48_proxy;

/**
 * xxx
 *
 * @author y00290641
 * @since 2021/12/9
 */
public class Test {
    public static void main(String[] args) {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
    }
}


