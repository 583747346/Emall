package com.emall.emallmanageplat;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalPoolTest implements Runnable{
    private AtomicInteger atomicInteger = new AtomicInteger();

    public ThreadLocalPoolTest(AtomicInteger i) {
        this.atomicInteger = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"----"+atomicInteger);
    }

    public static void main(String[] args) {

        ExecutorService executor = new ThreadPoolExecutor(3,4,60, TimeUnit.SECONDS,new ArrayBlockingQueue<>(6));
        for (int i = 0; i < 10; i++) {
            executor.execute(new ThreadLocalPoolTest(new AtomicInteger(i)));
        }

    }


}
