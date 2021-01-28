package com.xiaofu.objectText;

/**
 * 该程序用来测试Object中的equals()方法
 * equals()方法在Object类中，是比较内存地址的，但是在实际开发中，我们一般都要重写equals()方法
 * @author fmk
 * @date 2020/5/7
 **/
public class EqualsText01 {
    public static void main(String[] args) {
        // 这两个对象实际上是一样的，但是它们的内存地址是不同的，如果没有重写equals()方法，
        // 那么比较的就是内存地址，这样明显和实际情况不符合
        Person p=new Person("张三",20);
        Person p1=new Person("张三",20);
        // System.out.println(p.equals(p1));// false
        // 重写之后的结果
        System.out.println(p.equals(p1));// true
    }
}
