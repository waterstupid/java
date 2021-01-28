package com.xiaofu.objectText;

/**该程序用来测试toString()方法
 * toString()是用来将对象以字符串的形式输出，一般都是要重写的
 * @author fmk
 * @date 2020/5/7
 **/
public class ToStringText01 {
    public static void main(String[] args) {
        Person p=new Person("张三",20);
        // 没有重写toString()方法之前，输出的都是内存地址
        // 这里会自动调用p的toString()方法
        // System.out.println(p); com.xiaofu.objectText.Person@10f87f48
        // 重写之后输出的字符串
        System.out.println(p);// Person{name='张三', age=20}

    }
}
