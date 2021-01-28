package com.xiaofu.usedclass;

/**
 * java是采用unicode编码方式来编码字符的，一个字符等于两个字节
 * @author fmk
 * @date 2020/5/10
 **/
public class StringText05 {
    public static void main(String[] args) {
        String s="中国人";
        byte[] bytes = s.getBytes();
        System.out.println(bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        String a="a";
        byte[] array = a.getBytes();
        System.out.println(array.length);
        for (byte b : array) {
            System.out.println(b);
        }


    }
}
