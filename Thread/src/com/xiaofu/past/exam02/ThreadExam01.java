package com.xiaofu.past.exam02;

/**
 * 问题：doOther()方法的执行会等待doSome()方法的执行吗？
 * 会，因为doSome()方法加上synchronized关键字，两个线程又共享了同一个对象，所以需要等待
 * @author fmk
 * @date 2020/5/2
 **/
public class ThreadExam01 {
    public static void main(String[] args) {
        MyClass myClass=new MyClass("zs");
        Thread t1=new Thread(new Runnable01(myClass));
        Thread t2=new Thread(new Runnable01(myClass));
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}

class Runnable01 implements Runnable{
    MyClass myclass;
    public Runnable01(MyClass myclass){
        this.myclass=myclass;
    }
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("t1")){
            myclass.doSome();
        }else{
            myclass.doOther();
        }

    }
}

class MyClass{
    private String name;
    public MyClass(String name){
        this.name=name;
    }
    public synchronized void doSome(){
        System.out.println("doSome begin....");
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome end........");
    }
    public synchronized void doOther(){
        System.out.println("doOther begin...");
        System.out.println("doOther end...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}