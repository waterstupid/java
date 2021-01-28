package com.xiaofu.exer;

/**
 *银行 有一 个账户。
 *有两个储户存 分别向同一个账户存3000 元，存 每次存1000，3次次 。每次存完打
 *印账户余额。
 *拓展问题：可否实现两个储户交替存钱的操作
 * 可以,使用线程通信
 * 使用wait()和notify()方法就能完成线程之间的通信
 */

class Account01{
    private double balance;
    public synchronized void saveMoney(){
        for (int i = 1; i <= 3 ; i++) {
            // notify()是唤醒之前进入阻塞状态的线程,让其从阻塞状态重新回到就绪状态
            notify();
            balance+=1000;
            System.out.println(Thread.currentThread().getName()+"第"+i+"次"+"开始存钱,余额为:"+balance);
            // 每存一次休眠一次,使用wait()方法，释放当前锁
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Customer01 implements Runnable{
    private Account01 account;

    public Customer01(Account01 account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.saveMoney();
    }
}

class Customer02 implements Runnable{
    private Account01 account;

    public Customer02(Account01 account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.saveMoney();
    }
}



public class Text03 {
    public static void main(String [] args){
        Account01 account = new Account01();
        Customer01 c1 = new Customer01(account);
        Customer01 c2 = new Customer01(account);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.setName("顾客A");
        t2.setName("顾客B");

        t1.start();
        t2.start();

    }


}
