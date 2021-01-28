package com.xiaofu;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * TreeSet底层能将元素排序的原理是因为实现了Comparable接口
 */
public class TreeSetText02 {
    public static void main(String[] args) {
        SortedSet<Person> set=new TreeSet<Person>();
        set.add(new Person(15));
        set.add(new Person(20));
        set.add(new Person(17));
        set.add(new Person(19));
        /*
        Exception in thread "main" java.lang.ClassCastException:
         class com.xiaofu.Person cannot be cast to class java.lang.Comparable
         这里会出现异常，因为Person类没有实现Comparable接口，就会出现转换异常
         所以需要去实现Comparable接口
         */
        for(Person person:set){
            System.out.println(person);
        }



    }



}
class Person implements Comparable<Person>{
    int age;
    public Person(int age){
        this.age=age;
    }
    public String toString(){
        return "Person[age="+this.age+"]";
    }

    @Override
    //该方法用来指定比较规则
    public int compareTo(Person person) {
        return this.age-person.age;
    }
}