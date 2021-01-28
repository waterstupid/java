package com.xiaofu.text01;

/**
 * @author fmk
 * @date 2020/5/6
 **/
public class Permission02 {
    public static void main(String[] args) {
        Permission01 per=new Permission01();
        // 但是在这里不能访问per中的doSome()方法，因为doSome()方法是受保护的，只能在同包或者子类中
        // 访问
        // per.doSome();
    }
}
