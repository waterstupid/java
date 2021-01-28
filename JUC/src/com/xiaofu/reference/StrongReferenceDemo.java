package com.xiaofu.reference;

public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object a = new Object();
        // b属于强引用，不会被回收
        Object b = a;
        a = null;
        System.out.println("回收之前,b="+b);
        try {
            byte [] c =new byte[20*1024*1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("回收之后,b="+b);
        }

    }
}
