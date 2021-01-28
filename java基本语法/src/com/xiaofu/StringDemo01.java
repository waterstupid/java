package com.xiaofu;

public class StringDemo01 {
    public static void main(String[] args) {
        // 创建一个对象,就是在常量池中
        /*String s = "ab";
        String s1 = "ab";*/
        /*String s = new String("ab");
        String s1 = new String("ab");
        System.out.println(s==s1);*/
        // String s = "a"+"b";
        // String s = new String("a")+new String("b");
        // 注意:在进行字符串拼接的时候，只有有一方是new String()的格式，
        // 那么在底层就会创建StringBuilder()对象，然后利用它的append()方法完成拼接
        String s = "a"+new String("b");

    }
}
