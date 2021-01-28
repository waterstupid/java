package com.xiaofu.text;

/**
 * 该程序用来证明java中变量传递的值都是"值传递"
 * @author fmk
 * @date 2020/5/3
 **/
public class TransmitText01 {
    public static void main(String[] args) {
        int i=10;
        doSome(i);
        // 问题：主方法输出的i和doSome()方法中输出的i相同吗？
        // 不同，因为i是局部变量，作用域范围只在声明变量的方法中，这两个变量互不影响
        System.out.println("main方法中i---->"+ i); // 10
    }
    public static void doSome(int i){
        i++;
        System.out.println("doSome方法中i--->"+i);// 11
    }
}
