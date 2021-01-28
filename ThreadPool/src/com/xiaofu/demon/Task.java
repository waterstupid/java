package com.xiaofu.demon;

/**
 * 这是一个"任务"线程
 * @author fmk
 * @date 2020/5/14
 **/
public class Task implements Runnable{
    private int number;
    public Task(int number){
        this.number=number;
    }
    @Override
    public void run() {
        // 这是run()方法
        String name = Thread.currentThread().getName();
        System.out.println("线程"+name+"开始执行:"+number);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+name+"执行结束:"+number);

    }

    @Override
    public String toString() {
        return "Task{" +
                "number=" + number +
                '}';
    }
}
