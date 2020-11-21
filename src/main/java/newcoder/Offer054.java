package newcoder;

import java.util.ArrayDeque;

/**
 * @Author dingshuangen
 * @Date 2020/11/21 14:36
 */
public class Offer054 {

    int[] count = new int[128];
    ArrayDeque<Character> queue = new ArrayDeque<>();

    /**
     * 运行时间：11ms
     * 占用内存：9756k
     */
    public void Insert(char ch) {
        count[ch]++;
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
