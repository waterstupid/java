package com.xiaofu.abstractText;

/**
 * 该程序用来测验抽象类中的一些基础语法
 * 1.抽象类的定义：【修饰符列表】 abstract class 类名{} 把类和类之间的共同特征在进行抽象，这时候就变成
 * 了抽象类
 * 2.抽象类不能实例化，因为类是不存在的
 * 3.final 和 abstract 不能一起使用
 * 4.抽象类的功能是用来被继承的
 * 5.抽象类中可以出现抽象方法，实例方法，静态方法，变量，常量
 * 6.抽象方法必须出现在抽象类中
 * 7.抽象类的子类可以是类也可以是抽象类
 * 8.抽象类的子类如果不是抽线类的话，就要重写抽象类中的抽象方法
 *
 * @author fmk
 * @date 2020/5/5
 **/
public class AbstractText01 {

}
// 定义一个抽象类
abstract class Animal{
    // 定义一个实例变量
    int i;
    // 定义一个静态变量
    static String name;
    // 定义一个常量
    private static final String country="中国";
    // 定义一个静态方法
    public static void doSome(){

    }
    // 定义一个实例方法
    public void doOther(){

    }
    // 定义一个抽象方法
    // 抽象方法不能有方法体
    public abstract void eat();

    // 抽象方法中不能省略抽象方法的主体 void put();

}
class Cat extends Animal{
    // 需要覆盖抽象类中抽象方法
    @Override
    public void eat() {

    }
}
