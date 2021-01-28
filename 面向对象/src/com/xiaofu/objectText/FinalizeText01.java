package com.xiaofu.objectText;

/**
 * 该程序用来测试finalize()方法
 * finalize()方法不是程序员负责调用，而是垃圾回收器负责调用
 * @author fmk
 * @date 2020/5/7
 **/
public class FinalizeText01 {
    public static void main(String[] args) {
        for (int i = 0; i <1000 ; i++) {
            User u=new User();
            u=null;
            // 这个方法可以启动垃圾回收器
            // gc的全名是garbage Collection
            System.gc();
        }
    }

}
class User{
    @Override
    // 这个方法会在堆内存中的对象没有其他引用指向的时候
    // 垃圾回收器可能会调用这个方法，也可能不会

    protected void finalize() throws Throwable {
        System.out.println(this+"对象被销毁");
    }
}
