package com.xiaofu.demon;

/**
 * @author fmk
 * @date 2020/5/14
 **/
public class Text {
    public static void main(String[] args) {
        // 创建线程池
        ThreadPool threadPool=new ThreadPool(2,4,20);
        for (int i = 0; i < 20 ; i++) {
            Task task=new Task(i);
            threadPool.submit(task);
        }





    }
}
