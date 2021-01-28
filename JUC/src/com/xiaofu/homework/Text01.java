package com.xiaofu.homework;

/**
 * 给定⼀一个按开始时间从⼩小到⼤大排序的时间区间集合，请将重叠的区间合并。
 * 时间区间集合⽤用⼀一个⼆二维数组表示，
 * ⼆二维数组的每⼀一⾏行行表示⼀一个时间区间（闭区 间），
 * 其中 0 位置元素表示时间区间开始，1 位置元素表示时间区间结束。
 * 例 1：输⼊入：[ [1, 3], [2, 6], [8, 10], [15, 18] ]
 * 返回： [ [1, 6], [8, 10], [15, 18]]
 * 解释：时间区间 [1, 3] 和 [2, 6] 有部分重叠，合并之后为 [1, 6]
 * 例例 2：输⼊：[[1, 4], [4, 5]]          返回：[[1, 5]]
 * 解释：时间区间[1，4] 和 [4，5]重叠了了⼀一个时间点，合并之后为 [1，5]
 * 需要实现的⽅方法原型：int[][] merge(int[][] intervals)
 */
public class Text01 {
    public int[][] merge(int [][] intervals){

        if (intervals.length == 0) {
            return null;
        }
        int[][] midleValue = new int[intervals.length][];
        int returnValueIndex = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] leftOne = midleValue[returnValueIndex];
            if (i == 0) {
                leftOne = intervals[0];
            }
            int[] rightOne = intervals[i + 1];
            if (leftOne[1] >= rightOne[0]) {
                // 需要合并
                int[] combineOne = new int[2];
                combineOne[0] = leftOne[0];
                combineOne[1] = leftOne[1] > rightOne[1] ? leftOne[1] : rightOne[1];
                midleValue[returnValueIndex] = combineOne;
            } else {
                midleValue[returnValueIndex++] = leftOne;
                midleValue[returnValueIndex] = rightOne;
            }
        }
        //去掉null值
        int[][] returnValue = new int[returnValueIndex + 1][];
        for (int i = 0; i <= returnValueIndex; i++) {
            returnValue[i] = midleValue[i];
        }
        return returnValue;
    }
    /**
     * 给定⼀一个⾮非空字符串串 s 和⼀一个缩写 abbr，请校验它们是否匹配。
     * 假设字符串串中只包含⼩写字⺟母，
     * 缩写中只包含⼩写字⺟和数字。
     * 缩写中的数字 表示其缩略略的字符数；连续多位数字表示⼀一个多位数。
     * 例如，字符串串 “word” 的缩写有且仅有以下这些：[“word", "1ord", "w1rd", "wo1d", "wor1", "2rd",
     * "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", “4"]。
     * 例例 1：输⼊入：s = “internationalization"，abbr = "i12iz4n"          返回：true
     * 解释：abbr 中的 12 表示有⼗十⼆二个字符被缩略略了了。
     * 例 2：输⼊入：s = “apple"，abbr = “a2e"
     * 返回：false
     * 需要实现的⽅方法原型：boolean valid(String word, String abbr)
     *
     */
    public boolean valid(String word,String abbr){
        char[] words = word.toCharArray();
        char[] abbrs = abbr.toCharArray();
        // 从缩写中读取，如果是英文，则去字符串数组中匹配，如果是数字，则偏移数字量
        String numberTemp = "";
        int wordsIndex = 0;
        for (char temp : abbrs) {
            if (Character.isDigit(temp)) {
                numberTemp += temp;
                continue;
            } else {
                if (!"".equals(numberTemp)) {
                    wordsIndex += Integer.parseInt(numberTemp);
                    numberTemp = "";
                }
                if (wordsIndex >= words.length) {
                    return false;
                }
                if (temp == words[wordsIndex]) {
                    wordsIndex++;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return wordsIndex == words.length;
    }



    public static void main(String[] args) {
        System.out.println((char)122);



    }
}
