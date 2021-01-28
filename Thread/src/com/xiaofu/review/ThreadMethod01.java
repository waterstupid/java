package com.xiaofu.review;

class E implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i  == 20){
                Thread.yield();
            }
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+"--->"+i);
            }
        }
    }
}

class F implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if( i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+"--->"+i);
            }
        }
    }
}

public class ThreadMethod01 {
    public static void main(String [] args){
        E e = new E();
        F f = new F();

        Thread t1 = new Thread(e);
        Thread t2 = new Thread(f);
        Thread t3 = new Thread(f);

        t1.setName("高优先级");
        t2.setName("低优先级");
        t3.setName("中优先级");

        t1.setPriority(6);
        t2.setPriority(5);
        t3.setPriority(7);

        t1.start();
        t2.start();
        t3.start();

    }




}
