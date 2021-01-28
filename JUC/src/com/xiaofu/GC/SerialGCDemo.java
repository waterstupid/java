package com.xiaofu.GC;

public class SerialGCDemo {
    // 串行垃圾回收器是发生在新生代中的
    // 但现在一般不使用了，因为现在都是高并发，而Serial垃圾会回收器适合单线程环境下
    public static void main(String[] args) {
        byte [] b = new byte[20*1024*1024];
    }

}
