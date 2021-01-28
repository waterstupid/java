package com.xiaofu.hotelmanager;

/**
 * @author fmk
 * @date 2020/5/8
 **/
// 这是一个酒店类
public class Hotel {
    // 酒店类中有一个存储房间的二维数组
    // 假设该酒店为5层5列
    // 假设该酒店第1-2层为单人间，3-4层为双人间，第五层为豪华间，房间编号为101-105 201-205 301-305
    // 401-405 501-505
    Room[][] rooms = new Room[5][5];

    // 可以调用无参构造的时候，给这个二维数组赋值
    public Hotel() {
        // 遍历二维数组
        for (int i = 0; i < rooms.length; i++) {
            if (i < 2) {
                for (int j = 0; j < rooms[i].length; j++) {
                    rooms[i][j] = new Room((i + 1) * 100 + (j + 1), false, "单人间");
                }
            } else if (i < 4) {
                for (int j = 0; j < rooms[i].length; j++) {
                    rooms[i][j] = new Room((i + 1) * 100 + (j + 1), false, "双人间");
                }
            } else {
                for (int j = 0; j < rooms[i].length; j++) {
                    rooms[i][j] = new Room((i + 1) * 100 + (j + 1), false, "豪华间");
                }
            }
        }
    }

    /**
     * 这是一个打印酒店列表的方法
     */
    public void printHotel() {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print("[编号" + rooms[i][j].getNo() + ",空闲" + rooms[i][j].isFlag() +
                        ",类型" + rooms[i][j].getName() + "]");
            }
            System.out.println();
        }
    }
    /**
     * 该方法是一个订房的方法
     *
     * @param no
     */
    public void order(int no) throws RoomIsNotExits {
        // 首先通过房间编号得到这个房间
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if(rooms[i][j].getNo()==no){
                    // 房间被占用
                    if(rooms[i][j].isFlag()){
                        System.out.println("对不起，该房间已被占用，请选择下一间");
                    }else{
                        // 房间未被占用
                        System.out.println("恭喜你，订房成功");
                        rooms[i][j].setFlag(true);
                    }
                    return;
                }
            }
        }
        throw new RoomIsNotExits("对不起，你输入的房间号本酒店不存在");

    }
    public void check(int no) throws RoomIsNotExits {
        for (int i = 0; i < rooms.length; i++) {
            for(int j=0;j<rooms[i].length;j++){
                if(rooms[i][j].getNo()==no){
                    if(rooms[i][j].isFlag()){
                        // 表示这个房间已经被占用，可以退房
                        System.out.println("谢谢光临，退房成功");
                        rooms[i][j].setFlag(false);
                    }else{
                        System.out.println("对不起，退房失败，该房间未被占用");
                    }
                    return;
                }
            }
        }
        throw new RoomIsNotExits("对不起，你输入的房间号本酒店不存在");
    }
}
