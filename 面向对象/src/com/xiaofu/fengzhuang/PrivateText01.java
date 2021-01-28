package com.xiaofu.fengzhuang;

/**
 * 该程序用来测试封装的好处
 * @author fmk
 * @date 2020/5/3
 **/
public class PrivateText01 {
    public static void main(String[] args) {
        // 创建对象
        Person per=new Person();
        // per.age=-100;
        // 这里可以随意访问age属性，但是人的年龄不可能为负数，所以这里就出现了问题
        // System.out.println(per.age);
        // Person是一个封装类，不能随意访问其中的属性
        // 只能通过set()和get()方法去访问
        per.setAge(50);
        System.out.println(per.getAge());// 50
        // 这样也是不行的
        per.setAge(-100);
        System.out.println(per.getAge());// 50
    }


}
class Person{
    // 这是没有封装之前
    // 这是一个实例变量，必须通过对象去访问
    // int age;
    // 然后对这个属性进行封装，并提供set()和get()方法
    private int age;
    // 这是set()方法,在java中，java规范建议我们这样写set()方法
    // [修饰符列表] void set+首字母大写属性名(xxx属性){ this.属性=xxx属性}
    public void setAge(int age){
        //那么这里就可以用一个语句来进行判断
        if(age>150 || age<0){
            System.out.println("对不起，您输入的年龄不合法");
        }else{
            this.age=age;

        }
    }
    // 这是get()方法，在Java中，java规范同样建议我们这样写get()方法
    // [修饰符列表] 返回值类型 get+属性名首字母大写(){ return this.属性名}
    public int getAge(){
        return this.age;
    }
}
