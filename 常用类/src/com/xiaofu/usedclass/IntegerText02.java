package com.xiaofu.usedclass;

/**
 * 该案例用来测试String int Integer之间相互转换

 * @author fmk
 * @date 2020/5/9
 **/
public class IntegerText02 {
    public static void main(String[] args) {
        // String ---> int
        // Integer.parseInt()
        int i = Integer.parseInt("123");
        System.out.println(i);
        // int ----> String
        // String.valueOf()
        System.out.println(String.valueOf(123));

        // Integer ---> int
        // 自动拆箱或者拆箱
        // int intValue()
        System.out.println(new Integer(123).intValue());
        // int ----> Integer
        // 自动装箱或者拆箱
        // Integer.valueOf()
        System.out.println(Integer.valueOf(123));

        // Integer ---> String
        // String.valueOf()
        System.out.println(String.valueOf(new Integer(123)));
        // String ---> Integer
        // Integer.valueOf()
        System.out.println(Integer.valueOf("123"));

    }
}
