package com.xiaofu.threadconnectReview;

/**
 * 该类用来复习线程之间的通信，有三种方式:
 * 1.Synchronized wait() notify() notifyAll()
 * 2.ReentrantLock await() signal()
 * 3.BlockingQueue 阻塞队列
 *
 * 在使用线程之间通信的时候，要特别注意一点，判断条件的时候不能使用if来判断，要使用while来判断条件，防止虚假唤醒
 * 那么什么是虚假唤醒，这里举个例子，就用最常用的生产者消费者的例子来举例
 * 假如有三个生产者，三个消费者，生产者分别记为生产者1、2、3,消费者分别记为消费者1、2、3
 * 生产者如何开始工作:产品=0的情况下就开始工作,这里使用if来判断
 * 消费者如何开是工作:产品!=0的情况下开始工作，这里也使用if来判断
 * 注意:使用if来判断是会有虚假唤醒的风险的,下面来分析为什么会有虚假唤醒的风险
 * 首先
 * 消费者1开始工作，此时产品=0，wait
 * 消费者2开始工作，此时产品=0，wait
 * 消费者3开始工作，此时产品=0，wait
 *
 * 生产者1开始工作，此时产品=0，生产1
 * 消费者1被唤醒，此时产品=1，消费，产品=0
 *
 * 注意:接下来是关键，
 * 如果是消费者2被唤醒，那么此时产品确实=0，但是要注意一点，因为条件判断是使用if来判断的，所以这里不会重新
 * 去判断一次，而是直接消费，尽管现在的产品=0，这里就叫做虚假唤醒
 *
 *
 *
 *
 */
public class SynDemo {
    public static void main(String[] args) {
        Product product = new Product();
        // 三个生产者
        for(int i = 0; i<3;i++){
            new Thread(() ->{
                // 每个生产者生产10次
                for (int j = 0; j <10 ; j++) {
                    product.produce();
                }
            }, "生产者" + i).start();
        }
        // 三个消费者
        for(int i = 0; i<3;i++){
            new Thread(() ->{
                // 每个消费者消费10次
                for (int j = 0; j <10 ; j++) {
                    product.consume();
                }
            }, "消费者" + i).start();
        }



    }
}
class Product{
    private int number = 0;
    // 该方法用于生产
    public synchronized void produce(){
        System.out.println(Thread.currentThread().getName()+"->\t come in...");
        // 判断(if会存在虚假唤醒的问题)
        /*if(number != 0){
            // !=0 就等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        while(number != 0){
            // !=0 就等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 干活
        number++;
        System.out.println(Thread.currentThread().getName()+"->\t number="+number);
        // 唤醒
        notifyAll();
        System.out.println(Thread.currentThread().getName()+"->\t end...");
    }
    // 该方法用于消费
    public synchronized void consume(){
        System.out.println(Thread.currentThread().getName()+"->\t come in...");
        // 判断(虚假唤醒)
        /*if(number == 0){
            // !=0 就等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        // 使用while就不会虚假唤醒
        while(number == 0){
            // !=0 就等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 干活
        number--;
        System.out.println(Thread.currentThread().getName()+"->\t number="+number);
        // 唤醒
        notifyAll();
        System.out.println(Thread.currentThread().getName()+"->\t end...");
    }




}
