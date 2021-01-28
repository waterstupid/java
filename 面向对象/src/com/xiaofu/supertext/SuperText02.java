package com.xiaofu.supertext;

/**
 * 该程序用来测验super什么时候不能省略
 *
 * @author fmk
 * @date 2020/5/5
 **/
public class SuperText02 {
    public static void main(String[] args) {
        Animal1 a=new Cat1("小猫");
        a.doSome();// 动物 小猫 小猫



    }

}
class Animal1{
    String name="动物";
    public Animal1(){
    }
    public void doSome(){

    }

}
class Cat1 extends Animal1{
    // 父类和子类中有同名的方法
    String name;

    public Cat1(String name){
        this.name=name;
    }
    public Cat1(){

    }

    @Override
    public void doSome() {
        System.out.println(super.name);
        System.out.println(this.name);
        System.out.println(name);
    }
}

