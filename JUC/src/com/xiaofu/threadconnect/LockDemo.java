package com.xiaofu.threadconnect;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 比 Synchronized有着更为强大的功能,比如准确唤醒，ReentrantLock可以配合
 * Condition准确唤醒线程
 */
class MyPrint{
    private volatile int flag = 1; // 1表示A线程 2表示B线程 3表示C线程
    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();
    public void print(int count) throws InterruptedException {
        if(count ==5 ){
            lock.lock();
            try{
                while(flag != 1){
                    a.await();
                }
                // 干活
                for (int i = 1; i <=count ; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t"+i);
                }
                // 唤醒
                flag = 2;
                b.signal();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
        if(count == 10){
            lock.lock();
            try{
                while(flag != 2){
                    b.await();
                }
                // 干活
                for (int i = 1; i <=count ; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t"+i);
                }
                // 唤醒
                flag = 3;
                c.signal();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
        if(count ==15 ){
            lock.lock();
            try{
                while(flag != 3){
                    c.await();
                }
                // 干活
                for (int i = 1; i <=count ; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t"+i);
                }
                // 唤醒
                flag = 1;
                a.signal();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }

    }




}
public class LockDemo {
    public static void main(String[] args) {
        MyPrint print = new MyPrint();
        new Thread(()->{
            try {
                for (int i = 0; i <10 ; i++) {
                    print.print(5);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                for (int i = 0; i <10 ; i++) {
                    print.print(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {
                for (int i = 0; i <10 ; i++) {
                    print.print(15);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"C").start();




    }
}
