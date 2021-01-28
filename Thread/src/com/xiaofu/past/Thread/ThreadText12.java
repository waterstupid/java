package com.xiaofu.past.Thread;

/**
 * 该程序用来测试消费者和生产者模式
 * @author fmk
 * @date 2020/5/2
 **/
public class ThreadText12 {
    public static void main(String[] args) {
        BaoZI baozi=new BaoZI("肉包",5);
        Thread t1=new Thread(new Customer(baozi));
        Thread t2=new Thread(new Boss(baozi));
        t1.setName("顾客");
        t2.setName("老板");
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();



    }
}

class Customer implements Runnable{
    BaoZI baozi;
    public Customer(BaoZI baozi){
        this.baozi=baozi;
    }

    @Override
    public void run() {
        synchronized (baozi){
            while(true){
                if(baozi.getCount()==0){
                    //叫老板开始生产包子
                    System.out.println("老板包子没有了，快点生产");
                    try {
                        baozi.notifyAll();
                        Thread.sleep(1000);
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    //如果包子不为0，则将包子吃掉
                    System.out.println(Thread.currentThread().getName()+"包子真好吃");
                    baozi.setCount(0);
                }
            }
        }
    }
}

class Boss implements Runnable{
    BaoZI baozi;

    public Boss(BaoZI baozi){
        this.baozi=baozi;
    }

    @Override
    public void run() {
        synchronized(baozi){
            while(true){
                if(baozi.getCount()==0){
                    //这个时候应该生产包子，一次生产5个
                    System.out.println(Thread.currentThread().getName()+"好嘞，正在做包子，请稍后");
                    System.out.println("===============");
                    baozi.setCount(5);
                    //然后再沉睡
                    try {
                        baozi.notifyAll();
                        Thread.sleep(1000);
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

class BaoZI{
    private String name;
    private int count;
    public BaoZI(String name,int count){
        this.name=name;
        this.count=count;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setCount(int count){
        this.count=count;
    }
    public int getCount(){
        return this.count;
    }

}