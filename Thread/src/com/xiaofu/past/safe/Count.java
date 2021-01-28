package com.xiaofu.past.safe;

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
    public void transfer(double money){
        // 这里如果线程并发就会出现问题，有可能在t1线程还没更新账户余额的时候
        // t2线程又进来对帐户进行操作了，这样就会出现问题，会出现数据不安全
        // 那么如何解决这个问题，采用线程同步机制，让线程排队执行
        // synchronized是一个锁，锁的对象必须得是线程共享的对象
        // t1线程如果遇到了synchronized关键字，首先会去"锁池"寻找"this"对象锁，如果找到了，就会将这个对象
        // 锁拿走，然后进入就绪状态，抢占cpu时间片，然后直到将同步代码块中的代码执行完毕，才会释放锁，如果没有找到，
        // 线程就会进入锁池等待，直到找到锁为止
        // 这里的this指的是count对象，也就是当前对象，synchronized(共享对象){},只要跟共享对象就行
        // synchronized(this)
        // synchronized(obj)也可以跟上obj对象，应为obj对象也是共享对象
        // synchronized(name) 甚至可以跟上name,因为name属性在共享对象中，也是线程所共享的
        // synchronized(new Double(balance)) 这样也行
        // 总结：只要是共享对象中有的实例变量，都可以加锁，因为实例变量也是共享的
        synchronized(new Double(balance)){
            double before=this.balance;
            double after=this.balance-money;
            //更新账户的余额
            setBalance(after);
        }


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
