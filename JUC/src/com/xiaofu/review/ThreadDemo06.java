package com.xiaofu.review;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import sun.security.krb5.internal.ccache.CCacheOutputStream;

import javax.xml.stream.events.StartDocument;
import java.time.chrono.MinguoChronology;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyPrint{
    private int flag = 1;
    Lock lock = new ReentrantLock();
    Condition a =lock.newCondition();
    Condition b =lock.newCondition();
    Condition c =lock.newCondition();
    public void print(int count){
        if(count == 5){
            lock.lock();
            try{
                while(flag != 1){
                    a.await();
                }
                for (int i = 1; i <= count; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t i="+i);
                }
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
                for (int i = 1; i <= count; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t i="+i);
                }
                flag = 3;
                c.signal();

            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
        if(count == 15){
            lock.lock();
            try{
                while(flag != 3){
                    c.await();
                }
                for (int i = 1; i <= count; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t i="+i);
                }
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
public class ThreadDemo06 {
    public static void main(String[] args) {
        MyPrint print = new MyPrint();
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
