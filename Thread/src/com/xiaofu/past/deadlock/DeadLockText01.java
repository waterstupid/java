package com.xiaofu.past.deadlock;

/**
 * 该方法用来测验死锁
 * 1.什么是死锁？
 * 死锁就是两个线程彼此占用对方所需要的资源，谁也不肯释放，导致谁也不会运行，然后就死锁了
 * 所以在实际应用中，还是要谨慎使用synchronized()嵌套
 * @author fmk
 * @date 2020/5/2
 **/
public class DeadLockText01 {
    public static void main(String[] args) {
        Object obj1=new Object();
        Object obj2=new Object();
        Thread t1=new Thread(new Runnable01(obj1,obj2));
        Thread t2=new Thread(new Runnable02(obj1,obj2));
        t1.start();
        t2.start();


    }
}

class Runnable01 implements Runnable{
    Object obj1=new Object();
    Object obj2=new Object();
    public Runnable01(Object obj1,Object obj2){
        this.obj1=obj1;
        this.obj2=obj2;
    }
    @Override
    public void run() {
        synchronized(obj1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(obj2){

            }
        }

    }
}

class Runnable02 implements Runnable{
    Object obj1=new Object();
    Object obj2=new Object();
    public Runnable02(Object obj1,Object obj2){
        this.obj1=obj1;
        this.obj2=obj2;
    }
    @Override
    public void run() {
        synchronized (obj2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj1){

            }
        }

    }
}