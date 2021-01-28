package com.review01.homework;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 获取dbcp.txt上每个字符出现的次数,并将保存到一个文件中
 */
public class StringOfNumber {
    /**
     * 该方法用来统计一个文本中每个字符出现的次数
     * @param srcName 需要统计的文件名
     */
    public static void statistics(String srcName,String targetName){
        Map<Character,Integer> map = new HashMap<>();
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            // 造流
            reader = new BufferedReader(new FileReader(srcName));
            writer = new BufferedWriter(new FileWriter(targetName));
            // 读取
            int readCount;
            while((readCount = reader.read()) != -1){
                // 将读取出来的字节转换一个字符
                Character data =(char)readCount;
                // 判断集合中是否有该元素，如果有则在原来的基础上加1就行
                if(map.containsKey(data)){
                    map.put(data,map.get(data)+1);
                }else{
                    // 如果没有这个元素
                    map.put(data,1);
                }
            }
            System.out.println(map);
            // 然后将保存在map中数据写入到文件中
            Set<Character> set = map.keySet();
            for (Character key : set) {
                writer.write(key+":");
                Integer value = map.get(key);
                writer.write(value+"\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                // 关闭流
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        statistics("IO//dbcp.txt","IO//count.txt");

    }


}
