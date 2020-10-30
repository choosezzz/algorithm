package main.java.newcoder;

import java.util.Stack;

/**
 * @author dingshuangen
 * @date 2020/5/11 0:22
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 * <p>
 * 运行时间：16ms
 * 占用内存：9392k
 * <p>
 * 思路：两个数组，一份存放正常数据，一份存放当前最小值，min()直接从数组末尾取值
 */
public class Offer020 {

    /**
     * 记录正常数据
     */
    private int size = 0;
    private int[] table = new int[16];

    /**
     * 记录当前最小值数据
     */
    private int minSize = 0;
    private int[] minTable = new int[16];

    public void push(int node) {

        if (size == table.length) {
            table = expansion(table);
        }
        table[size++] = node;
        if (minSize == minTable.length) {
            minTable = expansion(minTable);
        }
        //最小值数组为空，直接存入数组，否则判断当前最小值是否小于新push的值
        if (minSize == 0) {
            minTable[minSize++] = node;
        } else if (min() >= node) {
            //判断条件为>=，为了保证pop()时能够进行判断最小值栈是否需要同时出栈
            minTable[minSize++] = node;
        }
    }

    public void pop() {
        if (size == 0) {
            return;
        }
        //栈顶元素一样则都需要出栈
        if (top() == min()) {
            minSize--;
        }
        size--;
    }

    public int top() {
        if (size == 0) {
            return -1;
        }
        return table[size - 1];
    }

    public int min() {
        if (minSize == 0) {
            return -1;
        }
        System.out.println(minTable[minSize - 1]);
        return minTable[minSize - 1];
    }

    private int[] expansion(int[] target) {
        int[] arr = new int[target.length * 2];
        for (int i = 0; i < target.length; i++) {
            arr[i] = target[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        Offer020 stack = new Offer020();
        stack.push(3);
        stack.min();
        stack.push(4);
        stack.min();
    }

    /**
     * 运行时间：10ms
     * 占用内存：9404k
     *
     * 用栈实现
     */
    public static class Solution {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public void push(int node){
            stack.push(node);
            if (minStack.isEmpty()){
                minStack.push(node);
            }else if (minStack.peek() >= node){
                minStack.push(node);
            }
        }

        public int pop(){
            int pop = stack.pop();
            if (!minStack.isEmpty() && pop == minStack.peek()){
                minStack.pop();
            }
            return pop;
        }

        public int top(){
            return stack.peek();
        }

        public int min(){
            return minStack.peek();
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.push(3);
            System.out.println(solution.min());
            solution.push(4);
            System.out.println(solution.min());
            System.out.println(solution.min());
            solution.push(2);
            System.out.println(solution.min());
            solution.push(3);
            System.out.println(solution.min());
            solution.push(3);
            System.out.println(solution.min());
            solution.pop();
            solution.min();

        }

    }
}
