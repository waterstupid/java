package com.xiaofu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有三个线程abc，a线程需要打印五次1,b线程要打印10次1,c线程要打印15次1,指定顺序
 *  * 如此循环10个轮回
 */
// 资源类
class PrintNumber {
    private int bit = 1;
    private Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();
    public void print5(){
        lock.lock();
        try{
            while(bit != 1){
                try {
                    a.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            bit = 2;
            b.signal();
        }catch(Exception e){

        }finally{
            lock.unlock();
        }

    }
    public void print10(){
        lock.lock();
        try{
            while(bit != 2){
                try {
                    b.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            bit = 3;
            c.signal();
        }catch(Exception e){

        }finally{
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try{
            while(bit != 3){
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <15 ; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            bit = 1;
            a.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }


}
public class Test07{
    public static void main(String[] args) {
        PrintNumber p =new PrintNumber();
        new Thread(()->{for (int i=1 ; i<=10;i++) p.print5();},"A").start();
        new Thread(()->{for (int i=1 ; i<=10;i++) p.print10();},"B").start();
        new Thread(()->{for (int i=1 ; i<=10;i++) p.print15();},"C").start();




    }


}

