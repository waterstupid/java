package review;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateText01 {
    public static void main(String args []) throws ParseException {
        // 获取昨天的时间
        // 获取今天离 1970年的毫秒数
        long time = System.currentTimeMillis();
        // 这就是昨天的时间
        Date date = new Date(time - 24 * 60 * 60 * 1000);
        // 使用SimpleDateFormat()来将日期进行格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String yesterday = sdf.format(date);
        System.out.println(yesterday);

        // 同样可以将一个String转换为日期
        // 注意:字符串定义的日期格式要与SimpleDateFormat()中定义的格式一致
        // 要不然会出现转换异常这个问题
        String now = "2020-10-23 12:17:30";
        Date parse = sdf.parse(now);
        System.out.println(parse);




    }



}
