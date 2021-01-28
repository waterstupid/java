package com.review01;

import java.io.*;

/**
 * DataInputStream,DataOutputStream
 * 1.这两个流都是特定用来处理数据的
 * 2.都是以字节的方式来处理数据
 * 3.都是处理流
 *
 *
 */
public class DataInputOutputStreamText01 {
    public static void main(String[] args) {
        DataOutputStream out = null;
        DataInputStream  in = null;
        try {
            // 造流
            out = new DataOutputStream(new FileOutputStream("IO//text05"));
            in = new DataInputStream(new FileInputStream("IO//text05"));
            // 写数据
            // 可以按照基本类型去写
            out.writeBoolean(false);
            out.writeByte(20);
            out.writeDouble(20.0);
            // 以UTF-8 编码的格式写入中文
            out.writeUTF("我是中国人");

            // 然后再读出来
            // 注意:需要有顺序
            System.out.println(in.readBoolean());
            System.out.println(in.readByte());
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
