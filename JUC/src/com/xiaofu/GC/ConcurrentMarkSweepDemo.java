package com.xiaofu.GC;

public class ConcurrentMarkSweepDemo {
    public static void main(String[] args) {
        // CMS垃圾回收器是使用在老年代，使用的是标记清除算法，非常适合高并发的情况下
        // 开启之后，新生代会默认采用ParNew垃圾回收器
        byte [] b = new byte[ 20 * 1024 * 1024];
        /*int i=0;
        while(true){
            String s = new String((i++)+"");
        }*/


    }
}
