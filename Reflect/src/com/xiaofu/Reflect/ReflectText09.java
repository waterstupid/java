package com.xiaofu.Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 该案例用来测试Method中的方法
 * @author fmk
 * @date 2020/5/10
 **/
public class ReflectText09 {
    public static void main(String[] args) {
        try {
            Class<?> className = Class.forName("com.xiaofu.bean.Animal");
            Method sum = className.getDeclaredMethod("sum", int.class, int.class);
            // 调用invoke(Object obj,Object ...args)
            // 这个方法可以通过反射去调用某个对象中的方法
            System.out.println(sum.invoke(className.newInstance(),10,20));
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
