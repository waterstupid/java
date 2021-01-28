package com.xiaofu.past.Thread;

/**
 * 该程序用来获取当前线程对象，获取线程的名称，和给线程起名
 * static Thread   currentThread()            获取当前线程的引用
 * String          getName()                  返回此线程的名称
*  void            setName(String name)       将此线程的名称更改为等于参数 name
 *
 * @author fmk
 * @date 2020/5/1
 **/
public class ThreadText05 {
    public static void main(String[] args) {
        //创建线程
        Thread t1=new Thread(new Runnable03());
        Thread t2=new Thread(new Runnable03());
        //给t线程赋名字
        t1.setName("t1");
        t2.setName("t2");
        //获取t线程的名字
        System.out.println(t1.getName());
        System.out.println(t2.getName());
        //调用方法,启动线程
        t1.start();
        t2.start();

    }
}

class Runnable03 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println(Thread.currentThread().getName()+"--->"+i);
        }

    }
}