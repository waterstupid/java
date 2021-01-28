package com.xiaofu.stack;

/**
 * 该程序用数组来模拟栈
 * @author fmk
 * @date 2020/5/6
 **/
public class Stack {

    // 这个数组长度
    private int width;

    // 设置一个常量，该常量为数组的默认长度
    private static final int DEFAULT_LENGTH=5;
    // 定义一个数组,该数组的默认长度是为5
    private Object [] value=new Object[DEFAULT_LENGTH];
    // 定义一个栈针
    private int index=value.length;
    public Stack() {
    }
    // 这是一个有参构造，可以自定义栈中的默认长度
    public Stack(int length){
        value=new Object[length];
        index=value.length;
    }
    // 提供一个push方法
    public void push(Object obj){
        index--;
        if(index<0){
            System.out.println("对不起，栈已满，不能压栈了");
            return;
        }
        // 将当前对象
        value[index]=obj;

    }
    // 提供一个pop方法
    public Object pop(){
        if(index==value.length-1){
            System.out.println("对不起，栈已空，栈中没有元素");
            return null;
        }
        index++;
        return value[index];
    }

}
