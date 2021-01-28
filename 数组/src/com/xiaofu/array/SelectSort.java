package com.xiaofu.array;

/**
 * 该程序用来测试选择排序
 * 选择排序的核心算法就是：将一组中除去第一个元素之后的所有元素找出最小值，然后将这个最小值和第一个元素
 * 比较，如果这个元素比第一个元素小，则交换位置
 * @author fmk
 * @date 2020/5/8
 **/
public class SelectSort {
    public static void main(String[] args) {
        int [] a={2,3,5,4,6,46};
        // 先确定外层循环的循环次数
        for (int i = 0; i < a.length-1; i++) {
            // 判断要找最小值的所有的数组元素
            // 假设第一个元素是最小值
            int min=i;
            for(int j = i ;j < a.length-1; j++){
                if (a[min] > a[j+1]){
                    min=j+1;
                }
            }
            // 如果最小值和i不相等，则证明数组还有更小的值
            if(min != i){
                // 此时min是最小的
                int temp=a[min];
                a[min]=a[i];
                a[i]=temp;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }


    }
}
