package com.xiaofu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有三个线程abc，a线程需要打印五次1,b线程要打印10次1,c线程要打印15次1,指定顺序
 * 如此循环10个轮回
 */
class PrintCount{
    private int bit = 1;
    private final Lock lock = new ReentrantLock();
    // 创建condition对象,让一把锁有三把钥匙
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    public void print5(){
        lock.lock();
        try{
            // 判断
            while(bit != 1){
                a.await();
            }
            // 干活
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            // 通知
            bit = 2;
            b.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try{
            // 判断
            while(bit != 2){
                b.await();
            }
            // 干活
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            // 通知
            bit = 3;
            c.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try{
            // 判断
            while(bit != 3){
                c.await();
            }
            // 干活
            for (int i = 0; i <15 ; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            // 通知
            bit = 1;
            a.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }



}


public class Text06{
    public static void main(String[] args) {
        PrintCount p = new PrintCount();
        new Thread(()->{for (int i = 0; i< 2;i++) p.print5();},"A").start();
        new Thread(()->{for (int i = 0; i< 2;i++) p.print10();},"B").start();
        new Thread(()->{for (int i = 0; i< 2;i++) p.print15();},"C").start();




    }
}
