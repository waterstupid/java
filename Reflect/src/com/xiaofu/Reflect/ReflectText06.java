package com.xiaofu.Reflect;

import com.xiaofu.bean.Person;

import java.lang.reflect.Field;

/**
 * 该程序用来测试如何通过反射得到类中属性的值
 * @author fmk
 * @date 2020/5/10
 **/
public class ReflectText06 {
    public static void main(String[] args) {
        try {
            Class<?> className = Class.forName("com.xiaofu.bean.Person");
            // 调用无参构造创建对象
            Object o = className.newInstance();
            Field[] fields = className.getDeclaredFields();
            for (Field field : fields) {
                // 打破私有性
                field.setAccessible(true);
                Object value = field.get(o);
                System.out.println(value);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
