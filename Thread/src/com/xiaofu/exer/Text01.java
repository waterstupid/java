package com.xiaofu.exer;

/**
 * 创建两个分线程，让其中一个线程输出1-100之间的偶数，另一
 * 个线程输出1-100之间的奇数。
 */
public class Text01 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i <100 ; i++) {
                    // 输出偶数
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName()+"--->"+i);
                    }

                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    if( i % 2 != 0){
                        System.out.println(Thread.currentThread().getName()+"-->"+i);
                    }
                }
            }
        }).start();

    }
}
