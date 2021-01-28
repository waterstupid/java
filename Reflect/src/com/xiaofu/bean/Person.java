package com.xiaofu.bean;

/**
 * @author fmk
 * @date 2020/5/10
 **/
public class Person {
    private String name="张三";
    private int age=12;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
