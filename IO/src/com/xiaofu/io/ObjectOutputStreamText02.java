package com.xiaofu.io;

import com.bean.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fmk
 * @date 2020/5/1
 **/
public class ObjectOutputStreamText02 {
    public static void main(String[] args) {
        ObjectOutputStream out=null;
        try {
            out=new ObjectOutputStream(new FileOutputStream("index06"));
            List<User> list=new ArrayList<>();
            list.add(new User("jack",23));
            list.add(new User("john",24));
            list.add(new User("mike",25));
            list.add(new User("zs",26));
            //将这个集合进行序列化
            out.writeObject(list);
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
