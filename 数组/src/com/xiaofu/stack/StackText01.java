package com.xiaofu.stack;

/**
 * @author fmk
 * @date 2020/5/6
 **/
public class StackText01 {
    public static void main(String[] args) {
        Stack stack=new Stack(10);
        // push方法
        stack.push("小明");
        stack.push("小红");
        stack.push("张三");
        stack.push("李四");
        stack.push("李四");
        stack.push("李四");
        stack.push("李四");
        stack.push("李四");
        stack.push("李四");
        stack.push("李四");
        stack.push("李四");
        // pop方法
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
