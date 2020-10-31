package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/11/1 1:44
 * <p>
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 */
public class Offer033 {

    /**
     * 运行时间：10ms
     * 占用内存：9516k
     * <p>
     * 思路：分别计算2，3，5倍数的丑数序列，去重合并之后从小到大排列
     * <p>
     * 1,2,3,4,5,6,8,9,10
     * <p>
     * 2的倍数：2,4,6,8,10
     * 3的倍数：3,6,9
     * 5的倍数：5，10
     *
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {

        if (index <= 0) {
            return 0;
        }
        int[] res = new int[index];
        //第一个丑数
        res[0] = 1;
        //丑数为2的倍数指针
        int p2 = 0;
        //丑数为3的倍数指针
        int p3 = 0;
        //丑数为5的倍数指针
        int p5 = 0;
        for (int i = 1; i < index; i++) {
            //计算下一个最小的丑数（倍数为2，3，5的三个序列中最小的一个）
            res[i] = Math.min(Math.min(res[p2] * 2, res[p3] * 3), res[p5] * 5);
            //跳过重复丑数，例如 6 = 2* 3，则倍数2的丑数和倍数3的丑数都需要向后+1位
            if (res[i] == res[p2] * 2) {
                p2++;
            }
            if (res[i] == res[p3] * 3) {
                p3++;
            }
            if (res[i] == res[p5] * 5) {
                p5++;
            }
        }

        return res[index - 1];
    }

    /**
     * 运行时间：10ms
     * 占用内存：9476k
     * @param index
     * @return
     */
    public int uglyNum(int index) {
        if (index <= 0) {
            return 0;
        }

        int[] res = new int[index];
        res[0] = 1;
        //丑数为2的倍数指针
        int p2 = 0;
        //丑数为3的倍数指针
        int p3 = 0;
        //丑数为5的倍数指针
        int p5 = 0;
        for (int i = 1; i < index; i++) {
            int u2 = res[p2] * 2;
            int u3 = res[p3] * 3;
            int u5 = res[p5] * 5;
            int min = u2 > u3 ? u3 : u2;
            min = min > u5 ? u5 : min;
            res[i] = min;
            if (min == u2) {
                p2++;
            }
            if (min == u3) {
                p3++;
            }
            if (min == u5) {
                p5++;
            }
        }
        return res[index - 1];

    }
}
