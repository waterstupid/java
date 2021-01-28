package com.xiaofu.Reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 该程序用反射获取类中的方法
 * @author fmk
 * @date 2020/5/10
 **/
public class ReflectText08 {
    public static void main(String[] args) {
        try {
            Class<?> className = Class.forName("com.xiaofu.bean.User");
            Method[] methods = className.getDeclaredMethods();
            for (Method method : methods) {
                // 输出方法的修饰符
                System.out.println(Modifier.toString(method.getModifiers()));
                // 输出方法的返回值类型
                System.out.println(method.getReturnType().getSimpleName());
                // 输出方法名
                System.out.println(method.getName());
                // 输出方法的形参列表
                Class<?>[] types = method.getParameterTypes();
                for (Class<?> type : types) {
                    System.out.println(type.getSimpleName());
                }
                System.out.println("==========================");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
