package com.company;

import java.util.concurrent.*;

public class MyThread extends Thread {
    private Phaser phaser;
    private int milisec;
    private int val;

    public MyThread(Phaser phaser, int milisec, int val) {
        this.phaser = phaser;
        this.milisec = milisec;
        this.val = val;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + " is on phase 1");
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " phase 1 ended");
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + " is on phase 2");

    }
}
