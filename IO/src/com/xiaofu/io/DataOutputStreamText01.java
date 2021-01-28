package com.xiaofu.io;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 该程序用来测试DataOutputStream中的方法
 * @author fmk
 * @date 2020/4/30
 **/
public class DataOutputStreamText01 {
    public static void main(String[] args) {
        DataOutputStream dos=null;
        try {
            dos=new DataOutputStream(new FileOutputStream("index05"));
            //往该文件中写入数据
            dos.writeInt(1);
            dos.writeByte(2);
            dos.writeBoolean(true);
            dos.writeShort(3);
            //刷新
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
