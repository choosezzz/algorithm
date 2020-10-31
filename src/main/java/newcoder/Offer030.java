package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/10/31 20:39
 * <p>
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Offer030 {

    /**
     * 运行时间：10ms
     * 占用内存：9540k
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length <= 0) {
            return 0;
        }
        //最大和
        int maxSum = array[0];
        //当前遍历到序列的最大和
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum < array[i]) {
                sum = array[i];
            }
            if (maxSum < sum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(new Offer030().FindGreatestSumOfSubArray(arr));
    }
}
