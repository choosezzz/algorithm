package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/11/3 22:02
 * <p>
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */
public class Offer047 {

    /**
     * 等差数列 Sn=n*a1+n(n-1)/2*d
     * n=1时，Sn=n(n+1)/2
     * <p>
     * 运行时间：11ms
     * 占用内存：9340k
     *
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        return ((int) Math.pow(n, 2) + n) >> 1;
    }

    /**
     * 运行时间：9ms
     * 占用内存：9496k
     * 
     * @param n
     * @return
     */
    public int sum(int n) {
        int sum = n;
        boolean res = (n > 0) && ((sum += sum(n - 1)) > 0);
        return sum;
    }
}
