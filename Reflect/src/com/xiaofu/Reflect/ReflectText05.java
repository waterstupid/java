package com.xiaofu.Reflect;

import com.xiaofu.bean.User;

import java.lang.reflect.Field;

/**
 * 该程序用来利用反射来获取class文件中的属性
 * @author fmk
 * @date 2020/5/10
 **/
public class ReflectText05 {
    public static void main(String[] args) {
        try {
            // 获取class文件
            Class<?> className = Class.forName("com.xiaofu.bean.User");
            // 获取所有的属性 getDeclaredFields() 获取所有的属性返回一个Field数组
            Field[] fields = className.getDeclaredFields();
            // 获得指定的属性
            className.getDeclaredField("age");
            User user = (User) className.newInstance();
            for (Field field : fields) {
                field.setAccessible(true);
                // 获取变量的名字
                String fieldName = field.getName();
                System.out.println(fieldName);
                System.out.println(field.getType().getSimpleName());
                // 给变量赋值
                if ("String".equals(field.getType().getSimpleName())) {
                    field.set(user, "张三");
                } else if ("int".equals(field.getType().getSimpleName())) {
                    field.set(user, 12);
                }
            }
            System.out.println(user);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
