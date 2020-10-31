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
            //计算下一个最小的丑数
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
}
