package com.xiaofu.exer;

/**
 * 银行 有一 个账户。
 * 有两个储户存 分别向同一个账户存3000 元，存 每次存1000，3次次 。每次存完打
 * 印账户余额。
 * 问题：该程序是否有安全问题，如果有，如何解决？
 * 有线程安全问题，首先多个储户共享了同一个账户，同时还对该账户进行操作，这样一定会存在线程安全问题
 */
class Account{
    private double balance = 0;
    // 加上同步锁
    public synchronized void saveMoney() {
        for (int i = 1; i <=3 ; i++) {
            balance+=1000;
            System.out.println(Thread.currentThread().getName()+"第"+i+"次"+"开始存钱,余额为:"+balance);
        }
    }
}


class Customer implements Runnable{
    private Account account = new Account();
    @Override
    public void run() {
        account.saveMoney();
    }
}



public class Text02 {
    public static void main(String[] args) {
        Customer customer = new Customer();

        Thread t1 = new Thread(customer);
        Thread t2 = new Thread(customer);

        t1.setName("顾客A");
        t2.setName("顾客B");

        t1.start();
        t2.start();

    }
}
