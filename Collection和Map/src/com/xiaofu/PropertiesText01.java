package com.xiaofu;

import java.util.Properties;

/**
 * 改程序用来测试Properties,这是线程安全的一个集合，且key和value都只能存储String类型
 * Properties集合中同样也不能添加Null
 */
public class PropertiesText01 {
    public static void main(String[] args) {
        Properties pro=new Properties();
        //1.setProperty() 这是向Properties集合中存储元素
        pro.setProperty("url","http://www.baidu.com");
        pro.setProperty("username","jack");
        pro.setProperty("password","123");
        //2.getProperty(String key) 这是从Properties中根据key取出元素
        System.out.println(pro.getProperty("url"));
        System.out.println(pro.getProperty("username"));
        System.out.println(pro.getProperty("password"));
        //3.load(InputStream stream) 该方法可以加载一个流




    }
}
