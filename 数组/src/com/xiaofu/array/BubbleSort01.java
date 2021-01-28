package com.xiaofu.array;

/**
 * 该程序用来复习冒泡排序
 * @author fmk
 * @date 2020/5/9
 **/
public class BubbleSort01 {
    public static void main(String[] args) {
        int [] a={1,2,5,4,3,2,7,9,8};
        for (int i = a.length - 1; i > 0; i--) {
            for(int j=0 ; j<i ; j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        for (int i : a) {
            System.out.println(i);
        }
    }
}
