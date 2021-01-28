package com.review01;

import java.io.Serializable;
// 如果没有实现Serializable接口,则会报异常
public class User implements Serializable{
    // 需要指定序列化版本号
    private static final long serialVersionUID = -6849794470754667711L;
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
