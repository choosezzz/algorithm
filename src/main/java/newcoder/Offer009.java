package newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/9 22:24
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * f(n)=f(n-1)+f(n-2)+f(n-3)+...+f(n-(n-2))+f(n-(n-1))+f(n-n)
 *     =2*f(n-1)
 *     =2*2*f(n-2)
 *     =2^(n-1)*f(1)
 *     =2^(n-1)
 *
 * 每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。
 * 所以共有2^(n-1)中情况
 */
public class Offer009 {

    /**
     * 运行时间：13ms
     * 占用内存：9432k
     *
     * @param n
     * @return
     */
    public int JumpFloorII(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result = 1;
        while ((n--) > 1) {
            result *= 2;
        }
        return result;
    }

    /**
     * 运行时间：18ms
     * 占用内存：9440k
     *
     * @param n
     * @return
     */
    public int jumpFloorPro(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return 2 * jumpFloorPro(n - 1);
    }

    public static void main(String[] args) {
        Offer009 instance = new Offer009();
        System.out.println(instance.jumpFloorPro(6));
        System.out.println(instance.JumpFloorII(6));
    }
}
