package com.xiaofu.interfacetext;

/**
 * @author fmk
 * @date 2020/5/6
 **/
public class ForeignCooker implements Meau {
    @Override
    public void makeFood() {
        System.out.println("这是外国厨师做的西餐");
    }
}
