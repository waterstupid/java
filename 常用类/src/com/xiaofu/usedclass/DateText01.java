package com.xiaofu.usedclass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该案列用来测试Date类中的常用方法
 * Date()
 * 分配一个 Date对象，并初始化它，以便它代表它被分配的时间，测量到最近的毫秒。
 * Date(long date)
 * 分配一个 Date对象，并将其初始化为表示自称为“时代”的标准基准时间以后的指定毫秒数，即1970年1月1日00:00:00 GMT。
 * @author fmk
 * @date 2020/5/9
 **/
public class DateText01 {
    public static void main(String[] args) {
        // 获取当前时间
        Date date=new Date();
        System.out.println(date);
        // 当然也可以将日期转换成我们想要的格式
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        // format(Date date) 可以将日期转换为指定的格式
        System.out.println(sdf.format(date));
        System.out.println("======================");
        // 同样在Date的构造方法中还有 new Date(long date)
        Date date1=new Date(1);
        System.out.println(date1);
        // 同样可以获取当前时间距离1970-1-1 00:00:00 的毫秒数
        // System.currentTimeMillis()
        long seconds = System.currentTimeMillis();
        System.out.println(seconds);
        // 可以将long类型的数据转换为Date类型的数据
        Date date2 = new Date(seconds);
        // yyyy-MM-dd HH:mm:ss
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date2);
        System.out.println("当前时间="+time);





    }
}
