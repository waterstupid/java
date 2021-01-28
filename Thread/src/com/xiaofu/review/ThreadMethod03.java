package com.xiaofu.review;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TagName;

/**
 * 该类用来测试Thread类中yield()
 * 该方法是指当前线程退出对cpu的占有权，等其他线程执行完毕之后，当前线程才会继续执行
 */
public class ThreadMethod03 {
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            Thread.yield();
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + "->" + i);

            }
        }, "A");
        Thread b = new Thread(() -> {

            //try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + "->" + i);

            }
        }, "B");
        Thread c = new Thread(() -> {
            //try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + "->" + i);

            }
        }, "C");
        a.start();
        b.start();
        c.start();






    }
}
