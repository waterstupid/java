package com.xiaofu.usedclass;

/**
 * 除八种基本数据类型之外，java中还准备与之对应的包装类型
 * byte                         Byte
 * short                        Short
 * int                          Integer
 * long                         Long
 * double                       Double
 * float                        Float
*  boolean                      Boolean
 * char                         Character
 * 2.为什么会有8种包装类型？
 * 因为在java中，8中基本类型不够用，举个列子，比如有有个方法的形参是Object类型，如果我们想要将
 * 数字作为实参传入该方法中，如果没有包装类型，那么这个功能就不能实现，因为数字都是基本数据类型，
 * 而基本数据类型没有父类，所以这个时候就要使用包装类
 * 3.装箱和拆箱
 * 装箱：基本数据类型转向包装类
 * 拆箱：包装类转向基本数据类型
 * 4.在JDK 1.5之后出现了自动装箱和自动拆箱，大大方便了我们的编程
 * @author fmk
 * @date 2020/5/9
 **/
public class IntegerText01 {
    public static void main(String[] args) {
        // 这里使用到了自动装箱
        doSome(1);
        // 这里也使用到了自动装箱
        Integer i=100;
        // 这里使用了自动拆箱
        int a=i;
        // Integer中有几个常用的构造方法
        Integer a1=new Integer(123);// 形参可以传一个数字
        System.out.println(a1);
        // 形参同样可以传一个字符串
        System.out.println(new Integer("123"));
        // 但是如果形参传入的字符串不是一个数字，那么就会报异常，叫做NumberFormatException
        System.out.println(new Integer("abc"));

    }
    // 如果我们想要传递一个数字，那么我们就要用到装箱
    public static void doSome(Object obj){
        System.out.println(obj);
    }



}
