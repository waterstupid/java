package com.collection.linked;

public class Linked {
    public static void main(String[] args) {
        Link link=new Link();
        link.add("abc");
        link.add("cde");
        link.delete("abc");
        System.out.println(link.size());



    }

}
