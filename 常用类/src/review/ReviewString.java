package review;

public class ReviewString {
    public static void main(String[] args) {
        String s="http://localhost:8080/book/";
        // 1. 对split方法的实验
        /*
        输出结果
        http
        //localhost
        8080/book/
         */
        for (String s1 : s.split(":")) {
            System.out.println(s1);
        }
        // 2.对replace方法的实验
        /*
         实验结果:name=value&name=value&name=value
         */
        String value="name=value%name=value%name=value";
        System.out.println(value.replaceAll("%", "&"));
    }
}
