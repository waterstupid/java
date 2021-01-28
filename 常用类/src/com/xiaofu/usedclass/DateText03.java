package com.xiaofu.usedclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该案例用来测试怎么获得昨天的时间
 * @author fmk
 * @date 2020/5/9
 **/
public class DateText03 {
    public static void main(String[] args) throws ParseException {
        long l = System.currentTimeMillis();
        Date lastDate=new Date(l-1000*60*60*24);
        System.out.println(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss SSS").format(lastDate));
        // 如何将一个字符串转换为日期
        String s="2019-02-05 09:20:20";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(s);
        System.out.println(date);


    }
}
