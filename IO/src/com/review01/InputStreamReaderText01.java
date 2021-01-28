package com.review01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 该类用来探讨字符字符编码和解码的方式
 * 1.InputStreamReader:是将一个字节输入流转换为字符输入流,所以可指定其解码格式
 * 2.什么是编码和解码
 * 计算机底层都是采用二进制的形式来存储数据，所以我们平时中文和英文以及标点符号是如何存储到计算机的
 * 这个时候就涉及到一个编码问题，我们需要将这些人类认识的文字转换为计算机认识的二进制,所以早期出现了一些
 * 字符集:
 * ASCII:这是美国制定的一个字符集，用来表示26个英文字母以及各种标点符号,一般用一个字节的7位表示就足够了,后来随着
 * 计算机的发展，发展到欧洲，这时候又出现了一个字符集:
 * ISO8859-1:这是欧洲流行的一种字符集,当中除了一些常见的英文字母以及标点符号,还有一些拉丁文码
 * 后来计算机发展到了亚洲,此时一个字节表示个数远远满足不了中文的需求，于是又出现了几种有关中文的字符集:
 * GB2312:一种支持中文的编码,最多用两个字节进行编码
 * GBK:GB2312的升级版，融合了更多的中文字符，也是采用两个字节来进行编码
 * Unicode:目前融合了世界上所有的字符。每个字符都有唯一的一个编码，所有字符才采用两个字节来进行编码
 * UTF-8:是Unicode字符集的一种实现方式，一般采用1-4个可变长字节来进行编码
 * 注意:Unicode 不等于 utf-8
 * unicode:只是一个庞大的字符集,具体采用什么编码格式还是要取决你使用的编码格式
 *
 *
 *
 *
 */
public class InputStreamReaderText01 {
    public static void main(String[] args) {
        InputStreamReader in = null;
        try {
            // 构造方法有两个参数
            // 1.用到那个输入字节流  2.将字节流转换为字符流用到的解码格式
            // 采用utf-8的方式来对字节流进行解码,这里的解码方式是取决于文件保存时采用的编码方式
            // in = new InputStreamReader(new FileInputStream("IO//dbcp.txt"),"utf-8");
            // 如果采用其他的方式解码就会出现乱码情况
            in = new InputStreamReader(new FileInputStream("IO//dbcp.txt"),"GBK");
            // 读
            char [] c = new char[4];
            int readCount;
            while((readCount = in.read(c)) != -1){
                System.out.print(new String(c,0,readCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                // 关
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }



    }



}
