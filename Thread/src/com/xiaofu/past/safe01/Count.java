package com.xiaofu.past.safe01;

/**
 * 该类是一个银行账户类，用来测试线程安全问题
 * @author fmk
 * @date 2020/5/2
 **/
public class Count {
    private String name;
    private double balance;
    Object obj=new Object();

    /**
     * 这是一个转账方法
     * @param money
     *
     */
    // 同样synchronized关键字也可以加在方法上，锁住的只能是this对象，同步代码块是整个方法体
    // 这种方式不够灵活，且有时候效率较低
    // 但是只有一个优点，代码简单
    public synchronized void transfer(double money){
            double before=this.balance;
            double after=this.balance-money;
            //更新账户的余额
            setBalance(after);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Count() {
    }

    public Count(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
}
