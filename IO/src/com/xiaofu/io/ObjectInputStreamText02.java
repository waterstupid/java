package com.xiaofu.io;

import com.bean.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * 该程序用来反序列化保存在硬盘中的对象
 * @author fmk
 * @date 2020/5/1
 **/
public class ObjectInputStreamText02 {
    public static void main(String[] args) {
        ObjectInputStream in=null;
        try {
            in=new ObjectInputStream(new FileInputStream("index09"));

            List<User> list= (List<User>) in.readObject();
            //遍历这个集合
            for (User user : list) {
                System.out.println(user);
            }
        } catch (IOException | ClassNotFoundException e) {
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
