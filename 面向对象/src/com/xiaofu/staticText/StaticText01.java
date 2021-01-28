package com.xiaofu.staticText;

/**
 * 该程序用来测试static关键字的用法
 * 1.static是静态的,可以修饰变量和方法
 * 2.被static修饰的变量叫做静态变量，静态变量是保存在方法区中，在类加载的时候被初始化，使用类名.去调用
 * 无论用该类去创建多少个对象，静态变量只有一个
 * 3.被static修饰的方法叫做静态方法，静态方法与对象无关，可以使用类名.去调用，也可以使用引用.去调用，但是静态方法的调用
 * 与对象无关
 * 4.静态方法覆盖没有意义，因为方法的覆盖和多态机制是联合的，静态方法的调用与对象无关，所以也就不存在方法的覆盖
 * 5.静态方法中不能直接访问实例变量，也不能使用this或者super关键字
 * 6.static 和 final 修饰的变量叫做常量，常量一般都大写，常量是不会改变的
 * @author fmk
 * @date 2020/5/3
 **/
public class StaticText01 {
    // 这是一个静态变量，该变量保存在方法区内存中
    // 可以通过类名.的方式去访问该静态变量
    static int i=10;
    public static void main(String[] args) {
        // 可以在类名中进行访问
        System.out.println(i);
        // System.out.println(this);
        // System.out.println(super);
        // 这里使用了多态，父类型引用指向子类型对象
        Animal a=new Cat();
        // 但是静态方法的调用和对象无关，所以这里的move方法还是Animal类中的
        a.move();
        // 不能调用eat()方法，因为私有的方法只能在本类中访问，那么私有方法重写没有意义，不能和多态联合在一起使用
        // a.eat();
    }

}
class Animal{
    public static void move(){
        System.out.println("动物在移动");
    }
    //这是一个静态方法
    private void eat(){
        System.out.println("动物在吃东西");
    }

}

class Cat extends Animal{
    // 这里重写了父类中的静态方法，但是没有意义
    public static void move(){
        System.out.println("猫在走猫步");
    }
    //这里同样重写了该静态方法
    private void eat(){
        System.out.println("猫在吃猫食");
    }

}