package newcoder;

import java.util.ArrayDeque;

/**
 * @Author dingshuangen
 * @Date 2020/11/21 14:36
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 返回值描述:
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 */
public class Offer054 {

    /**
     * 统计数组，字符流，最多为128
     */
    int[] count = new int[128];
    /**
     * 队首元素为只出现一次的字符
     */
    ArrayDeque<Character> queue = new ArrayDeque<>();

    /**
     * 运行时间：11ms
     * 占用内存：9756k
     */
    public void Insert(char ch) {
        //统计数量
        count[ch]++;
        //添加到队尾
        queue.add(ch);
        //队首元素出现的次数大于1，则出队
        while (!queue.isEmpty() && count[queue.peek()] > 1) {
            queue.poll();
        }
    }

    public char FirstAppearingOnce() {
        if (queue.isEmpty()) {
            return '#';
        }
        return queue.peek();

    }
}
