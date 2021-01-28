package com.xiaofu.hotelmanager;

import java.util.Scanner;

/**
 * @author fmk
 * @date 2020/5/8
 **/
public class Text {
    public static void main(String[] args) {
        Hotel hotel=new Hotel();
        while(true){
            System.out.println("欢迎来到本酒店：");
            System.out.println("本系统提供一下几个功能:输入1查看酒店的所有房间,输入2进入到订房系统，输入3进入退房系统," +
                    "输入4退出该系统");
            Scanner s=new Scanner(System.in);
            String value=s.next();
            if(value.equals("1")){
                hotel.printHotel();
            }else if(value.equals("2")){
                System.out.println("请输入要订房的房间号:");
                Scanner s1=new Scanner(System.in);
                try {
                    hotel.order(Integer.valueOf(s1.next()));
                } catch (RoomIsNotExits roomIsNotExits) {
                    roomIsNotExits.printStackTrace();
                }
            }else if(value.equals("3")) {
                System.out.println("请输入需要退房的房间号:");
                Scanner s2 = new Scanner(System.in);
                try {
                    hotel.check(Integer.valueOf(s2.next()));
                } catch (RoomIsNotExits roomIsNotExits) {
                    roomIsNotExits.printStackTrace();
                }
            }else if(value.equals("4")){
                return;
            }
        }

    }
}
