package com.xiaofu.usedclass;

import java.util.Random;

/**
 * 该案例用来检验如何输出5个不同的随机数
 * @author fmk
 * @date 2020/5/9
 **/
public class RandomText02 {
    public static void main(String[] args) {
        int [] a=new int[5];
        // 首先给数组中的元素赋值
        for (int i = 0; i < a.length; i++) {
            a[i]=-1;
        }
        int index=0;
        while(index != a.length){
            int ele = new Random().nextInt(5);
            if(!contains(a,ele)){
                a[index++]=ele;
            }
        }

        /*for(int index=0;index<a.length;index){
            Random random = new Random();
            int ele = random.nextInt();
            if(!contains(a,ele)){
                a[index++]=ele;
            }
        }*/
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * 该方法用来判断检验数组中有无指定元素
     * @param a
     * @param ele
     * @return 如果返回true，则代表有，如果返回false，则代表没有
     */
    private static boolean contains(int[] a, int ele) {
        for (int i = 0; i < a.length; i++) {
            if(a[i] == ele){
                return true;
            }
        }
        return false;
    }
}
