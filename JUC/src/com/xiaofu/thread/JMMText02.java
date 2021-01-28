package com.xiaofu.thread;
class MyCount{
    // 使线程修改该变量可以被其他线程所看到
    int count = 10;
    public void updateCount(){
        this.count = 30;
    }

}
public class JMMText02 {
    public static void main(String[] args) {
        MyCount count = new MyCount();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"**开始");
            // 让当前线程睡眠1秒
            //try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            count.updateCount();
            System.out.println(Thread.currentThread().getName()+"**结束");

        },"A").start();
        try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}

        new Thread(()->{
            System.out.println(count.count);
            while (count.count == 10){

            }
            System.out.println(Thread.currentThread().getName()+":update new value"+count.count);

        },"B").start();





    }


}
