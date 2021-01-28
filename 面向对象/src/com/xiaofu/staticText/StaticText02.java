package com.xiaofu.staticText;

/**
 * 该程序用来测试静态语句块
 * @author fmk
 * @date 2020/5/3
 **/
public class StaticText02 {
    // 这是一个静态语句块
    // 可以在类加载的时候执行其中的代码块
    // 可以使用静态变量，但是不能使用实例变量
    // 如果有多个静态语句块，执行的顺序由上到下
    static int a=50;
    String name=null;
    static{
        System.out.println("A");
        System.out.println(a);
        // System.out.println(name);
    }
    static{
        System.out.println("B");
    }

    public static void main(String[] args) {
        int i=10;
        System.out.println(i);
    }
    static{
        System.out.println("C");
    }
}
