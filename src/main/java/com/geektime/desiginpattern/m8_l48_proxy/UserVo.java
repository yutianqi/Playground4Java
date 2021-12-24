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
public class UserVo {

    private String username;

    private String password;

    public UserVo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
