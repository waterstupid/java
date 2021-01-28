package com.xiaofu.classloader;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        // 注意:类加载器分为四种，BootstrapClassLoader,
        // ExtensionClassLoader,AppClassLoader
        // 用户自定义类加载器
        System.out.println(classLoader);// AppClassLoader
        System.out.println(classLoader.getParent());//ExtensionClassLoader
        System.out.println(classLoader.getParent().getParent()); //BootstrapClassLoader



    }


}
