package com.example.myapplication.multithread;

public class RunnableThread implements MyRunnable {

    @Override
    public void run() throws InterruptedException {
        System.out.println("用实现Runnable接口实现线程");
    }
}
