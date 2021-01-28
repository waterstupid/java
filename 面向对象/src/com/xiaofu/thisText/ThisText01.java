package com.xiaofu.thisText;

/**
 * 该程序用来测试this关键字的用法
 * @author fmk
 * @date 2020/5/3
 **/
public class ThisText01 {
    public static void main(String[] args) {
        Customer c1=new Customer("张三");
        Customer c2=new Customer("李四");
        c1.shop();
        c2.shop();

    }
}
class Customer{
    // 实例变量
    String name;
    public Customer(String name){
        this.name=name;
    }
    // this代表当前对象
    // 哪个对象负责去调用这个方法，那么这个对象就是this
    // this是一个引用保存在堆内存中
    // this只能出现在实例方法中
    // this大部分时候都可以省略

    public void shop(){
        System.out.println(this.name+"正在去购物");
    }

}
