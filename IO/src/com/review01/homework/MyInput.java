package com.review01.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create a program named MyInput.java: Contain the methods for reading int,
 * double, float, boolean, short, byte and String values from the keyboard.
 */
public class MyInput {
    /**
     *
     * @return 返回从键盘输入的字符串
     */
    public static String readString(){
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        try {
            String value = buffer.readLine();
            return value;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @return 从键盘中返回int
     */
    public static Integer readInt(){
        return Integer.valueOf(readString());
    }
    public static Byte readByte(){
        return Byte.valueOf(readString());
    }
    public static Short readShort(){
        return Short.valueOf(readString());
    }
    public static Boolean readBoolean(){
        return Boolean.valueOf(readString());
    }
    public static Float readFloat(){
        return Float.valueOf(readString());
    }
    public static Double readDouble(){
        return Double.valueOf(readString());
    }

    public static void main(String[] args) {
        System.out.println(readString());


    }







}
