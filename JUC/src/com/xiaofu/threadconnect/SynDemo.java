package com.xiaofu.threadconnect;



class Product{
    private volatile int number = 0;
    public synchronized void produce() throws InterruptedException {
        // 判断
        // 使用while防止虚假唤醒
        while(number != 0){
            wait();
        }
        // 干活
        number++;
        System.out.println(Thread.currentThread().getName()+"\t生产"+number);
        try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        // 唤醒
        notify();
    }
    public synchronized void consume() throws InterruptedException {
         while(number == 0){
             wait();
         }
         // 干活
         System.out.println(Thread.currentThread().getName()+"\t消费"+number);
         number--;
         try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
         // 唤醒
         notifyAll();
    }




}
/**
 * 使用synchronized来完成线程之间的通信,也就是经典的消费者和生产者
 */
public class SynDemo {
    public static void main(String[] args) {
        Product product = new Product();
        // 两个生产者
        for(int i = 1; i<=2;i++){
            new Thread(() ->{
                try {
                    for (int j = 0; j <10 ; j++) {
                        // 生产10次
                        product.produce();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
        // 两个消费者
        for(int i = 1; i<=2;i++){
            new Thread(() ->{
                try {
                    for (int j = 0; j <10 ; j++) {
                        // 消费10次
                        product.consume();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }



    }
}
