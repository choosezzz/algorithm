package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/11/18 22:37
 * <p>
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 */
public class Offer051 {

    /**
     * 解题思路：两部分计算
     * B[0] = 1 * A[1] * A[2] * A[3] *......* A[n-1]
     * B[1] = A[0] * 1 * A[2] * A[3] *......* A[n-1]
     * .............................................
     * B[n-2] = A[0] * A[1] * A[2] * A[3] *... * 1 * A[n-1]
     * B[0] = A[0] * A[1] * A[2] * A[3] *......* A[n-2] * 1
     *
     * 运行时间：10ms
     *
     * 占用内存：9328k
     * @param arr
     * @return
     */
    public int[] multiply(int[] arr) {

        int len = arr.length;
        int[] res = new int[len];
        int tmp =1;
        //计算前半部分
        for (int i = 0; i < len; tmp *= arr[i++]) {
            res[i] = tmp;
        }
        //计算后半部分
        tmp = 1;
        for (int i = len - 1; i >= 0; tmp *= arr[i--]) {
            res[i] *= tmp;
        }
        return res;
    }
}
