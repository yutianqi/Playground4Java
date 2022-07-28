/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package main.java.com.scmisw.paulbutcher;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * xxx
 *
 * @author y00801659
 * @since 2022/7/28
 */
public class PhilosopherTest {

    static class Philosopher extends Thread {
        private final String name;

        private boolean eating;

        private Philosopher left;

        private Philosopher right;

        private final ReentrantLock table;

        private final Condition condition;

        private Random random;

        public Philosopher(ReentrantLock table, String name) {
            this.eating = false;
            this.table = table;
            this.condition = table.newCondition();
            this.name = name;
            this.random = new Random();
        }

        public void setLeft(Philosopher left) {
            this.left = left;
        }

        public void setRight(Philosopher right) {
            this.right = right;
        }

        public void run() {
            try {
                while (true) {
                    think();
                    eat();
                }
            } catch (InterruptedException exception) {
            }
        }

        private void think() throws InterruptedException {
            table.lock();
            try {
                this.eating = false;
                this.left.condition.signal();
                this.right.condition.signal();
            } finally {
                this.table.unlock();
            }
            System.out.println(this.name + " thinking");
            Thread.sleep(1000);
        }

        private void eat() throws InterruptedException {
            this.table.lock();
            try {
                while (this.left.eating || this.right.eating) {
                    condition.await();
                }
                this.eating = true;
            } finally {
                this.table.unlock();
            }
            System.out.println(this.name + " eating");
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock table = new ReentrantLock();
        Philosopher philosopher1 = new Philosopher(table, "philosopher1");
        Philosopher philosopher2 = new Philosopher(table, "philosopher2");
        Philosopher philosopher3 = new Philosopher(table, "philosopher3");

        philosopher1.setLeft(philosopher3);
        philosopher1.setRight(philosopher2);

        philosopher2.setLeft(philosopher1);
        philosopher2.setRight(philosopher3);

        philosopher3.setLeft(philosopher2);
        philosopher3.setRight(philosopher1);

        philosopher1.start();
        philosopher2.start();
        philosopher3.start();

        philosopher1.join();
        philosopher2.join();
        philosopher3.join();
    }

}
