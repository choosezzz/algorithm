package newcoder;

import java.util.Stack;

/**
 * @author dingshuangen
 * @date 2020/5/11 1:06
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Offer021 {

    /**
     * 运行时间：10ms
     * <p>
     * 占用内存：9396k
     *
     * 借助栈来模拟实际的操作顺序
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {

        if (popA == null || popA == null
                || popA.length <= 0 || pushA.length <= 0
                || popA.length != pushA.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            //判断当前的栈顶元素是否在弹出序列里
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
