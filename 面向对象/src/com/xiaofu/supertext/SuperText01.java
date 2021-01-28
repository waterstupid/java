package com.xiaofu.supertext;

/**
 * 该程序用来检验super关键字的使用
 * 1.super是代表父类型中的特征
 * 2.super是this的一部分呢
 * 3.super(参数)可以调用父类的构造方法
 * 4.super.属性/方法 可以调用父类中的属性和方法
 * 5.super不能出现在静态方法中，只能出现在实例方法中
 * 6.super大部分都可以省略，但是如果子类和父类有相同的方法或者属性，这个时候要访问父类中的
 * 同名属性和方法，super就不能省略
 * 7.在构造方法中,super()可以出现在构造方法的第一行，来调用父类的无参构造，但是不能和this()一起出现
 * ，如果在一个构造方法中，没有出现this(形参)和super(形参)，那么系统会默认写上super()
 * @author fmk
 * @date 2020/5/5
 **/
public class SuperText01 {
    public static void main(String[] args) {
        // 父类型引用指向子类对象，多态
        Animal a=new Cat();
        a.doOther();

    }

}
class Animal{
    public Animal(){
        System.out.println("Animal 的无参构造执行....");
    }
    public void doSome(){
        System.out.println("do some......");
    }
    public void doOther(){

    }
}
class Cat extends Animal{
    // 这里会调用父类的无参构造
    public Cat(){
        System.out.println("Cat 的无参构造执行.....");
    }

    public void doOther() {
        // 三个执行结果都一样，因为在这里Cat没有重写doSome()方法，所以无论是this,还是
        // super都是调用的同一个方法
        this.doSome();
        super.doSome();
        doSome();
    }
}
