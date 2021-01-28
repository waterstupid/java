package com.xiaofu.usedclass;

/**
 * 该程序用来测试String类中常用方法
 * @author fmk
 * @date 2020/5/8
 **/
public class StringText04 {
    public static void main(String[] args) {
        String s="abcdefga";
        // 1. compareTo() 用来比较该字符串是否和其他字符串相等
        int abc = s.compareTo("abcdeeee");
        System.out.println("1"+abc);
        // 2.indexOf() 用来返回指定字符串在原字符串的索引
        System.out.println("2"+s.indexOf("b"));
        // 3.lastIndexOf() 用来返回指定字符串在原字符串最后一次出现的索引
        System.out.println("3"+s.lastIndexOf("a"));
        // 4.replace() 用指定字符串去替原字符串的某个字符串
        System.out.println("4"+s.replace("c","国"));
        // 5.split() 用来分隔字符串
        String[] split = s.split("2"+"d");
        for (String s1 : split) {
            System.out.println(s1);
        }
        // 6.toLowerCase() 将字符串转换为小写
        System.out.println("5"+"ABCDSE".toLowerCase());
        // 7.toUpperCase() 将字符串转换位大写
        System.out.println("6"+s.toUpperCase());
        // 8.substring() 分割字符串
        System.out.println("7"+s.substring(2));
        System.out.println("8"+s.substring(2,5));// 包头不包尾
        // 9. concat() 将指定的字符串连接到字符串的末尾
        System.out.println(s.concat("中国人"));
        // 10. endsWith() 测试此字符串是否以指定字符串结尾
        System.out.println(s.endsWith("ab"));
        // 11.getBytes() 使用平台的默认字符集将此 String编码为字节序列，将结果存储到新的字节数组中
        byte[] bytes = "中国人".getBytes();
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
        byte[] b= s.getBytes();
        for (byte b1 : b) {
            System.out.println(b1);
        }
        // 12.isEmpty() 返回 true如果，且仅当 length()为 0 。
        System.out.println("".isEmpty());
        // 13.charAt() 返回 char指定索引处的值
        System.out.println(s.charAt(2));
        // 14.toCharArray() 将字符串转换为一个char数组
        char[] array = "我是一个中国人".toCharArray();
        for (char c : array) {
            System.out.println(c);
        }
        // 15.valueOf() 可以将其他类型的数据转换为字符串
        System.out.println(String.valueOf("123"));
        System.out.println(String.valueOf(array));
        // 16.startsWith() 判断字符串是否以指定字符串开头
        System.out.println("abcde".startsWith("ab"));
        // 17. trim() 去除字符串的前后空白
        System.out.println("     abc     ".trim());
        // 18.length() 返回字符串的长度
        System.out.println("中国人".getBytes().length);
    }
}
