package com.xiaofu.review;

/**
 * 该类还是用来研究wait()方法
 */
class MyRunnable04 implements Runnable{
    private int i = 100;
    private Object object = new Object();
    @Override
    public void run() {
        // 如果这里监视器为object对象
        synchronized (object){
            for (int j = 0; j <i ; j++) {
                // 那么这里也要用object来调用,否则会出现异常
                object.notify();
                System.out.println(Thread.currentThread().getName()+"--->"+j);
                try {
                    // wait()方法和notify()方法的调用者必须和synchronized()中监视器中的
                    // 锁对象一致
                    // 要不然就会发生异常
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

public class ThreadConnectionText02 {
    public static void main(String[] args) {
        MyRunnable04 r = new MyRunnable04();

        Thread t1 =new Thread(r);
        Thread t2 =new Thread(r);

        t1.setName("主线程");
        t2.setName("副线程");
        t1.start();
        t2.start();

    }


}
