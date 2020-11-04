package newcoder;

import java.util.ArrayList;

/**
 * @Author dingshuangen
 * @Date 2020/11/4 22:55
 * <p>
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 */
public class Offer064 {

    /**
     * 运行时间：10ms
     * 占用内存：9512k
     *
     * 解题思路，采用双指针
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) {
            return res;
        }
        int p1 = 0;
        int p2 = 0;
        while (p2 <= num.length - size) {
            int max = num[p2++];
            for (int i = 1; i < size; i++, p2++) {
                if (max < num[p2]) {
                    max = num[p2];
                }
            }
            res.add(max);
            p1++;
            p2 = p1;
        }
        return res;
    }

    public static void main(String[] args) {
        new Offer064().maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
    }
}
