package com.xiaofu.Reflect;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;
import com.xiaofu.bean.User;

/**该程序用来测试反射机制如何获取class文件
 * 1.Class.forName(完整类名)
 * 2.所有类中都有getClass()方法
 * 3.所有类中都有class属性
 * @author fmk
 * @date 2020/5/10
 **/
public class ReflectText01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 第一种获取class文件，Class.forName()
        Class className = Class.forName("com.xiaofu.bean.User");
        // 第二种获取class文件,调用getClass方法
        User user = new User();
        Class className1 = user.getClass();
        // 第三种,class属性
        Class className2 = User.class;
        System.out.println(className==className1);// true
        System.out.println(className==className2);// true
        System.out.println(className1==className2);// true
        // 第四种,通过类加载器的方式
        Class clazz = ReflectText01.class.getClassLoader().loadClass("com.xiaofu.bean.User");
        System.out.println(clazz==className);


    }
}
