package com.xiaofu.Reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author fmk
 * @date 2020/5/10
 **/
public class ReflectText10 {
    public static void main(String[] args) {
        try {
            Class<?> className = Class.forName("com.xiaofu.bean.Animal");
            Method[] methods = className.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(Modifier.toString(method.getModifiers()));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
