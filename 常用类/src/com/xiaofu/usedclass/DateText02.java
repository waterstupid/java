package com.xiaofu.usedclass;

/**
 * 该案列用来测试一个方法的执行时间
 * @author fmk
 * @date 2020/5/9
 **/
public class DateText02 {
    public static void main(String[] args) {
        // 获取当前系统时间距离1970年的毫秒数
        long start = System.currentTimeMillis();
        doSome();
        // 获取当前系统时间距离1970年的毫秒数
        long end = System.currentTimeMillis();
        System.out.println("方法执行的时间是"+(end-start)+"毫秒");
    }
    public static void doSome(){
        for (int i=0;i<10000000;i++){
        }
    }
}
