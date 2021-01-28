package com.xiaofu.review;

public class ThreadSafeSolutionText02 {
    public static void main(String[] args) {
        Thread t1 = new A();
        Thread t2 = new A();
        Thread t3 = new A();
        // 开启线程
        t1.start();
        t2.start();
        t3.start();


    }

}

class A extends Thread{
    private static int ticket=100;
    @Override
    public void run() {
        while(true){
          sellTicket();
        }
    }
    // 注意:在这里使用synchronized不能生效，因为synchronized修饰的实例方法默认采用
    // 的锁对象是this,但是这里创建了三个Thread对象,所以每个this对象都不一样，这里还是会出现
    // 线程安全的问题
    // 所以这里要加上static
    private static synchronized void sellTicket(){
        if(ticket > 0){
            System.out.println(Thread.currentThread().getName()+",票号:"+ticket);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket--;
        }
    }
}
