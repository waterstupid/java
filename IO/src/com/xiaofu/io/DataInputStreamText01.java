package com.xiaofu.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 该程序用来测试DataInputStream中的方法
 * @author fmk
 * @date 2020/4/30
 **/
public class DataInputStreamText01 {
    public static void main(String[] args) {
        DataInputStream dis=null;
        try {
            //首先调用有参构造，创建对象
            dis=new DataInputStream(new FileInputStream("index05"));
            //根据文件写的顺序来对文件进行读取
            int i = dis.readInt();
            byte b = dis.readByte();
            boolean b1 = dis.readBoolean();
            short i1 = dis.readShort();
            System.out.println(i);
            System.out.println(b);
            System.out.println(b1);
            System.out.println(i1);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
