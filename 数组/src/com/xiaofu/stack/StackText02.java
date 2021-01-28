package com.xiaofu.stack;

public class StackText02 {
    public static void main(String[] args) {
        StackUpdate stackUpdate = new StackUpdate();
        stackUpdate.push("小红");
        stackUpdate.push("小明");
        stackUpdate.push("小黑");
        stackUpdate.push("小黄");
        stackUpdate.push("小付");
        //stackUpdate.push("小加");
        System.out.println("------------------------");
        System.out.println(stackUpdate.pop());
        System.out.println(stackUpdate.pop());
        System.out.println(stackUpdate.pop());
        System.out.println(stackUpdate.pop());
        //System.out.println(stackUpdate.pop());
        stackUpdate.pop();
        System.out.println(stackUpdate.size());


    }

}
