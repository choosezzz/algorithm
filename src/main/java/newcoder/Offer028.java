package newcoder;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author dingshuangen
 * @Date 2020/10/31 23:24
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Offer028 {

    public int MoreThanHalfNum_Solution(int [] array) {

        if (array == null || array.length <= 0){
            return 0;
        }

        return moreThanHalf(array);
    }

    /**
     *
     * 运行时间：11ms
     * 占用内存：9392k
     *
     * 使用map记录每个数字出现的次数
     * @param arr
     * @return
     */
    public int moreThanHalf(int[] arr){

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, !map.containsKey(i) ? 1 : map.get(i) + 1);
            if (map.get(i) > arr.length / 2){
                return i;
            }
        }
        return 0;
    }

    /**
     *
     * 运行时间：11ms
     * 占用内存：9516k
     *
     * 对数组排序，出现超过一半的数字肯定会出现在中间位置
     * @param arr
     * @return
     */
    public int moreThanHalf_2(int[] arr){

        Arrays.sort(arr);
        int mid = arr[arr.length / 2];
        int count = 0;
        for (int i : arr) {
            if (i == mid){
                count++;
                if (count > arr.length / 2){
                    return mid;
                }
            }
        }
        return 0;
    }

    /**
     *
     * 运行时间：10ms
     * 占用内存：9484k
     *
     * 方法三：候选法（最优解）
     * 假设存在一个数字超过一半，则连续出现次数最多
     * @param arr
     * @return
     */
    public int moreThanHalf_3(int[] arr){

        //找出数组中出现次数最多的数
        int count = 1;
        //从第一个开始数
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //连续出现
            if (arr[i] == num){
                count++;
            }else {
                //不连续出现则和前一个元素两两抵消
                count--;
            }

            //连续出现的次数和前面非连续出现的数字完全抵消，则重新以当前数字开始数
            if (count == 0){
                count = 1;
                num = arr[i];
            }
        }

        //找到连续出现次数最多的数字，开始数该数字总次数
        count = 0;
        for (int i : arr) {
            if (num == i){
                count++;
                if (count > arr.length / 2){
                    return num;
                }
            }
        }
        return 0;
    }

}
