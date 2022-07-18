package com.example.myapplication.multithread;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private volatile boolean canceled = false;
    BlockingQueue storage = null;
    int count = 0;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {

        try {
            while (!canceled && count < 1000000) {
                if (count % 50 == 0) {
                    storage.put(count);
                    System.out.println("生产者把" + count + "被放入仓库");
                }
                count++;
            }
        } catch (InterruptedException e) {
        } finally {
            System.out.println("生产者结束");
        }
    }

    @Test
    public void test() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(10);
        Producer producer = new Producer(blockingQueue);
        Thread pt = new Thread(producer);
        pt.start();
        Thread.sleep(500);

        Consumer consumer = new Consumer(blockingQueue);
        while (consumer.needMore()) {
            System.out.println(blockingQueue.take() + "被消费了");
            Thread.sleep(100);
        }

        System.out.println("消费者不需要更多数据了");
        producer.canceled = true;
        /*
        然而结果却不是我们想象的那样，尽管已经把 canceled 设置成 true，但生产者仍然没有停止，这是因为在这种情况下，生产者在执行 storage.put(num) 时发生阻塞，
        在它被叫醒之前是没有办法进入下一次循环判断 canceled 的值的，所以在这种情况下用 volatile 是没有办法让生产者停下来的，相反如果用 interrupt 语句来中断，即使生产者处于阻塞状态，仍然能够感受到中断信号，并做响应处理。
        * */
    }
}

class Consumer {

    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMore() {
        if (Math.random() > 0.9) return false;
        else return true;
    }
}
