package com.xiaofu.demon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author fmk
 * @date 2020/5/14
 **/
public class Worker extends Thread {
    private String name;
    private List<Runnable> tasks;
    public Worker(List<Runnable> tasks,String name){
        this.tasks=tasks;
        this.name=name;
    }
    @Override
    public void run() {
        // 将这个集合中的线程都执行
        while(tasks.size()>0){
            Runnable r = tasks.remove(0);
            r.run();
        }
    }
}
