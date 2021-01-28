package com.xiaofu.GC;

public class ParallelGCDemo {
    // 并行/并行回收
    // ParNew 和 Parallel 收集器的区别就在于 ParNew会自动让老年代使用Serial Old 收集器
    // 而Parallel 收集器 会让老年代使用Parallel Old 收集器
    public static void main(String[] args) {
        byte [] b = new byte[20 * 1024 *1024];




    }
}
