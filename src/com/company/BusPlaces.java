package com.company;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class BusPlaces extends Thread {
   private CountDownLatch countDownLatch;
    private int number;

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BusPlaces(CountDownLatch countDownLatch, int number) {
        this.countDownLatch = countDownLatch;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
            System.out.println(" passenger "+number+" got on the bus");
            countDownLatch.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}



