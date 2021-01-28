package com.xiaofu.homework;

/**
 * 模拟3个人排队买票，每人买1张票。售货员只有1张五元的钱，电影票5元一张，
 * 王大拿拿一张二十元的人民币排在谢大脚前面买票，
 * 谢大脚拿1张十元的人民币排在在赵四的前面买票，赵四拿1张五元的人民币排在最后。
 * 即最终的卖票次序是：谢大脚、赵四、王大拿
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        SalePerson person = new SalePerson();
        new Thread(()->{person.sellTicket(10);},"谢大脚").start();
        new Thread(()->{person.sellTicket(5);},"造四").start();
        new Thread(()->{person.sellTicket(20);},"王大拿").start();

    }
}
class SalePerson{
    private int ticketPrice = 5; // 电影票的价格
    private int money = 5; // 售货员的钱

    public synchronized void sellTicket(int money){
        while (this.money + 5 - money != 0 && this.money+money != 15 ){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 刚好相等
        this.money += 5;
        notifyAll();
        System.out.println(Thread.currentThread().getName()+"-> \t买好了票");




    }





}
