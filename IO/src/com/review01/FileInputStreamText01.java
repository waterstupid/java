package com.review01;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *  1.首先流有四大家族，InputStream,OutputStream,Reader,Writer
 *  这四大流都是抽象类
 *  流按照输入方向可以分为:输入流，输出流
 *  流按照输入数据的方式不同可以分为:字节流,字符流
 *  流按照角色的不同可分为:节点流,处理流
 *
 *  注意:以Stream结尾的流就是字节流,以reader或writer结尾的流就是字符流
 *  字节流每次都是一个字节的方式读取文件的
 *  而字符流每次都是以一个字符方式读取文件的
 *  这里的字符和字节并没有确定的等量关系,不能说一个字节等于多少个字符,要看文件采用何种的编码方式
 *
 *  2.字节流理论上来说可以读取任何类型的文件，比如纯文本文件，音频，视频等等。但是我们一般不使用
 *  字节流来读去纯文本文件，因为在读取的过程中可能会发生乱码，但是如果是复制文件的话，我们可以使用到
 *  字节流
 *
 *
 *
 *
 *
 *
 */



public class FileInputStreamText01 {
    public static void main(String[] args) {
        // 1.造流
        FileInputStream in = null;
        try {
            in = new FileInputStream("IO//index");

            // 2.读取文件
            // 注意:返回值是每次读取的字节，将字节保存在内存中的变量中
            // int data = in.read();
            // 也可以将文件中的内容读取到一个byte数组中
            byte [] b = new byte[3];
            // 该方法返回值代表的是每次读取的个数
            // 该方法表示将文件中读取的内容保存到数组当中去,采用的是覆盖方法,也就是说每次
            // 从文件中读取内容是采取覆盖的方法来保存到数组中，这样就会出现一个问题，如果最后
            // 一次文件中没有足够的内容读取的话,这样数组中保存的就不是最后一次读取的数据，而是
            // 还包含上一次中读取的数据
            int data = in.read(b);
            while(data != -1){
                // 中文是采用UTF-8編碼的方式，一個中文占用3個字節
                System.out.println(new String(b,0,data));
                data = in.read(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if(in != null){
                    // 關閉流
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }






    }



}
