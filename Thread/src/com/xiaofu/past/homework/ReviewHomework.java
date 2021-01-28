package com.xiaofu.past.homework;

/**
 * 该程序用来复习一下线程安全问题
 * @author fmk
 * @date 2020/5/3
 **/
public class ReviewHomework {
    public static void main(String[] args) {
        Ticket1 ticket1=new Ticket1(100);
        Thread t1=new Thread(new Runnable02(ticket1));
        Thread t2=new Thread(new Runnable02(ticket1));
        t1.setName("售票窗口1");
        t2.setName("售票窗口2");
        t1.start();
        t2.start();
    }

}

class Runnable02 implements Runnable{
    Ticket1 ticket1;
    public Runnable02(Ticket1 ticket1){
        this.ticket1=ticket1;
    }
    @Override
    public void run() {
        while(true){
            //锁住共享对象
            synchronized(ticket1){
                ticket1.setAccount(ticket1.getAccount()-1);
                System.out.println(Thread.currentThread().getName()+"卖出一张票,还剩"
                        +ticket1.getAccount()+"张");
                if(ticket1.getAccount()==0){
                    System.out.println("票已经卖完了");
                    return;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

//这是一个共享对象
class Ticket1{
    private int account;
    public Ticket1(int account){
        this.account=account;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}