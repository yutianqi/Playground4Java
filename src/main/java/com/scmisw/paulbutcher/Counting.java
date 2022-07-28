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
public class Counting {
    public static void main(String[] args) throws InterruptedException {
        class Counter {
            private int count = 0;

            public synchronized void increment() {
                ++count;
            }

            public int getCount() {
                return count;
            }
        }
        final Counter counter = new Counter();
        class CountingThread extends Thread {
            public void run() {
                for (int x = 0; x < 10000; x++) {
                    counter.increment();
                }
            }
        }
        CountingThread t1 = new CountingThread();
        CountingThread t2 = new CountingThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCount());

    }
}
