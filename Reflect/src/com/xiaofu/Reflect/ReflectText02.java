package com.xiaofu.Reflect;

import com.xiaofu.bean.User;

/**
 * @author fmk
 * @date 2020/5/10
 **/
public class ReflectText02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class className = Class.forName("com.xiaofu.bean.User");
        // 可以通过newInstance()创建对象
        User user = (User) className.newInstance();
        System.out.println(user.getName());
        // 可以通过getName()得到完整类名
        System.out.println(className.getName());
        // 可以通过getSimpleName()得到不带包名的类名
        System.out.println(className.getSimpleName());



    }
}
