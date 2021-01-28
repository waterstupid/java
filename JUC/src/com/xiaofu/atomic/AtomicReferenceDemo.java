package com.xiaofu.atomic;

import java.util.concurrent.atomic.AtomicReference;

class User{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User zs = new User(12, "zs");
        User ls = new User(13, "ls");
        // 该类表示原子引用
        // 可以保证原子性，也就是在多线程的环境下访问是安全的
        AtomicReference<User> reference = new AtomicReference<>(zs);
        // 期望是zs,如果是zs，则将它改变为ls
        System.out.println(reference.compareAndSet(zs, ls)+"update success");
        System.out.println("update new value = "+reference.get().toString());


    }
}
