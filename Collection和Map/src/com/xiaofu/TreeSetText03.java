package com.xiaofu;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 在创建TreeSet对象的时候，参数可以传一个比较器
 */
public class TreeSetText03 {
    public static void main(String[] args) {
        //Set<Student> set=new TreeSet<>(new Comparator01());
        //采用匿名内部类的方式
        Set<Student> set=new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age-o2.age;
            }
        });
        set.add(new Student(10));
        set.add(new Student(50));
        set.add(new Student(30));
        set.add(new Student(20));
        for(Student student:set){
            System.out.println(student);
        }

    }
}

class Student{
    int age;
    public Student(int age){
        this.age=age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
}
/*

class Comparator01 implements Comparator<Student> {
    @Override
    public int compare(Student stu1, Student stu2) {
        return stu1.age-stu2.age;
    }
}*/
