package newcoder;

import java.util.ArrayList;

/**
 * @Author dingshuangen
 * @Date 2020/11/2 23:02
 * <p>
 * 题目描述:
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * <p>
 * 返回值描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * <p>
 * 双指针
 */
public class Offer042 {

    /**
     * 运行时间：10ms
     * 占用内存：9492k
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length <= 2) {
            return res;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int total = array[left] + array[right];
            if (total < sum) {
                left++;
                continue;
            }
            if (total > sum) {
                right--;
                continue;
            }
            if (total == sum) {
                res.add(array[left]);
                res.add(array[right]);
                break;
            }
        }

        return res;
    }
}
