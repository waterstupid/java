package com.xiaofu.usedclass;

import java.math.BigDecimal;

/**
 * 该案列用来测试BigDecimal
 * BigDecimal是为了满足财务要求才有的一个类，精度很高
 * @author fmk
 * @date 2020/5/9
 **/
public class BigDecimalText01 {
    public static void main(String[] args) {
        BigDecimal b1=new BigDecimal(100000);
        BigDecimal b2=new BigDecimal(20000);
        // 加
        b1.add(b2);
        // 除
        b1.divide(b2);



    }
}
