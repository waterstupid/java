package com.xiaofu.review;

import javax.xml.stream.events.StartDocument;
import java.awt.print.PrinterGraphics;

class Print01{
    private int count = 100;
    public synchronized void print01() throws InterruptedException {
        for (int i = 0; i <count ; i++) {
            if(i % 2 == 0){
                notify();
                System.out.println(Thread.currentThread().getName()+"\t->"+i);
                wait();
            }
        }
    }
    public synchronized void print02() throws InterruptedException {
        for (int i = 0; i <count ; i++) {
            if(i % 2 != 0){
                notify();
                System.out.println(Thread.currentThread().getName()+"\t->"+i);
                wait();
            }
        }
    }

}
public class ThreadDemo {
    public static void main(String[] args) {
        Print01 print = new Print01();
        new Thread(()->{
            try {
                print.print01();
                try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                print.print02();
                try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();

    }



}
