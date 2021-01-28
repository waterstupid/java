package com.bean;

import java.io.Serializable;

/**
 * @author fmk
 * @date 2020/5/1
 **/
public class User implements Serializable {
    //这个ID建议自己手动写，因为这个ID是来保证这个User类编译生成的class文件是一样的
    //这个ID是用来区分来两个类的
    private static final long serialVersionUID = 5645979538643230655L;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

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

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
