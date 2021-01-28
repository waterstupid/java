package com.xiaofu.usedclass;

/**
 * 该案例用来测试枚举
 * 1.枚举也是引用数据类型，其编译后也是生成class字节码文件
 * 2.枚举中只能出现变量，且变量的名字需要大写
 * 3.当方法的返回值不止一种，且可以一枚一枚列举出来的时候，这个时候就可以选择使用枚举，不推荐
 * 使用int类型作为返回值，因为可读性太差
 * @author fmk
 * @date 2020/5/9
 **/
public class EnumText01 {
    public static void main(String[] args) {
        Type sum = sum(10, 0);
        System.out.println(sum==Type.SUCCESS ? "计算成功":"计算失败");

    }
    public static Type sum(int a, int b){
        try{
            System.out.println(a / b);
            return Type.SUCCESS;
        }catch(Exception e){
            return Type.FALSE;
        }
    }
}
// 这是一个枚举
enum Type{
    SUCCESS,FALSE;
}
