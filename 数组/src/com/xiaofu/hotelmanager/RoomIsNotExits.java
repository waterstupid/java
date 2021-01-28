package com.xiaofu.hotelmanager;

/**
 * @author fmk
 * @date 2020/5/8
 **/
public class RoomIsNotExits extends Throwable {
    public RoomIsNotExits() {
    }

    public RoomIsNotExits(String message) {
        super(message);
    }
}
