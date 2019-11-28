package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {



    public static void main(String[] args) {

        System.out.println("          SEMAPHORE \n");
        Semaphore semaphore = new Semaphore(4);



        for (int i = 1; i <= 100; i++) {
            PassengerThread passengerThread = new PassengerThread(semaphore, i);
            passengerThread.start();


        }


        for (int i = 0; i <100 ; i++) {
            CountDownLatch countDownLatch = new CountDownLatch(100);
            new BusPlaces(countDownLatch, i+1).start();

        }
        System.out.println("\n \n");
        System.out.println("      CountDownLatch \n");







    }


}
