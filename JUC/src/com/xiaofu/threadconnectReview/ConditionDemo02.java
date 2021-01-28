package com.xiaofu.threadconnectReview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 需要完成以下一个需求:
 * 有三个线程ABC,A输出1-5的数,B输出1-10的数，C输出15的数
 * 顺序是A->B->C,一共输出10轮
 **/
public class ConditionDemo02 {
    public static void main(String[] args) {
        Print01 print = new Print01();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                print.print5();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                print.print10();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                print.print15();
            }
        },"C").start();
    }

}
class Print01{
    private int flag = 1;
    private ReentrantLock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();
    public void print5(){
        lock.lock();
        try{
            // 判断
            while(flag != 1 ){
                a.await();
            }
            // 干活
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"->\t"+i);
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
    public void print10(){
        lock.lock();
        try{
            // 判断
            while(flag !=2 ){
                b.await();
            }
            // 干活
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"->\t"+i);
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
    public void print15(){
        lock.lock();
        try{
            // 判断
            while(flag != 3 ){
                c.await();
            }
            // 干活
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"->\t"+i);
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
