package com.xiaofu.homework;

/**
 * 该程序用来测验内存如何去画
 * 要求：画出下面程序的内存图
 * @author fmk
 * @date 2020/5/3
 **/
public class HomeWork01 {
    A a;
    public static void main(String[] args) {
        HomeWork01 home=new HomeWork01();
        A a1=new A();
        B b1=new B();
        C c1=new C();
        D d1=new D();
        home.a=a1;
        home.a.b=b1;
        home.a.b.c=c1;
        home.a.b.c.d=d1;
        System.out.println(home.a.b.c.d.no);

    }

}
class A{
    B b;
}
class B{
    C c;
}
class C{
    D d;
}
class D{
    int no=10;
}




