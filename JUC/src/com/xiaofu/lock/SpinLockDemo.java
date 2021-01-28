package com.xiaofu.lock;

import java.util.concurrent.atomic.AtomicReference;

class MyData03{
    private int number;
    // 默认值为Null
    AtomicReference<Thread> reference = new AtomicReference<>();
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in");
        // 这里相当于一个自旋锁
        while(!reference.compareAndSet(null,thread)){

        }
        // 可以在这里对变量进行操作
        number++;
        System.out.println(Thread.currentThread().getName()+"\t number="+number);
        System.out.println(Thread.currentThread().getName()+"\t finish");
    }
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        reference.compareAndSet(thread,null);
        System.out.println("unlock finish");
    }


}
/**
 * 手写一个自旋锁
 */
public class SpinLockDemo {
    public static void main(String[] args) {
        MyData03 data = new MyData03();
        for(int i = 0; i<10;i++){
            new Thread(() ->{
                for (int j = 0; j <100 ; j++) {
                    data.myLock();
                    data.myUnLock();
                }
            },String.valueOf(i)).start();
        }
    }
}
