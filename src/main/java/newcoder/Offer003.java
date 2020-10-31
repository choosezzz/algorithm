package newcoder;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author dingshuangen
 * @date 2020/5/7 22:28
 * <p>
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Offer003 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode == null){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    public ArrayList<Integer> printListFromTail(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null){
            return result;
        }
        while (listNode != null){
            result.add(listNode.val);
            listNode = listNode.next;
        }
        int size = result.size();
        for (int i = 0; i < size / 2; i++) {
            Integer tmp = result.get(i);
            result.set(i, result.get(size - i - 1));
            result.set(size - i - 1, tmp);
        }
        return result;
    }
}
