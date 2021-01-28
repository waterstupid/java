package com.xiaofu;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 该程序用来实现手动抛出异常
 * @author fmk
 * @date 2020/5/10
 **/
public class ExceptionText02 {

    public static void doSome(int a,int b) throws ElementIsNotZeroException {
        if( a < 0 ){
            // 这是一个编译时候的异常，编译时异常需要处理
            throw new ElementIsNotZeroException("输入的元素不能为0");
        }
    }
    public static void main(String [] args){

        try {
            doSome(-2,1);
        } catch (ElementIsNotZeroException e) {
            e.printStackTrace();
        }
    }
}
