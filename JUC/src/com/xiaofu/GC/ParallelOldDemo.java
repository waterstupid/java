package com.xiaofu.GC;

public class ParallelOldDemo {
    // Serial Old 是在老年代使用的一种垃圾回收器，但是这种垃圾回收器已经过时了
    // Parallel Old 也是在老年代使用的一种垃圾回收器，老年代开启Parallel Old
    // 新生代会自动开启Parallel GC

    public static void main(String[] args) {
        byte [] b = new byte[ 20 * 1024 * 1024];


    }
}
