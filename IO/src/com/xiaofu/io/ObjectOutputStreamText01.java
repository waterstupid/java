package com.xiaofu.io;

import com.bean.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 该程序用来测试序列化
 * 序列化：将保存在内存中的对象写入到硬盘当中
 * 调用方法：writeObject(Object obj)
 * @author fmk
 * @date 2020/5/1
 **/
public class ObjectOutputStreamText01 {
    public static void main(String[] args) {
        ObjectOutputStream out=null;
        try {
             out=new ObjectOutputStream(new FileOutputStream("index05"));
             User user=new User("jack",12);
             /*调用方法 writeObject(Object object)
             如果User中不实现Serializable接口，那么程序就会报java.io.NotSerializableException异常
             out.writeObject(user);
             */
             out.writeObject(user);
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
