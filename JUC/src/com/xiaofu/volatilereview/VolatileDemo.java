package com.xiaofu.volatilereview;
class MyData{
    int count = 20;
    public void sendCount(){
        this.count = 40;
    }

}
public class VolatileDemo {
    public static void main(String[] args) {
        MyData data = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t begin");
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            data.sendCount();
            System.out.println(Thread.currentThread().getName()+"\t end");
        ;},"A").start();
        while(data.count == 20){

        }
        System.out.println(Thread.currentThread().getName()+"\t update new value"+data.count);



    }
}
