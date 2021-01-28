package com.review;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * FileOutputStream 是一个字节输出流,每次以一个字节的方式来向文件中写入数据
 * 同样也是一个节点流,不可能是包装流
 *
 *
 */

public class FileOutputStreamText01 {
    public static void main(String[] args) {
        FileOutputStream out = null;
        try {
            // 表示向index06文件中写入数据，默认是覆盖,true是追加
            out=new FileOutputStream("IO//index06",true);
            // 可以以byte数组的方式去写入文件
            byte [] b = {97,98,99,100};
            // 以byte数组的方式写入文件
            out.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
