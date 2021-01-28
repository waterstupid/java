package com.xiaofu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 在使用read()方法读取文件中的数据需要注意：
 * 1.read()方法可以每次只读出一个字节
 * 2.read(byte [] b)方法可以每次读取最大长度为byte数组的长度的数据，并写入到数组当中
 * 3.如果文件中的数据被读完，则read()方法返回-1
 * 4.可以通过String的有参构造将byte[] 数组转换成字符串
 * @author fmk
 * @date 2020/4/30
 **/
public class FileInputStreamText02 {
    public static void main(String[] args) {
        FileInputStream in=null;
        try {
             in=new FileInputStream("IO//index");
            //用读取数组的方式 read(Byte [] b)
            byte [] b=new byte[4];
            /*int read = in.read(b);
            System.out.println(read);//注意这个返回的是每次读取的个数
            //这才是从数组中取出被读取出来的数据
            for (byte b1 : b) {
                System.out.println(b1);
            }
            int read1=in.read(b);
            //注意：每次从文件中读取4个字节的数据，即使文件中不存在4个数据，那么它也会将不够的数据
            //进行覆盖
            for (byte b1 : b) {
                System.out.println(b1);
            }*/
            //所以应该用这种方式来读取,可以将byte数组转换为成字符串
            int readCount=0;
            while((readCount=in.read(b))!=-1){
                System.out.print(new String(b,0,readCount));
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
