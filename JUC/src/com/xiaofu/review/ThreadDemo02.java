package com.xiaofu.review;

import javax.xml.stream.events.StartDocument;
import java.nio.channels.NotYetBoundException;

class Print03{
    public synchronized void print01(){
        for (int i = 1; i <=52 ; i++) {
            notify();
            System.out.println(Thread.currentThread().getName()+"\t->"+i);
            if(i % 2 == 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public synchronized void print02(){
        // A 的 ascii码指为65 所以这里要进行一个编码
        for (int i = 65; i <91 ; i++) {
            notify();
            System.out.println(Thread.currentThread().getName()+"\t->"+(char)i);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadDemo02 {
    public static void main(String[] args) {
        Print03 print = new Print03();
        new Thread(()->{print.print01();},"A").start();
        try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
        new Thread(()->{print.print02();},"B").start();


    }
}
