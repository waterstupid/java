package com.xiaofu.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * 该案例用来获取类中的构造方法
 * @author fmk
 * @date 2020/5/10
 **/
public class ReflectText07 {
    public static void main(String[] args) {
        try {
            Class<?> className = Class.forName("com.xiaofu.bean.User");
            Constructor<?>[] constructors = className.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                // 首先获得修饰符
                int modifier = constructor.getModifiers();
                // 调用Modifier中的静态方法toString()
                String modifiers = Modifier.toString(modifier);
                System.out.println(modifiers);
                // 输出构造方法的方法名
                System.out.println(constructor.getName());
                // 获取形参列表
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                for (Class<?> type : parameterTypes) {
                    System.out.println(type.getSimpleName());
                }
                System.out.println("======================================");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
