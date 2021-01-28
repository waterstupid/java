package com.xiaofu.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger atomic = new AtomicInteger(5);
        atomic.getAndIncrement();
        atomic.compareAndSet(5,2010);




    }
}
