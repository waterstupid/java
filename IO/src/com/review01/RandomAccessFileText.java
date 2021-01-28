package com.review01;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 * 是一个随机存取文件流,直接继承Object,但是实现了DataOut和DataInput这两个接口
 * 所以是一个可读可写的类
 * 2.该类支持读取和随机写入文件
 */
public class RandomAccessFileText {
    @Test
    public void read(){
        RandomAccessFile ras = null;
        try {
            // 注意:第二个参数代表的意思是只能读取，不能修改
            ras = new RandomAccessFile("index","r");
            // 读取文件
            byte [] b = new byte[20];
            int readCount;
            while((readCount = ras.read(b)) != -1){
                System.out.println(new String(b,0,readCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ras != null) {
                // 关闭流
                try {
                    ras.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void read1(){
        RandomAccessFile ras = null;
        try {
            // 注意:第二个参数代表的意思是只能读取，不能修改
            ras = new RandomAccessFile("index","r");
            // 读取文件
            byte [] b = new byte[4];
            int count;
            // 将这个数组存储到ByteArrayInputStream中
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            while((count = ras.read(b)) != -1){
                out.write(b,0,count);
            }
            System.out.println(out.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ras != null) {
                // 关闭流
                try {
                    ras.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 该方法用来测试RandomAccessFile随机写的能力
     */

    @Test
    public void write(){
        RandomAccessFile raf = null;
        try {
            // 设置可读可写权限
            raf = new RandomAccessFile("index","rw");

            // 写,采用的是覆盖,但是不是全部覆盖，而是和指针有关,默认是从第一个指针来进行覆盖
            raf.write("xiaofu".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                // 关闭
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    @Test
    public void write1(){
        RandomAccessFile raf = null;
        try {
            // 设置可读可写权限
            raf = new RandomAccessFile("index","rw");
            // 可以用来设置插入指针,指的是从索引为3之后开始进行覆盖(包括3)
            raf.seek(3);
            // 写,采用的是覆盖,但是不是全部覆盖，而是和指针有关,默认是从第一个指针来进行覆盖
            raf.write("xiaofu".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                // 关闭
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 该方方法用来描述如何向文件中指定的位置插入数据
     */
    @Test
    public void insert(){
        RandomAccessFile raf = null;
        RandomAccessFile write = null;
        ByteArrayOutputStream out = null;
        try {
            raf = new RandomAccessFile("index","r");
            write = new RandomAccessFile("index","rw");
            // 设置节点
            raf.seek(3);
            out = new ByteArrayOutputStream();
            byte [] b =new byte[4];
            int readCount;
            while((readCount = raf.read(b)) != -1){
                out.write(b,0,readCount);
            }
            // 需要将节点设置回来
            write.seek(3);
            // 然后写入数据
            write.write("xiaofu".getBytes());
            write.write(out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                // 关闭流
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (write == null) {
                try {
                    write.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void insert01(){
        RandomAccessFile in = null;
        RandomAccessFile out = null;
        ByteArrayOutputStream write = null;
        try {
            in = new RandomAccessFile("index","r");
            out = new RandomAccessFile("index","rw");
            write = new ByteArrayOutputStream();

            in.seek(4);
            byte [] b = new byte[4];
            int count;
            while((count = in.read(b)) != -1){
                write.write(b,0,count);
            }

            out.seek(4);
            out.write("xiaofu".getBytes());
            out.write(write.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (write != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(write != null){
                try {
                    write.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }








    }




}
