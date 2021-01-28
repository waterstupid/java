package com.xiaofu;

import java.util.*;

/**
 * 该类用来深入了解Collection接口中的
 * contains(Object value)方法
 * remove(Object value)方法
 * 结论：向集合当中添加的元素所在的类都要重写equals()方法，要不然会出问题，另外集合当中保存的是内存地址
 *
 */
public class CollectionText03 {
    public static void main(String[] args) {
        Collection coo=new HashSet();
        coo.add(300);
        coo.add(100);
        coo.add(200);
        coo.add(400);
        coo.add(500);
        coo.add(600);
        coo.add(900);
        Iterator it = coo.iterator();
        while(it.hasNext()){
            Object value = it.next();
            System.out.println(value);
        }
        //创建集合
        Collection co=new ArrayList();
        String name=new String("小红");
        co.add(name);
        String name2=new String("小红");
        /*
        注意：这个结果是true,因为contains底层是调用了equals()方法，来判断两个对象是否相等
        因为String类已经重写了equals()方法，用来比较的是内容
         */
        co.contains(name2);//
        User user1=new User("jack");
        co.add(user1);
        User user2=new User("jack");
        /*
        注意：这里的结果是false，因为User类中没有去重写equals()方法，所有调用的还是Object类中的equals()
        方法，而Object类中的equals()方法是比较两个引用的内存地址，明显user1和user2的内存地址不同
        co.contains(user2); false
         */
        coo.contains(user2);//因为这个时候已经重写了equals()方法

        //remove()底层也是调用了equals()方法
        coo.remove(user2);
        System.out.println(coo.size());//0






    }
}
class User{
    String name;
    public User(String name){
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if(o==null) return false;
        if(o==this) return true;
        User user=(User)o;
        if(this.name.equals(user.name)) return true;
        return false;
    }


}
