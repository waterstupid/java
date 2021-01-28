package com.xiaofu.xunhuan;


import java.util.Scanner;

/**
 * java中的所有控制语句
 * 1.if..else
 * 2.if..else if...else if...else
 * 3.for
 * 4.switch
 * 5.break
 * 6.continue
 * 7.return
 *
 * 在这里只使用switch语句做演示
 *
 *
 *
 *
 *
 *
 */
public class Cycle {
    // 被final修饰的变量不能采用系统默认值
    private static final String NAME = "zhangsan";


    public static void main(String[] args) {

        /**
         * 首先我们要知道switch也是一个控制语句
         * 在java 5 之前，switch只支持byte,short,int,char,严格来说，只支持int,支持
         * 其他类型是因为它们都可以自动转换为int类型,在 java 5之后,java引入了枚举类型，
         * 于是就支持枚举类型，在java 7 之后，switch就开始支持String类型的数据,但是对于
         * long类型的数据，switch是一直不支持的
         */
        int grade = 100;
        switch (grade){
            case 100:
                System.out.println("你的成绩很好");
                break;
            case 60:
                System.out.println("你的成绩刚刚合格");
            case 50:
                System.out.println("对不起,你的成绩不合格");
        }
        long count = 35432543l;
        /*
        switch不支持long类型的数据
        switch (count){
        }
        */
        String name = "小明";
        // switch语句支持String类型的数据
        switch (name){
            case "小明":
                System.out.println("我是小明");
                break;
            case "张三":
                System.out.println("我是张三");
                break;
        }

        // switch语句支持枚举类型
        Festival festival = Festival.SPRING;
        switch (festival){
            case SPRING:
                System.out.println("现在是春天");
                break;
            case SUMMER:
                System.out.println("现在是夏天");
            case AUTUMN:
                System.out.println("现在是秋天");
            case WINTER:
                System.out.println("现在是冬天");
        }

        // 有关于 break 的使用
        // first代表第一个for循环
        first:
        for (int i=0 ;i < 10;i++){
            for (int j= 0 ;j < 5;j++){
                if (i == 2){
                    // 跳出第一个大循环
                    break first;
                }
                System.out.println(j);
            }
            System.out.println("----------------------");
        }
        // 接收键盘输入
        // in变量是System中的静态变量,也就是InputStream定义的一个变量
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        System.out.println("键盘输入="+value);


    }






}
