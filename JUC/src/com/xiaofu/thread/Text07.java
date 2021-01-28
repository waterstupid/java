package com.xiaofu.thread;

/**
 * 该程序用来演示OOM错误，并且JVM调优，设置堆内存的初始大小的最大占用内存,在实际开发中，
 * 一般将这两个值设置为一样，防止内存忽高忽低
 * -Xms:堆内存的初始容量
 * -Xmx:堆内存的最大容量
 */
public class Text07 {
    public static void main(String[] args) {
        byte [] b = new byte[40 *1024 *1024];

    }
}
