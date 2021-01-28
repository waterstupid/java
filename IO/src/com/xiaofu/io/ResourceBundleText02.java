package com.xiaofu.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ResourceBundleText02 {
    public static void main(String[] args) {
        // 注意：db.properties应该放在src目录下
        // 采用类加载器的方式来读取配置文件
        InputStream is = ResourceBundleText02.class.getClassLoader().getResourceAsStream("db.properties");
        Properties pro=new Properties();
        try {
            pro.load(is);
            String username = pro.getProperty("username");
            String password = pro.getProperty("password");
            System.out.println(username);
            System.out.println(password);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
