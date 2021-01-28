package com.xiaofu.Reflect;

import java.util.ResourceBundle;

/**
 * 采用ResourceBundle.getBundle()来获取配置文件中的key值
 * @author fmk
 * @date 2020/5/10
 **/
public class ReflectText04 {
    public static void main(String[] args) {
        ResourceBundle init = ResourceBundle.getBundle("init");
        String className = init.getString("className");
        System.out.println(className);


    }
}
