package com.xiaofu.extend;


import org.junit.Test;

import java.lang.reflect.Field;

public class ExtendDemo01 {
}

class Man extends Person{
    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        Field filed = clazz.getDeclaredField("name");
        filed.setAccessible(true);
        Person person = clazz.newInstance();
        filed.set(person,"lisi");
        System.out.println(filed.get(person));
    }
}


class Person{
    private String name;
    String age;
}
