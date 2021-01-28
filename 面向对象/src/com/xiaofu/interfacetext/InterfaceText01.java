package com.xiaofu.interfacetext;

/**
 * 该程序用来测验接口在开发中的运用
 * 一:接口的基本语法
 * 1.接口是一种引用数据类型
 * 2.接口的定义：[修饰符列表] interface 接口名{}
 * 3.接口中只能出现常量和抽象方法
 * 4.接口支持多继承
 * 5.接口中的实现类如果不是抽象类，那么实现类就要重写接口中的抽象方法
 * 6.public static final 和 public abstract 都可以省略
 * 7.抽象类是半抽象的，而接口是完全抽象的，接口可以看作是特殊的抽象类
 * 8.接口不能实例化
 * 二：接口在实际开发中运用
 * 接口一般和多态一起联用，可以降低程序的耦合度，提高程序的扩展性，我们要面向接口编程，因为
 * 接口是可插拔的，面向接口编程就是为了降低接口的实现者和调用者之间的耦合度
 * @author fmk
 * @date 2020/5/6
 **/
public class InterfaceText01 {
    public static void main(String[] args) {
        Meau mea=new ChineseCooker();
        // 这里使用了多态
        Customer customer=new Customer(mea);
        mea.makeFood();




    }
}
