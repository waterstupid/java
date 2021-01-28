package com.xiaofu.hotelmanager;

/**
 * @author fmk
 * @date 2020/5/8
 **/
// 这是一个房间类
public class Room {
    private int no;
    private boolean flag;
    private String name;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room() {
    }

    public Room(int no, boolean flag, String name) {
        this.no = no;
        this.flag = flag;
        this.name = name;
    }
}
