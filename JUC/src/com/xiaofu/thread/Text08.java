package com.xiaofu.thread;

/**
 * 如果没有设置虚拟机的堆内存，那么就会使用默认值
 * 堆内存的起始值为实际物理内存的1/64
 * 堆内存最大占用为实际物理内存的额1/4
 * 但在开发中一般将堆内存的初始值和最大值设置为一样，这样是为了防止内存忽高忽低
 *
 *
 */
public class Text08 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.getClass());
        // 返回cpu的核数
        int count = runtime.availableProcessors();
        // JVM堆内存中可用的最大容量
        long maxMemory = runtime.maxMemory();
        // JVM堆内存的初始容量
        long totalMemory = runtime.totalMemory();
        System.out.println(maxMemory/1024/1024);
        System.out.println(totalMemory/1024/1024);
        System.out.println("-Xms:"+totalMemory);


    }
}
