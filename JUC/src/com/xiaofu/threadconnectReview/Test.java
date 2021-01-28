package com.xiaofu.threadconnectReview;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
        AtomicInteger atomic = new AtomicInteger();
        System.out.println(atomic.getAndIncrement());
        //System.out.println(atomic.decrementAndGet());


    }
}
