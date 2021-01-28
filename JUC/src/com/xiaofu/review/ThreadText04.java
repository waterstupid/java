package com.xiaofu.review;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Print05{
    private int flag = 1; //1代表A 2代表B 3代表C
    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();
    public void print(int count ) {
        if (count == 5) {
            lock.lock();
            try {
                // 判断
                while (flag != 1) {
                    a.await();
                }
                // 干活
                for (int i = 1; i <= count; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t->" + i);
                }
                // 唤醒
                flag = 2;
                b.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        if (count == 10) {
            lock.lock();
            try {
                // 判断
                while (flag != 2) {
                    b.await();
                }
                // 干活
                for (int i = 1; i <= count; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t->" + i);
                }
                // 唤醒
                flag = 3;
                c.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        if (count == 15) {
            lock.lock();
            try {
                // 判断
                while (flag != 3) {
                    c.await();
                }
                // 干活
                for (int i = 1; i <= count; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t->" + i);
                }
                // 唤醒
                flag = 1;
                a.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}




public class ThreadText04 {
    public static void main(String[] args) {
        Print05 print = new Print05();

        new Thread(()->{
            for (int i = 0; i <3 ; i++) {
                print.print(5);
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i <3 ; i++) {
                print.print(10);
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i <3 ; i++) {
                print.print(15);
            }
        },"C").start();





    }
}
