package com.doublelinked;

import java.util.ArrayList;
import java.util.List;

/**
 * 该程序用来测试自己写的双向链表
 * @author fmk
 * @date 2020/5/7
 **/
public class Text {
    public static void main(String[] args) throws CannotFindElementException {
        DoubleLinkList linkList=new DoubleLinkList();
        linkList.add("jack");
        linkList.add("john");
        linkList.add("mike");
        linkList.add("zs");
        linkList.add("ls");
        linkList.add(123);
        System.out.println(linkList.size());// 6
        /*for (int i = 0; i <linkList.size() ; i++) {
            System.out.println(linkList);

        }*/
        /*System.out.println(linkList.get(2));// Mike
        System.out.println(linkList.get(0));
        */

        // 用来测试get()方法
        for (int i = 0; i <linkList.size() ; i++) {
            System.out.println(linkList.get(i));
        }
        // 用来测试remove()方法
        System.out.println(linkList.remove(123));
        System.out.println("==================");
        for (int i = 0; i <linkList.size() ; i++) {
            System.out.println(linkList.get(i));
        }
        System.out.println(linkList.remove("jack"));
        System.out.println("===========================");
        for (int i = 0; i <linkList.size() ; i++) {
            System.out.println(linkList.get(i));
        }
        System.out.println(linkList.remove(1));
        System.out.println("*********");
        for (int i = 0; i <linkList.size() ; i++) {
            System.out.println(linkList.get(i));
        }

        /*int [][] a=new int[3][4];
        for (int i = 0; i < a.length; i++) {
          for(int j=0;j<a[i].length;j++){
              System.out.println(a[i][j]);
          }
        }*/
    }

}
