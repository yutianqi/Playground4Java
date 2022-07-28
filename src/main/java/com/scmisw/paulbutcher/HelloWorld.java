/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package main.java.com.scmisw.paulbutcher;

/**
 * xxx
 *
 * @author y00801659
 * @since 2022/7/28
 */
public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread() {
            public void run() {
                System.out.println("Hello from new thread");
            }
        };
        myThread.start();
        Thread.yield();
        Thread.sleep(1000);
        System.out.println("Hello from main thread");
        myThread.join();
    }
}
