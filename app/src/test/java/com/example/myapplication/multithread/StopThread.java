package com.example.myapplication.multithread;

import org.junit.Test;

public class StopThread implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < 1000) {
            System.out.println("count = " + count++);
            reInterrupt();
        }

    }

    public void fly() throws InterruptedException {
        Thread.sleep(1000000);
    }

    public void reInterrupt() {
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            //e.printStackTrace();
        }
    }




    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();
        Thread.sleep(50);
        thread.interrupt();

        //thread.suspend();
        //thread.resume();
    }
}
