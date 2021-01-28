package com.xiaofu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 该程序用来测试IO和Properties的联合使用
 * 我们一般将保存属性的文件叫做属性配置文件
 * @author fmk
 * @date 2020/5/1
 **/
public class IOProperties {
    public static void main(String[] args) {
        FileInputStream in=null;
        try {
            Properties pro=new Properties();
            in=new FileInputStream("text");
            //调用load(InputStream in)方法
            pro.load(in);
            System.out.println(pro.getProperty("name"));
            System.out.println(pro.getProperty("age"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
