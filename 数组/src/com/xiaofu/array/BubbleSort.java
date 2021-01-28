package com.xiaofu.array;

/**
 * 该程序用来测试冒泡排序
 * @author fmk
 * @date 2020/5/8
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int [] a={23,3,4,343,4,34,27,433};
        // 首先确定外层循环次数，外层的循环次数应该是数组的长度-1
        for (int i = a.length - 1; i >0; i--) {
            // 然后确定内层每次循环都要比较的次数
            // 8个元素，比较7次
            // 7个元素，比较6次
            // 6个元素，比较5次
            // 5个元素，比较4次
            // ....
            for(int j = 0; j < i; j++){
                if(a[j] > a[j+1]){
                    // 然后再交换位置
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

}
