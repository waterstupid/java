package com.xiaofu.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 该程序用来测试FileOutputStream（字节输出流中的）的方法
 * @author fmk
 * @date 2020/4/30
 **/
public class FileOutputStreamText01 {
    public static void main(String[] args) {
        FileOutputStream out=null;
        try {
            //调用有参构造创建字节输出流，这里如果没有text文件，会自动创建一个text文件
            //out=new FileOutputStream("text");
            //同样可以调用这种构造方法，append参数为true，则说明可以重复向文件中写入数据，并不会
            //被覆盖
            out=new FileOutputStream("text",true);
            //1.调用write()方法,可以每次只向文件中写入一个字节的数据
            out.write(97);//a
            out.write(98);//b
            out.write(99);//c
            out.write(100);//d
            //2.调用write(byte [] b),同样也可以将数组中保存的数据，写入到文件当中
            byte [] b={97,98,99,100,101,102};
            out.write(b);
            //刷新流
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
