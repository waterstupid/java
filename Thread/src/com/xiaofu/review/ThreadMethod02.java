package com.xiaofu.review;

/**
 * 该方法用来测试join()方法
 * join方法就是:如果在a线程中调用b.join()线程，那么a线程会等待b线程执行完毕之后再执行
 * 该方法不是静态方法,是Thread类中的方法
 */
public class ThreadMethod02 {
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
            for(int i = 1 ; i <= 100 ; i++){
                if(i % 2 == 0){
                    System.out.println(Thread.currentThread().getName()+"->"+i);
                }
            }
        }, "a");
        Thread b = new Thread(()->{
            try {
                // 在b线程中加入a.join(),意思就是等待a线程执行完毕之后b线程才开始执行
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 1 ; i <= 100; i++){
                if(i % 2 != 0){
                    System.out.println(Thread.currentThread().getName()+"->"+i);
                }
            }
        },"b线程");
        a.start();
        b.start();


    }



}
