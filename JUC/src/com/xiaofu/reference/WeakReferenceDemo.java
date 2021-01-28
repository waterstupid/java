package com.xiaofu.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object a = new Object();
        // 弱引用
        WeakReference<Object> b = new WeakReference<Object>(a);
        System.out.println("回收之前,b="+b.get());
        a = null;
        try {
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 垃圾回收之后
            System.out.println("回收之后，b="+b.get());
        }



    }
}
