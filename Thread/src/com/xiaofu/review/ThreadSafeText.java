package com.xiaofu.review;

/**
 * 该例子用来说明线程安全问题
 * 由于多个线程共享同一个数据,并且对该共享数据进行操作,那么就会出现线程安全的问题。
 * 像在这个例子中,并且会出现重票和错票的概率
 */
public class ThreadSafeText {
    public static void main(String[] args) {
        StationA sa = new StationA();
        // 创建3个线程
        Thread t1 =new Thread(sa);
        Thread t2 =new Thread(sa);
        Thread t3 =new Thread(sa);
        t1.setName("A站台");
        t2.setName("B站台");
        t3.setName("C站台");
        // 开启线程
        t1.start();
        t2.start();
        t3.start();




    }


}

class StationA implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while(true){
            if(ticket > 0 ){

                System.out.println(Thread.currentThread().getName()+",票号:"+ticket);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket--;
            }else {
                break;
            }
        }


    }
}

