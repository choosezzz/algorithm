package newcoder;

import java.util.HashMap;

/**
 * @Author dingshuangen
 * @Date 2020/11/5 22:44
 * <p>
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。
 * 请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 */
public class Offer067 {

    public int cutRope(int target) {

        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
//        return backTrace(target);
//        HashMap<Integer, Integer> map = new HashMap<>();
//        return backTrace(target, map);
        return dynamic(target);

    }

    /**
     * 递归函数的设计和功能：backTrack(n);
     * 含义是：求长度为n的数，最后分段后的最大乘积，这里我们不需要关心分成多少段
     * 递归函数的终止条件: 如果n <= 4, backTrack(n) = n，初始条件也就是我们不用计算就能得到的。
     * 下一步递归：对于长度n，我们需要减少递归参数n，如果第一段为1， 显然下一步递归为backTrack(n-1),
     * 如果第一段为2， 则下一步递归为backTrack(n-2)...
     * 因为要至少分2段，所以，最后一次可能的情况为最后一段为n-1, 下一步递归为backTrack(1)，因此，每一步可能的结果为
     * 1 * backTrack(n-1), 2 * backTrack(n-2), ..., (n-1) * backTrack(1),
     * 在n-1种情况中取一个最大值即可。
     * 这里我们不用关心backTrack(n-1)等的值为多少，因为最终会递归到我们的终止条件，因此绝对是可以求出来。
     *
     * <b>运行超时</b>
     *
     * @param n
     * @return
     */
    private int backTrace(int n) {
        //当 n <= 4时，不切得到的乘积最大
        if (n <= 4) {
            return n;
        }
        int res = 0;
        //最多切n-1段
        for (int i = 1; i < n; i++) {
            res = Math.max(res, i * backTrace(n - i));
        }
        return res;
    }

    /**
     * 记录重复计算的数值
     * <b>运行超时</b>
     *
     * @param n
     * @param map
     * @return
     */
    private int backTrace(int n, HashMap<Integer, Integer> map) {
        //当 n <= 4时，不切得到的乘积最大
        if (n <= 4) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, i * backTrace(n - i));
        }
        map.put(n, res);
        return res;
    }

    /**
     * 运行时间：36ms
     * 占用内存：11100k
     *
     * @param target
     * @return
     */
    private int dynamic(int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            map.put(i, i);
        }
        for (int i = 5; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                map.put(i, Math.max(map.containsKey(i) ? map.get(i) : -1, j * map.get(i - j)));
            }
        }
        return map.get(target);
    }

    /**
     *
     * 找规律
     * 运行时间：11ms
     * 占用内存：9696k
     *
     * @param target
     * @return
     */
    private int cute(int target) {
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }

        int mod = target % 3;
        if (mod == 0) {
            return (int) Math.pow(3, target / 3);
        }
        if (mod == 1) {
            return (int) Math.pow(3, target / 3 - 1) * 4;
        }
        return (int) Math.pow(3, target / 3) * 2;
    }

    public static void main(String[] args) {
        Offer067 instance = new Offer067();
        System.out.println(instance.cutRope(14));
        System.out.println(instance.cute(14));
        System.out.println(instance.backTrace(14));
        System.out.println(instance.backTrace(14, new HashMap<>()));
    }

}
