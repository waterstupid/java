package com.xiaofu.usedclass;

/**
 * 1.StringBuffer是线程安全的,所以相对于StringBuilder来说效率比较低
 * 2.StringBuffer底层采用了一个byte数组来实现，StringBuffer/StringBuilder是可变字符串的原因是该数组
 * 没有被final修饰，所以这个数组可以扩容，扩容的时候底层是调用了System.arrayCopy()方法
 * 3.StringBuffer/StringBuilder的初始容量都是16,因为数组的扩容效率较低，所以我们一般在开发中事先预定好
 * 初始容量，这样可以提高开发效率
 * 4.StringBuffer/StringBuilder中的append()方法可以用来拼接字符串
 * @author fmk
 * @date 2020/5/8
 **/
public class StringBufferText01 {
    public static void main(String [] args){
        StringBuilder sb=new StringBuilder();
        // 可以调用append()方法进行拼接字符串
        sb.append("abc");
        sb.append(false);
        sb.append(123);
        sb.append("中国人");
        System.out.println(sb);



    }


}
