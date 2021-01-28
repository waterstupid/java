package com.xiaofu.Reflect;

import com.xiaofu.bean.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author fmk
 * @date 2020/5/10
 **/
public class ReflectText03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // IO和Properties的联用
        Properties pro=new Properties();
        pro.load(new FileInputStream("Reflect/init.properties"));
        String className = pro.getProperty("className");
        Class name= Class.forName(className);
        User user = (User) name.newInstance();
        System.out.println(user);


    }
}
