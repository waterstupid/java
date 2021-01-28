package com.xiaofu.chatRoom;

/**
 * @author fmk
 * @date 2020/5/15
 **/
public class Text {
    public static String send(){
        StringBuilder sb=new StringBuilder();
        int i=5;
        while(i>0){
            sb.append("xiaohong");
            i--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(send());
    }
}
