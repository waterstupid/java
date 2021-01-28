package com.xiaofu.thread;
// 注意这个注解:当接口中只有一个抽象方法的时候，这个注解会自动加入
@FunctionalInterface
interface Animal{
    // void sayHello();
    // 如果有两个抽象方法，这个注解就会报错
    // void fly();
    // 但如果接口中的抽象方法为default修饰的话
    // @FunctionalInterface就不会报错
    default void fly(){
        System.out.println("我可以飞翔");
    }
    // 同样接口中声明静态方法的时候也不会报错
    static void doSome(){
        System.out.println("do Some 执行");
    }
    // 注意:使用default修饰的方法和static的静态方法可以声明多个,@FunctionalInterface也不会报错
    default void fly1(){

    }
    static void doOther(){

    }
    // 如果接口中的方法有参数和返回值，同样是可以使用lambda表达式
    int add(int x,int y);

}

/**
 * 总结一下lambda(函数表达式)的用法:
 * () ->{};
 * 使用条件:
 * 1.接口中只能有一个没有方法体的抽象方法,有两个就不支持
 * 2.当接口中默认有一个抽象方法的时候,会自动在接口上面添加一个注解@FunctionalInterface
 *
 *
 *
 *
 */
public class Text03 {
    public static void main(String [] args){
        // 采用lambda表达式的方式来输出
        // Animal animal =()->{ System.out.println("hello world");};
        Animal animal = (int x,int y)->{System.out.println("add方法开始运行"); return x+y;};
        System.out.println(animal.add(10, 20));
    }





}
