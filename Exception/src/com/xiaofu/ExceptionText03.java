package com.xiaofu;

/**
 * 该案例用来测试方法覆盖和异常的关系
 * @author fmk
 * @date 2020/5/10
 **/
public class ExceptionText03 {
    public static void main(String[] args) {



    }
}
class Animal{
    public void doSome(){
    }
}
class Cat extends Animal{
    // 注意重写之后的方法不能比原方法抛出更多的异常
    /*public void doSome() throws Exception {
        super.doSome();
    }*/

}