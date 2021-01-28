package com.xiaofu.array;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该程序用来复习折半查找法
 * @author fmk
 * @date 2020/5/11
 **/
public class BinarySearch02 {
    public static void main(String[] args) {
        int [] a={1,2,3,4,5,6,7};
        try {
            while(true){
                long time = System.currentTimeMillis();
                Date nowTime = new Date(time);
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(nowTime)+":二分法开始查找");
                int index=binarySearch(a,5);
                long time1 = System.currentTimeMillis();
                Date endTime = new Date(time1);
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(endTime)+":算法结束");
                System.out.println(index);
                Thread.sleep(1000);
            }

        } catch (NotFoundException | InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static int binarySearch(int[] a,int ele) throws NotFoundException {
        int begin=0;
        int end=a.length-1;
        while(begin<=end){
            int mid=(begin+end)/2;
            if(a[mid]>ele){
                end=mid-1;
            }else if(a[mid]<ele){
                begin=mid+1;
            }else{
                return mid;
            }
        }
        throw new NotFoundException("对不起数组中没有这个元素");
    }
}
