package com.xiaofu.threadconnectReview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 该类用来说明用阻塞队列来完成线程之间的通信:
 * 1.要理解阻塞队列其实其实要先理解什么是队列？
 * 队列就是一种简单的数据结构，就像我们排队一样，先进先出，后进后出，先来先得，
 * 后来后得，就是这样的一个简单数据结构
 * 2.Queue
 * Queue是一个接口，它的父接口是Collection,Queue又有一个子接口BlockingQueue，这个子接口
 * 的实现类才是我们要使用的阻塞队列！！！
 * 3.阻塞队列有什么用？
 * 阻塞队列可以让开发人员更加轻松，传统情况下要完成线程之间的通信，要开发人员来控制线程什么时候进入
 * 阻塞状态以及线程什么时候才能从阻塞状态中被唤醒，这种操作让开发人员会十分麻烦，有了阻塞队列之后，开发
 * 人员无需关注这些操作，让这些操作交给阻塞队列完成即可
 * 4.常用的阻塞队列
 * 1.ArrayBlockingQueue 底层是使用一个数组来实现队列的，构造方法需要初始化队列的长度
 * 2.LinkedBlockingQueue 底层是使用一个链表来实现队列的，容量理论上无限制
 * 3.synchronousQueue 阻塞队列不存储元素,每次队列只能有一个元素
 *
 * 5.常用方法
 * BlockingQueue的核心方法，为什么能控制线程的阻塞以及唤醒在于这两个核心方法
 * 1.boolean offer(T t,long time,TimeUnit timeUnit)
 * 该方法的意思就是往阻塞队列中添加数据，如果当前阻塞队列已满，则会让当前线程进入到阻塞状态，
 * 等到一段时间，如果这段时间队列中依然是满状态，那么就放弃往阻塞队列中添加元素，方法返回false
 *
 * 2.T poll(long time,TimeUnit timeUnit)
 * 该方法的意思就是检索队列的队首元素，然后删除并返回，如果当前队列为为空，则当前线程则会进入到阻塞状态
 * ，等待一段时间再来判断当前队列是否为空，如果为空，则返回null,如果不为空，则删除队首元素并返回
 *
 * 其他常用方法:
 * 1.抛异常
 * add(E element)
 * remove()
 * 这两个方法在容器不允许的情况下是会抛出异常的
 *
 * 2.返回false
 * offer(E element)
 * poll()
 * 这两个方法在容器不允许的情况下是会返回false
 *
 * 3.一直阻塞
 * put(E element)
 * take()
 * 这两个方法在容器不允许的情况下是会一直阻塞，直到容器为可用状态
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
        MyBlockIngQueue myQueue = new MyBlockIngQueue(queue);
        new Thread(()->{
            try {
                for (int i = 0; i <10 ; i++) {
                    myQueue.produce();
                    try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产者").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    myQueue.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者").start();
    }
}
class MyBlockIngQueue{
    private BlockingQueue<String> queue = null;
    private AtomicInteger atomic = new AtomicInteger();

    public MyBlockIngQueue(BlockingQueue<String> queue) {
        this.queue = queue;
    }
    public  void produce() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"->\t come in....");
        String value = ""+atomic.getAndIncrement();
        // 其实3s的时间足够其他消费者线程来消费的
        // 此处offer()的意思就是,如果阻塞队列已满，那么当前线程会从运行状态进入阻塞状态，等待3s的时间，如果者3s的时间
        // 内阻塞队列中还是满的，那么当前线程就会放弃添加，这个方法也会返回false
        if(queue.offer(value,3L, TimeUnit.SECONDS)){
            System.out.println(Thread.currentThread().getName()+"->\t 生产成功,product = "+atomic.get());
        }else{
            System.out.println(Thread.currentThread().getName()+"->\t 添加数据失败");
        }

    }
    public  void consume() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"->\t come in......");
        // 此处poll()方法的意思就是:检索当前队列的队首元素并从队列中删除，如果当前队列为空的话，则等候三秒钟，也就是
        // 线程进入阻塞状态，如果三秒种后队列中的元素还是为，那么该线程就会放弃添加元素，然后该方法返回Null
        String result = queue.poll(3L,TimeUnit.SECONDS);
        if(result != null){

            System.out.println(Thread.currentThread().getName()+"->\t 消费成功,product = "+atomic.decrementAndGet());
        }else{
            System.out.println("消费失败");
        }

    }

}
