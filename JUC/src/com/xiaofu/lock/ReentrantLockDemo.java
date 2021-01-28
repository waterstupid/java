package com.xiaofu.lock;
class  MyData{

    // synchronized是可重入锁(也就是递归锁)
    public synchronized void method01(){
        System.out.println("method 01");
        method02();
    }
    public synchronized void method02(){
        System.out.println("method 02");

    }


}
public class ReentrantLockDemo {
    public static void main(String[] args) {
        MyData data = new MyData();
        // 这里可以递归调用说明synchronized是一个可重入锁(递归锁)
        new Thread(()->{data.method01();},"A").start();
        try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        System.out.println("***********");
        new Thread(()->{data.method01();},"B").start();








    }

}
