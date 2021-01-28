package com.xiaofu.usedclass;

import java.util.Random;

/**
 * 该案例用来测试Random中的方法
 * @author fmk
 * @date 2020/5/9
 **/
public class RandomText01 {
    public static void main(String[] args) {
        Random ra=new Random();
        // 该方法可以随机生成一个随机数
        // nextInt()
        System.out.println(ra.nextInt());
        // nextInt(int bound) 这个方法可以随机在指定的方范围内生成随机数
        System.out.println(ra.nextInt(5));


    }
}
