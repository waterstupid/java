package com.xiaofu.array;

/**
 * 该程序用来复习冒泡排序
 * @author fmk
 * @date 2020/5/11
 **/
public class BubbleSort02 {
    public static void main(String[] args) {
        int [] a  ={1,2,3,6,9,4,7};
        for (int i = a.length - 1; i > 0; i--) {
            for(int j=0; j < i ;j++ ){
                // 数值大的往后排序
                if(a[j]>a[j+1]){
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
