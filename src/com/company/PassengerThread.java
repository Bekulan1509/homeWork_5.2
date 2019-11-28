package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {

    Semaphore semaphore;
    int number;








    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public PassengerThread( Semaphore semaphore, int number) {
        this.semaphore = semaphore;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("a passenger "+number+" bought a ticket to Osh");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
