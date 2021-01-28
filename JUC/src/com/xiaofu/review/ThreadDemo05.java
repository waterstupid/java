package com.xiaofu.review;
class Count{
    private int count = 0;

    public synchronized void produce() throws InterruptedException {
        while(count != 0){
            wait();
        }
        count++;
        System.out.println(Thread.currentThread().getName()+"\t 开始生产，目前产品为"+count);
        notifyAll();
    }
    public synchronized void consumer() throws InterruptedException {
        // 这里不能使用if,防止虚假唤醒
        while(count == 0){
            wait();
        }
        System.out.println(Thread.currentThread().getName()+"\t 开始消费，消费产品"+count--);
        notifyAll();
    }

}
public class ThreadDemo05 {
    public static void main(String[] args) {
        Count count = new Count();
        new Thread(()->{
            try {
                while (true){
                    count.produce();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产者").start();
        new Thread(()->{
            try {
                while (true){
                    count.consumer();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费者").start();




    }
}
