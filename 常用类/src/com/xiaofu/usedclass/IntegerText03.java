package com.xiaofu.usedclass;

/**
 * 该案列用来测试整数型常量池
 * 整数型常量池：因为整数也很常用，所以SUN公司在方法区内存中也准备一块整数型常量池，范围是[-128-127]
 * 在整个范围内的数据不用在堆内存创建对象，从整数型常量池中直接获取
 * @author fmk
 * @date 2020/5/9
 **/
public class IntegerText03 {
    public static void main(String[] args) {
        Integer i1=128;
        Integer i2=128;
        // 这个结果是false，因为128不在整数型常量池中，所以会在堆内存中创建出两个不一样的对象
        System.out.println(i1==i2);
        // 这个结果是true，因为10在整数常量池中存在，所以两个引用中保存的内存地址都是10在整数
        // 型常量池中的内存地址
        Integer i3=10;
        Integer i4=10;
        System.out.println(i3==i4);




    }
}
