package com.xiaofu.array;

import java.util.Arrays;

/**
 * 该程序用来测试工具类java.util.Arrays
 * @author fmk
 * @date 2020/5/8
 **/
public class ArrayText03 {
    public static void main(String[] args) {
        int [] a={1,3,53,4,343,21,324,343,3};
        // sort()方法可以将数组中的元素进行排序
        Arrays.sort(a);
        // 遍历该数组
        for (int i : a) {
            System.out.println(i);
        }
        // binarySearch()方法可以用折半法去查找数组中的元素
        int index = Arrays.binarySearch(a, 343);
        System.out.println(index);// 7


    }
}
