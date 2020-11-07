package newcoder;

import java.util.ArrayList;

/**
 * @Author dingshuangen
 * @Date 2020/11/2 22:37
 * <p>
 * 题目描述:
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * <p>
 * 返回值描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Offer041 {

    /**
     * 运行时间：14ms
     * 占用内存：9764k
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        //从1开始，直到sum/2。因为超过半数之后，两个连续数之和必大于sum
        int num = 1;
        while (num <= (sum >> 1)) {
            ArrayList<Integer> list = new ArrayList<>();
            int start = num;
            int total = 0;
            while (true) {
                list.add(start);
                total += start++;
                if (total == sum && list.size() > 1) {
                    res.add(list);
                    break;
                }
                if (total > sum) {
                    break;
                }
            }
            num++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Offer041().FindContinuousSequence(588));
    }
}
