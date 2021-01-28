package com.xiaofu.stack;

import com.xiaofu.stack.exception.OverIndexException;

/**
 * 用数组来模拟栈的数据结构
 */
public class StackUpdate {
    // 底层的数据结构是数组
    private static Object [] array=new Object[5];
    // 该值表示栈针
    private static int index = array.length-1;
    // 该值表示数组的长度
    private static int size = 0;

    // 该方法是用来向栈中添加元素的
    public void push(Object element){
        // 数组的长度不够
        if(index < 0){
            throw new OverIndexException("对不起,栈中元素已满");
        }
        array[index--]=element;
        // 将数组长度减一
        size++;
    }
    // 该方法是从栈中弹出元素的
    public Object pop(){
        // 定义异常
        if(index == array.length-1){
            throw new OverIndexException("对不去,栈中没有元素了");
        }
        size--;
        return array[++index];
    }
    // 该方法是用来的得到栈中元素大小的
    public int size(){
        return size;
    }

    // 6 8 7 5 4





}
