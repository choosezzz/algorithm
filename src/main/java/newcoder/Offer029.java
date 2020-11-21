package newcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author dingshuangen
 * @Date 2020/10/31 23:52
 * <p>
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
public class Offer029 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        if (input == null || input.length < k) {
            return new ArrayList<>();
        }
        return solution_1(input, k);
    }

    /**
     * 运行时间：14ms
     * 占用内存：9608k
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> solution_1(int[] input, int k) {

        Arrays.sort(input);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    /**
     * 堆排序：建立一个容量为k的大根堆的优先队列。
     * 遍历一遍元素，如果队列大小<k,就直接入队，
     * 否则，让当前元素与队顶元素相比，如果队顶元素大，则出队，将当前元素入队
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> solution_2(int[] input, int k) {


        //大顶堆（默认小顶堆）
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for (int ele : input) {
            maxHeap.add(ele);
            if (maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);

    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2-o1));
        queue.add(3);
        queue.add(2);
        queue.add(4);
        queue.add(1);
        System.out.println();
    }

}
