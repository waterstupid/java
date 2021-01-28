package com.xiaofu.io;

import java.util.ResourceBundle;

public class ResourceBundleText01 {
    public static void main(String[] args) {
        // 采用ResourceBundle的方式
        // 注意，如果要使用相对路径，相对路径对应的是
        // src目录下
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        System.out.println(bundle.getString("username"));
        System.out.println(bundle.getString("password"));


    }
}
