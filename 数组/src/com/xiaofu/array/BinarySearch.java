package com.xiaofu.array;

/**
 * 该程序用来测试二分法查找数组
 * 首先二分法查找数组的前提条件是：数组需要从小到大排好序
 * 核心算法：首先找出数组的中间元素的大小，与要查找的元素进行比较，如果该中间元素大于要查找的元素
 * 则将中间元素的的下标减1，再与初始元素下标相加除以2,与此类推
 * @author fmk
 * @date 2020/5/8
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int [] a={1,2,3,4,5,6,7,8,9};
        int index=binarySearch(a,2);
        System.out.println(index==-1 ? "该数组中不存在该元素":"元素的下标为"+index);




    }

    /**
     * 该方法用二分法查找特定元素所在数组的下标
     * @param a 被检索的数组
     * @param ele 被检索的元素
     * @return 如果返回-1则代表没有找到该元素，如果返回值大于0,则代表找到了该元素
     */
    private static int binarySearch(int[] a, int ele) {
        int begin=0;
        int end=a.length-1;
        while(begin<=end){
            int mid=(begin+end)/2;
            if(a[mid]==ele){
                return mid;
            }else if(a[mid]>ele){
                end=mid-1;
            }else{
                begin=mid+1;
            }
        }
        return -1;
    }
}
