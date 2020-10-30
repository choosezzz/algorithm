package main.java.newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/9 23:00
 * <p>
 * int -> 4byte -> 32bit -> 最高位符号位 0 正 1 负
 * Integer.MAX_VALUE = 01111111111111111111111111111111
 * Integer.MIN_VALUE = 10000000000000000000000000000000
 * <p>
 * -1 -> 原码：10000000000000000000000000000001
 * -> 反码：11111111111111111111111111111110
 * -> 补码：11111111111111111111111111111111
 *
 * 负数的补码等于反码+1，负数的反码为除符号位之外按位取反
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 6 ->                               110
 * -6 -> 11111111111111111111111111111010
 */
public class Offer011 {

    /**
     * 运行时间：13ms
     * 占用内存：9408k
     *
     * num - 1即将num对应的二进制数的最后一位1后面的0变为1，最后一位1变为0
     * num & (num-1)即将num最后一位1变为0
     * @param num
     * @return
     */
    public int NumberOf1(int num) {
        int count = 0;
        while (num != 0) {
            //每次减少一位1
            num &= (num - 1);
            ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Offer011().NumberOf1(1));
    }
}
