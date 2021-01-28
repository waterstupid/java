package com.xiaofu.constructor;

/**
 *该程序用来检验构造方法的一些问题，虽然对现在的我来说，很简单，但是还是要认真对待
 * @author fmk
 * @date 2020/5/3
 **/
public class ConstructorText01 {
    public static void main(String[] args) {
        //new 运算符，调用无参构造方法
        Student stu=new Student();
        System.out.println(stu.name);//null

    }
}
// 这是一个学生类
class Student{
    //这是一个实例变量
    String name;
    // 这里没有出现任何构造器，但是系统会默认提供一个空构造器
    // 实例变量一般在构造方法被调用的时候初始化，基本数据类型默认值向0看起，引用数据类型向null看齐
    // 这是一个有参构造，注意，如果出现了有参构造，那么系统是不会再提供无参构造的
    public Student(String name){
        this.name=name;
    }
    // 这是一个有参构造
    public Student(){
        //构造方法中是会将实例变量赋上默认值的
        this.name=null;
    }
    // 构造方法是可以方法重载的，方法名相同，但是方法的形参列表类型，个数，顺序可以不相同

}