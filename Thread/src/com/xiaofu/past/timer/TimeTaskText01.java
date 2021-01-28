package com.xiaofu.past.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 该程序用来实现定时器的基本功能
 * @author fmk
 * @date 2020/5/2
 **/
public class TimeTaskText01 {
    public static void main(String[] args) throws ParseException {
        // 创建一个定时器
        Timer task=new Timer();
        //这里采用匿名内部类的方式去写一个TimeTask
        SimpleDateFormat sim=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = sim.parse("2020/05/02 15:19:10");
        task.schedule(new TimerTask() {
            @Override
            public void run() {
                int i=1;
                Date date=new Date();
                SimpleDateFormat sf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String time = sf.format(date);
                System.out.println(time+"保存了"+(++i)+"次数据");

            }
        },date,1000*10);
    }

}
