package com.xiaofu.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 此程序用来测试FileReader中的read(char [] c)方法
 * String中的有参构造同样可以将一个char数组转换为字符串
 * @author fmk
 * @date 2020/4/30
 **/
public class FileReaderText02 {
    public static void main(String[] args) {
        FileReader reader=null;
        try {
            reader=new FileReader("IO//index01");
            //可以将文件中的内容读取到字符串上
            char [] c=new char[4];
            int countRead=0;
            //将读取到的内容进行遍历
            while((countRead=reader.read(c)) != -1){
                System.out.print(new String(c,0,countRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
