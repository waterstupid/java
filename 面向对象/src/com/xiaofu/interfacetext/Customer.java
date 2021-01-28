package com.xiaofu.interfacetext;

/**
 * 这是一个顾客类
 * @author fmk
 * @date 2020/5/6
 **/
public class Customer {
    private Meau meau;

    // 这个方法中需要面向接口去编程
    // 而不能面向具体去编程，顾客既可以点中餐又可以点西餐
    // 所以这里应该是将一个接口当作形参传递进去
    // 这样就降低了顾客和厨师之间的耦合度，顾客和厨师只需要面向接口去实现
    // 面向接口编程也提高了程序的可扩展性，如果程序需要扩展，顾客想要吃意大利菜
    // 如果这里不是面向接口编程的话，需要改动源代码，加上一个方法
    // 但是如果这里是面向接口编程，就不需要面向接口，只需要创建一个意大利菜类，让这个类去实现Meau接口
    
    public void order(Meau meau){
        meau.makeFood();
    }

    public Meau getMeau() {
        return meau;
    }

    public void setMeau(Meau meau) {
        this.meau = meau;
    }

    public Customer() {
    }

    public Customer(Meau meau) {
        this.meau = meau;
    }
}
