package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {
CountDownLatch countDownLatch;
    Semaphore semaphore;
    int number;


    public PassengerThread(CountDownLatch countDownLatch, Semaphore semaphore, int number) {
        this.countDownLatch = countDownLatch;
        this.semaphore = semaphore;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("a passenger "+number+" bought a ticket to Osh");
sleep(1000);
            System.out.println(" passenger "+number+" got on the bus");
            countDownLatch.countDown();

            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
