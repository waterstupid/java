package com.xiaofu.array;

// 该程序用来测试冒泡排序
public class BubbleSortText03 {

    public static Integer[] bubble(Integer [] array){
        // 外层循环来控制循环次数
        for(int i =array.length-1; i>0 ; i--){
            // 内层循环来控制比较次数
            for(int j=0 ; j<i ;j++) {
                if (array[j] > array[j + 1]) {
                    int temp = 0;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
