package newcoder;

import java.util.Stack;

/**
 * @author dingshuangen
 * @date 2020/5/7 23:16
 *
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Offer005 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
