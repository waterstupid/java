package com.xiaofu.atomic;
class Ticket{
    int ticket = 100;
    public void sellTicket(){
        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+"\t 卖票,票号为:"+ticket--);
        }
    }



}
public class ThreadDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for(int i = 0; i<3;i++){
            new Thread(() ->{while(true)ticket.sellTicket();},String.valueOf(i)).start();
        }




    }

}
