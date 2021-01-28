package com.xiaofu.text01;

import com.xiaofu.text.Permission;

/**
 * @author fmk
 * @date 2020/5/6
 **/
public class Permission01 extends Permission {
    public static void main(String[] args) {
        // 这是Permission的子类，所以可以访问protected方法
        Permission01 per=new Permission01();
        // 所以这里就可以访问呢doSome()方法
        per.doSome();
    }
}
