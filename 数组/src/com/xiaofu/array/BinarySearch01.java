package com.xiaofu.array;

/**
 * 该程序用来复习二分法查找数组
 * @author fmk
 * @date 2020/5/9
 **/
public class BinarySearch01 {
    public static void main(String[] args) {
        int [] a={1,2,3,5,6,7,8};
        int index=binarySearch(a,7);
        System.out.println(index==-1 ? "数组中没有这个元素":"数组元素的下标为"+index);

    }
    public static int binarySearch(int[] a, int ele) {
        int begin=0;
        int end=a.length-1;
        while(begin<=end){
            int mid=(begin+end)/2;
            if(a[mid]>ele){
                end=mid-1;
            }else if(ele>a[mid]){
                begin=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
