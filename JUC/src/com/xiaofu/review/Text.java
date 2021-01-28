package com.xiaofu.review;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Text {
    public static void main(String[] args) {
        int i = 2;
        int result=0;
        switch (i){
            case 2:
                result+=i*2;
                break;
            case 3:
                result+=i*3;
                break;
        }
        System.out.println(result);


    }

    private static void handler() {
        try{
            throw new FileNotFoundException();
        }catch (FileNotFoundException e1){
            System.out.println(1);
        }
        catch (IOException e) {
            System.out.println(2);
        } finally {
            System.out.println(111);
        }
    }
}
