package Math;

public class Text01 {
    public static void main(String[] args) {
        // Math中的方法
        // round方法 加0.5取整
        System.out.println(Math.round(2.4));// 2
        System.out.println(Math.round(2.5)); // 3
        System.out.println(Math.round(-2.4));// -2
        System.out.println("----------------------------------");

        // floor()方法 向下取整
        System.out.println(Math.floor(1.8)); // 向下取整  1.0
        System.out.println(Math.floor(-1.8)); // -2.0
        System.out.println(Math.floor(-1.3)); // -2.0

        System.out.println("-----------------------------------");
        // ceil()方法 向上取整
        System.out.println(Math.ceil(1.4)); //2.0
        System.out.println(Math.ceil(1.5)); //2。0
        System.out.println(Math.ceil(-1.4));// -1.0
        System.out.println(Math.ceil(-1.5)); // -1.0


    }





}
