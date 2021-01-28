package com.xiaofu;

import com.xiaofu.util.FileNotFoundException01;

/**
 * @author fmk
 * @date 2020/5/9
 **/
public class ExceptionText01 {
    public static void main(String[] args) {
        // 可以创建异常对象
        NullPointerException n=new NullPointerException("对不起，空指针异常");
        System.out.println(n);
        try {
            doSome();
        } catch (ClassNotFoundException | FileNotFoundException01 e) {
            e.printStackTrace();
        }

    }

    private static void doSome() throws ClassNotFoundException, FileNotFoundException01 {
        throw new FileNotFoundException01("对不起文件找不到");

    }
}
