package com.xiaofu.data;

public class FirstData {
    public static void main(String[] args) {
        /**
         *  1.什么是数据类型？
         *  java中的数据类型分为8中，byte,short,int,long,float,double,boolean,char
         *  分别占用的空间为:1 2 4 8 4 8 1 2
         *  数据类型就是程序在运行状态的时候应该给某一个变量分配多大的内存空间
         *
         *  2.在类型转换的时候需要遵循哪些规则
         *  a.8种数据类型除了boolean类型之外，其他7种数据类型都可以相互转换
         *  b.byte,short,char 在没有超出它们范围的数值的时候，可以直接赋值
         *  c.在7种不同类型的数值进行运算的时候，会将所有数据类型转换最大的那一种数据类型
         *  然后再进行运算
         *  d.大容量转换为小容量叫做强制类型转换，小容量转换为大容量的数值叫做自动类型转换
         *  e.大容量转换为小容量的时候可会发生精度的丢失
         */
        // 没有超过byte的取值范围，可以进行直接赋值
        // byte ---> [-127-128]
        byte b = 110;
        // 如果超过了byte的取值范围，那么就需要将int类型的数据转换为byte类型的数据
        byte c = (byte) 128;
        System.out.println("c="+c);


        // short ---> [-32678-32767],没有超出2个字节的范围
        short d = 32767;

        // 需要将int类型的数值转换为short类型，但是可能为失去精度
        short e = (short) 32768;

        System.out.println(e);

        // 多种数据类型在做运算的收，会将所有数据类型转换为最大的那一个
        // 注意所有字面量数值默认是int类型的数据
        byte f = 10;
        short g = 20;
        int aa=50;
        float bb= 15.5f;
        double cc= 38.3;
        // 可以看出来实际四者相加是double类型的数据
        double dd = f+g+aa+bb+cc;
        System.out.println(dd);

        long count = 3467823748237345453l;
        // 将long类型的数据转换为int,这里会发生精度丢失
        int value = (int) count;
        System.out.println(value);

        // char 类型
        // char 类型只能存储2个字节大小的数据
        // 而 1个中刚好对应2个字节
        char i = '就';
        // 将字符类型的数据转换为int,也就是ASCII码值
        int ci= i;
        System.out.println(ci);
        // 将char类型的数据自动转换为int类型的数据
        char kk= 'a';
        int ckk =kk;
        System.out.println(ckk);















    }




}
