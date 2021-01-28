package com.xiaofu.array;

/**
 * 该程序用来手写一个数组扩容
 * @author fmk
 * @date 2020/5/7
 **/
public class IncreaseArrayLength {
    public static Object[] increaseAccount(Object [] old,Object [] now,int length) throws NotFoundException {
        if(length<old.length){
            throw new NotFoundException("对不起，您输入扩容数组长度有误");
        }
        // 动态初始化数组
        now=new Object[length];
        for (int i = 0; i < old.length; i++) {
            now[i]=old[i];
        }
        return now;
    }
}
