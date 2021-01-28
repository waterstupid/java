package com.xiaofu.interfacetext;

import javax.print.attribute.standard.MediaSize;

public class ShiXian implements InterfaceText02 {
    @Override
    public void doOther() {


        System.out.println(NAME);

    }

    @Override
    public void doHomework() {
        System.out.println("我要做作业了");
    }
}
