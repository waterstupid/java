package com.xiaofu.array;

/**
 * 该程序用来测试二维数组
 * 1.二维数组的本质其实就是一个一维数组，只不过一维数组中每个元素都是一维数组
 * 2.二维数组也可以动态初始化和静态初始化
 * @author fmk
 * @date 2020/5/8
 **/
public class ArrayText02 {
    public static void main(String[] args) {
        // 这是静态初始化一个二维数组
        int [][] a={{1,2,3},{2,3,5},{3,5,5},{33,4,32}};
        // 遍历这个二维数组
        for (int i = 0; i < a.length; i++) {
            for(int j=0;j<a[i].length;j++){
                System.out.println(a[i][j]);
            }
            System.out.println();
        }
        // 动态初始化一个二维数组
        // 这说明创建一个4行4列的二维数组，每一行中都有4个元素
        System.out.println("****************************************");
        String [][] s=new String[4][4];
        for (int i = 0; i < s.length; i++) {
            for(int j=0;j<s[i].length;j++){
                System.out.println(s[i][j]);
            }
            System.out.println();
        }
    }
}
