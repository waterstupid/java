package com.xiaofu.text;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author fmk
 * @date 2020/5/12
 **/
public class Text1 {
    public static void main(String[] args) throws IOException {
        System.out.println("====客户端=====");
        Scanner s=new Scanner(System.in);
        System.out.println("请输入你的名字:");
        System.out.println(s.next());
        Socket socket=new Socket("localhost",9999);
    }

}
