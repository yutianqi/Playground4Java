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
public class UserController implements IUserController{
    @Override
    public UserVo login(String username, String password) {
        System.out.println("Begin to login");
        // login功能代码...
        UserVo userVo = new UserVo(username, password);
        System.out.println("Finished to login");
        // 返回UserVo数据
        return userVo;
    }
}
