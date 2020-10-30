package main.java.newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/9 0:12
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Offer008 {


    /**
     * 运行时间：627ms
     * 占用内存：9512k
     * 递归实现
     * 1.第一步跳1层，剩下n-1层
     * 2.第一步跳2层，剩下n-2层
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {

        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    /**
     * 运行时间：13ms
     * 占用内存：9160k
     * 0, 1, 2, 3, 5, 8
     *
     * @param n
     * @return
     */
    public int jumpFloor(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n==2){
            return 2;
        }
        int fn0 = 1;
        int fn1 = 2;
        while ((n--) > 2) {
            fn1 += fn0;
            fn0 = fn1 - fn0;
        }
        return fn1;
    }

    public static void main(String[] args) {
        new Offer008().JumpFloor(4);
    }

}
