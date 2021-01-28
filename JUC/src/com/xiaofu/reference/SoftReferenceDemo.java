package com.xiaofu.reference;

import java.lang.ref.SoftReference;
import java.nio.charset.MalformedInputException;

public class SoftReferenceDemo {
    public static void main(String[] args) {
        Object a = new Object();
        SoftReference<Object> b = new SoftReference<>(a);
        // 内存空间啊充足的情况下不回收
        // 内存空间不足的情况下就回收
        System.out.println("回收之前,b="+b.get());
        a = null;
        try {
            byte [] c = new byte[15*1024*1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("回收之后,b="+b.get());
        }




    }
}
