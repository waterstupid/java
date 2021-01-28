package com.xiaofu;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 该程序用来测试往HashMap中存储元素的的时候，元素所在类需要重写equals()和hashCode()方法
 */
public class HashMapText02 {
    public static void main(String[] args) {
        Map<Customer,Integer> map=new HashMap<>();
        //存储元素
        Customer customer=new Customer("jack");
        Customer customer1=new Customer("jack");
        Customer customer2=new Customer("king");
        //重写了equals()方法，但是美没有重写hashCode()方法
        System.out.println(customer.equals(customer1));
        map.put(customer,1);
        map.put(customer1,2);
        System.out.println("hashCode = "+customer.hashCode());//hashCode = 284720968
        System.out.println("hashCode = "+customer1.hashCode());//hashCode = 189568618
        System.out.println("hashCode = "+customer2.hashCode());//hashCode =
        System.out.println(map.size());//结果本应该是1，但是因为没有重写hashCode()方法，导致两个
        //相同的对象却放在数组中不同的链表当中,所以现在结果为2，重写之后的结果就是1





    }

}
//这是一个实体javaBean
class Customer{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
