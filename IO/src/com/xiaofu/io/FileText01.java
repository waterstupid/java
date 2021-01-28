package com.xiaofu.io;

import javax.xml.crypto.Data;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该程序用来测试File中的方法
 * @author fmk
 * @date 2020/5/1
 **/
public class FileText01 {
    public static void main(String[] args) {
        //创建对象
        File file=new File("C:\\MASM");
        //1. String getAbsolutePath(); 获取绝对路径
        String path = file.getAbsolutePath();
        System.out.println(path);
        //2. String getName() 获取文件的名字
        System.out.println(file.getName());
        //3.long length() 获取文件的大小
        System.out.println(file.length());
        //4.boolean isDirectory() 判断文件是否是一个目录
        System.out.println(file.isDirectory());//false
        //5.boolean isFile() 判断该文件是否是一个文件
        System.out.println(file.isFile());//true
        //6.long lastModified() 返回该文件最后一次修改的时间，是一个毫秒数，从1970年到现在
        long time = file.lastModified();
        Date data=new Date(time);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(sdf.format(data));
        //7.mkdir() 创建以此文件名字作为的目录
        System.out.println(file.mkdir());
        //8.String[] list() 返回一个字符串数组，命名由此抽象路径名表示的目录中的文件和目录
        String[] fileList = file.list();
        for (String s : fileList) {
            System.out.println(s);
        }

    }
}
