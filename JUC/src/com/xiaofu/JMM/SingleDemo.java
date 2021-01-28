package com.xiaofu.JMM;
// 这是一个单例模式
// 经典单例模式懒汉式
class DCLDemo {
    private volatile static DCLDemo instance = null;
    private DCLDemo(){
        System.out.println("构造方法被执行");
    }
    // 可以用加synchronized的方式来保证线程安全
    // 也可以使用DCL的方式来进行双重判断
    // 但是这样还是会出现一定的问题
    // 我们知道创建对象首先要进行分配内存空间，然后再进行对象的初始化，然后再将内存地址赋值给引用变量
    // 由于编译器的指令重排，导致分配完内存空间后就直接将内存地址赋值给了引用变量，这导致instance对象虽然被
    // 创建了但是未被初始化，所以如果其他线程获取一个不为null的instance,虽然不为null,但是可能没有初始化，所以
    // 就会出现线程安全的问题
    // 所以要加上volatile来禁止指令重排序
    public static DCLDemo getInstance(){
        if(instance==null){
            synchronized (DCLDemo.class){
                if(instance == null) {
                    instance = new DCLDemo();
                }
            }
        }
        return instance;
    }
}
public class SingleDemo{
    public static void main(String[] args) {
        // 这种在单线程环境下是没有影响的
        // 都是返回true
        // 但是在多线程环境下就会出现问题
        // System.out.println(DCLDemo.getInstance() == DCLDemo.getInstance());
        // System.out.println(DCLDemo.getInstance() == DCLDemo.getInstance());
        // System.out.println(DCLDemo.getInstance() == DCLDemo.getInstance());
        for(int i = 0; i<10;i++){
            new Thread(() ->{DCLDemo.getInstance();},String.valueOf(i)).start();
        }

    }



}
