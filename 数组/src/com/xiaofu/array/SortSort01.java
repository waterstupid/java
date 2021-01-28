package com.xiaofu.array;

/**
 * 该程序用来复习选择排序
 * @author fmk
 * @date 2020/5/9
 **/
public class SortSort01 {
    public static void main(String[] args) {
        int [] a={1,3,5,9,7,8,13,35,45};
        for (int i = 0; i < a.length-1; i++) {
            int min=i;
            for(int j=i;j<a.length-1;j++){
                if(a[min]>a[j+1]){
                    min=j+1;
                }
            }
            if( min != i){
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
