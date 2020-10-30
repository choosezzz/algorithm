package main.java.newcoder;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author dingshuangen
 * @date 2020/4/27 22:58
 */
public class SolutionAll {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }
        ArrayList<Integer> tmp = new ArrayList<>();
        while (listNode != null) {
            tmp.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i = tmp.size() - 1; i >= 0; i--) {
            result.add(tmp.get(i));
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
     * 则重建二叉树并返回
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        //边界条件
        if (pre == null || pre.length <= 0 || in == null || in.length <= 0) {
            return null;
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd,
                                           int[] in, int inStart, int inEnd) {

        //先序遍历为空或者中序遍历为空
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //先序遍历第一个为根节点
        TreeNode root = new TreeNode(pre[preStart]);

        for (int index = inStart; index <= inEnd; index++) {
            //查找到中序遍历根节点位置 index
            if (in[index] == pre[preStart]) {
                //中序遍历左子树长度
                int count = index - inStart;
                //构建左子树 ，中序遍历根节点前面部分
                root.left = reConstructBinaryTree(pre, preStart + 1, preStart + count, in, inStart, index - 1);
                //构建右子树 ，中序遍历根节点后面部分
                root.right = reConstructBinaryTree(pre, preStart + 1 + count, preEnd, in, index + 1, inEnd);
                break;
            }
        }
        return root;
    }

    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
     * 思路：stack1永远负责push数据，stack2负责pop数据
     * 当stack2为空的时候，将stack1数据全部出栈，stack2入栈（反转顺序）
     */
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.push(node);
    }

    public static int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     *
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int[] array) {

        if (array == null || array.length <= 0) {
            return 0;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，
     * 请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
     * n<=39
     * 递归时间复杂度 O(n^2) 循环时间复杂度O(n)
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacci2(int n) {
        int n1 = 0;
        int n2 = 0;
        int fib = 1;
        for (int i = 2; i <= n; i++) {
            n1 = n2;
            n2 = fib;
            fib = n1 + n2;
        }
        return fib;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {

        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);

    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {

        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * @param m >= 0
     * @return
     */
    public static int NumberOf1(int m) {
        int count = 0;
        while (m != 0) {
            if ((m & 1) == 1){
                ++count;
            }
            m >>= 1;
        }
        return count;
    }
    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * @param num 任意整数
     * @return
     */
    public static int numberOf1(int num){
        int count = 0;
        while ( num !=0)  {
            //每次减少一位1
            num &= (num - 1) ;
            ++count;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(NumberOf1(6));
        System.out.println(numberOf1(-6));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(2));
    }
}
