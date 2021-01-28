package com.xiaofu.threadconnectReview;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 需要完成以下一个需求:
 * 有三个线程ABC,A输出1-5的数,B输出1-10的数，C输出15的数
 * 顺序是A->B->C,一共输出10轮
 * 注意：这个涉及到定点唤醒的知识，需要使用到ReentrantLock中的Condition，Condition有着比Synchronized的定点唤醒的特点
 *
 */
public class ConditionDemo01 {
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                print.print(5);
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                print.print(10);
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                print.print(15);
            }
        },"C").start();




    }
}
class Print{
    private int flag = 1; // 1代表a 2代表b 3代表c
    private ReentrantLock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();
    public void print(int count){
        if(count == 5){
            lock.lock();
            try{
                while(flag != 1){
                    a.await();
                }
                // 干活
                for (int i = 1; i <=count ; i++) {
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


        }else if(count == 10){
            lock.lock();
            try{
                while(flag != 2){
                    b.await();
                }
                // 干活
                for (int i = 1; i <=count ; i++) {
                    System.out.println(Thread.currentThread().getName()+"->\t"+i);
                }
                //唤醒
                flag = 3;
                c.signal();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
            // 判断

        }else if(count == 15){
            lock.lock();
            try{
                while(flag != 3){
                    c.await();
                }
                //干活
                for (int i = 1; i <=count ; i++) {
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




}
