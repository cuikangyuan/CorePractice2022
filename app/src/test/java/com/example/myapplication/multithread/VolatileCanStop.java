package com.example.myapplication.multithread;


import org.junit.Test;

public class VolatileCanStop implements Runnable {

    private volatile boolean canceled = false;

    @Override
    public void run() {
        int count = 0;
        try {
            while (!canceled && count < 1000000) {
                if (count % 10 == 0) {
                    System.out.println("count = " + count);
                }
                count++;
                Thread.sleep(5);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void test() throws InterruptedException {
        VolatileCanStop volatileCanStop = new VolatileCanStop();
        Thread thread = new Thread(volatileCanStop);
        thread.start();
        Thread.sleep(1000);
        volatileCanStop.canceled = true;
    }
}
