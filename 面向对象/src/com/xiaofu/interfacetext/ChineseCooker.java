package com.xiaofu.interfacetext;

/**
 * @author fmk
 * @date 2020/5/6
 **/
//这是一个中国厨师
public class ChineseCooker implements Meau {
    //这是重写之后的方法
    @Override
    public void makeFood() {
        System.out.println("中国厨师做的美味佳肴....");

    }
}
