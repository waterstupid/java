package com.xiaofu.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 该程序用来测试用FileReader和FileWriter（字符流）来进行文件复制
 * @author fmk
 * @date 2020/5/1
 **/
public class Copy02 {
    public static void main(String[] args) {
        FileReader rea=null;
        FileWriter wri=null;
        try {
            rea=new FileReader("index04");
            wri=new FileWriter("index07");
            int readCount=0;
            char [] c=new char[4];
            while((readCount=rea.read(c)) != -1){
                wri.write(c,0,readCount);
            }
            //对流进行刷新
            wri.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (wri != null) {
                try {
                    wri.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (rea != null) {
                try {
                    rea.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
