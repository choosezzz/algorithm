package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/10/31 20:48
 * <p>
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
 */
public class Offer031 {


    /**
     * 思路：求 1~n的整数中出现1的次数，即为分别求个位、十位、百位...中1出现的总次数
     * 假设数共有x位，第i位记为n(i),则n=n(x)n(x-1)n(x-2)...n(2)n(1)，记10^i为位因子digit
     * 若当前位为i位，即digit=10^i，将n分为:
     * 高位 -> high = n(x)n(x-1)n(x-2)...n(x-i+1)
     * 当前位 -> curr = n(i)
     * 低位 -> low = n(x-i-1)n(x-i-2)...n(2)n(1)
     *
     * 求某位1出现的次数共有以下三种情况：
     * 【1】curr = 0时：
     * 例如：2304，digit = 10，i = 1
     * high = 23、curr = 0、low = 4
     * ==> 将2304按照10位分割为[23] [0] [4]
     * 则10位出现1的范围是 [00] [1] [0] ~ [22] [1] [9]
     * 固定十位为1（可以看做4位密码锁，固定一个位置为1，转动其他位，可能出现的排列组合）
     * 则十位为1的数字共有 [00] [0] ~ [22] [9]
     * 共计230个数字，即为 high * digit
     * 【2】curr = 1时：
     * 例如：2314，digit = 10，i = 1
     * high = 23, curr = 1, low = 4 ==> [23] [1] [4]
     * 则十位为1出现的数字范围为 [00] [1] [0] ~ [23] [1] [4]
     * 同样，十位为1的所有组合数为 [00] [0] ~ [23] [4] 共计 235 = high * digit + low + 1
     * 【3】curr > 1
     * 例如：2324 ==> [23] [2] [4]
     * 十位为1出现的范围 ==> [00] [1] [0] ~ [23] [1] [9]
     * 固定十位，则有 [00] [0] ~ [23] [9] 共计 240 = (high + 1) * digit
     *
     */
    // ------------------------------------------
    /**
     * 运行时间：9ms
     * 占用内存：9320k
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {

        if (n <= 0) {
            return 0;
        }

        int count = 0;
        // i表示位数
        for (int i = 1; i <= n; i *= 10) {

            // 高位
            int high = n / (i * 10);
            // 当前位
            int curr = (n / i) % 10;
            // 低位
            int low = n % i;
            if (curr == 0) {
                count += high * i;
            } else if (curr == 1) {
                count += high * i + (low + 1);
            } else {
                count += (high + 1) * i;
            }
        }
        return count;
    }

    /**
     * 运行时间：9ms
     * 占用内存：9404k
     * @param n
     * @return
     */
    public int solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }
}
