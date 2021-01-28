package com.xiaofu.array;

/**
 * 该程序用来测试数组扩容的方法
 * @author fmk
 * @date 2020/5/7
 **/
public class Text {
    public static void main(String[] args) {
        Integer [] i={1,2,3,4};
        Integer [] a= new Integer[0];
        try {
            Object[] objects = IncreaseArrayLength.increaseAccount(i, a, 7);
            for (Object object : objects) {
                System.out.println(object);
            }
            System.out.println(objects.length);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
