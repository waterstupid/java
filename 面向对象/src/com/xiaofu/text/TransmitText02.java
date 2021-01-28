package com.xiaofu.text;

/**
 * 该程序同样用来证明java中是值传递
 * @author fmk
 * @date 2020/5/3
 **/
public class TransmitText02 {
    public static void main(String[] args) {
        User user=new User(10);
        System.out.println(user.age);// 10
        doSome(user);
        // 问题是在调用doSome()方法前后输出的user.age是否相同
        // 不同，因为user引用所指向堆内存中对象的数据一已经发生改变，所以这里不会相同
        System.out.println(user.age);//50
    }
    public static void doSome(User user){
        user.age=50;
    }
}

class User{
    int age;
    public User(int age){
        this.age=age;
    }
}
