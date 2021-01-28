package com.xiaofu.review;



/**
 * 有关线程安全的问题需要解决，首先要明白一个问题，为什么会有线程安全问题？
 * 1.因为多个线程在共享同一个对象，并且对该对象进行操作的时候，一个线程在执行多条语句的时候，
 * 这个时候cpu分配的时间片用完了，该线程从运行状态变为就绪状态，然后这个时候，其他线程又抢占
 * 到了cpu的执行权，对该数据进行操作，那么这个时候就会出现线程数据不安全的问题
 * 关键点:多线程，共享对象，修改对象中的内容
 *
 * 2.那么我们怎么解决线程安全的问题呢？
 * 解决办法:只需要让在一个线程在执行的时候，其他线程需要等待，等待该线程执行完毕之后，其他线程
 * 才能开始执行
 * java中使用(同步进制)同步代码块或者同步方法
 * 同步代码块：
 * synchronized(锁){
 *   语句
 * }
 * 监视器可以是任意类的对象，但是该对象必须要是多个线程共享的
 * 同步方法:
 * 2.在synchronized修饰方法的时候，默认的监视器是this,也就是当前对象
 * 注意:当前类也可以作为监视器，也就是类名.class
 *
 * 3.同步方法和同步代码块异同？
 * 相同点:两者都可以解决线程安全的问题，实现线程同步
 * 不同点:
 * 1.同步方法的默认锁对象是this或者当前类对象，但是同步方法的锁可以是任意类的对象，
 * 比较灵活，只要这个对象是多线程共享的就行
 * 2.同步方法同步的是整个方法,而同步代码块可以选择性的将一些逻辑代码进行同步，解决线索安全问题
 *
 * 4.java中监视器的同步机制
 * 在java中，每个Object(对象和类)都会逻辑关联一个监视器，为了要实现现监视器互斥机制，每个对象又有一个对应的锁，当
 * synchronized修饰方法或者代码块的时候，这部分代码就会放入监视器的监察范围，线程如果要访问这些代码，必须要获取锁对象，
 * 线程再没有获取锁对象之前不能执行这部分代码,java中提供显示锁(lock)机制，和隐示锁(synchronized)机制
 *
 *
 */
public class ThreadSafeSolutionText {
    public static void main(String[] args) {
        StationC sa = new StationC();
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


class StationC implements Runnable{
        private int ticket = 100;
        private Object object = new Object();
        @Override
        public void run() {
            while(true){
                synchronized(StationC.class){
                    if(ticket > 0 ){
                        System.out.println(Thread.currentThread().getName()+",票号:"+ticket);
                       /* try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                        ticket--;
                    }else {
                        break;
                    }
                }
            }
        }
    }
