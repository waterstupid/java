package com.xiaofu.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 这是一个工具类
 * @author fmk
 * @date 2020/5/11
 **/
public class Utils {
    /**
     * 该方法用来将流关闭
     * @param targets
     */
    public static void closeAll(Closeable ... targets){
        for (Closeable target : targets) {
            if(target != null){
                try {
                    target.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
