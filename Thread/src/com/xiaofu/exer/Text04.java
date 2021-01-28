package com.xiaofu.exer;

/**
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 */
class Clerk{
    // 产品数量
    private int count = 0;

    public synchronized void produceCount() {
        if(count <= 20 ){
            count++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产者开始生产产品,目前生产了"+count+"个产品");
            notifyAll();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void consumeCount() {
        if(count > 0){
            count--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费者开始消费产品,目前产品还剩余"+count+"个产品");
            notifyAll();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Produce implements Runnable{
    private Clerk clerk;

    public Produce(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while(true){
            clerk.produceCount();
        }
    }
}

class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk  = clerk;
    }

    @Override
    public void run() {
        while(true){
            clerk.consumeCount();
        }
    }
}




public class Text04 {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Produce produce = new Produce(clerk);
        Consumer consumer = new Consumer(clerk);

        Thread t1 = new Thread(produce);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();




    }
}
