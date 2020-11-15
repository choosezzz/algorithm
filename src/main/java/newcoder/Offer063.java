package newcoder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author dingshuangen
 * @Date 2020/11/15 14:46
 * 题目描述
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 本题知识点： 进制转化 排序 堆
 */
public class Offer063 {


    ArrayList<Integer> buffer = new ArrayList<>();

    public void Insert(Integer num) {
        buffer.add(num);
    }

    /**
     * 运行时间：14ms
     *
     * 占用内存：9900k
     * @return
     */
    public Double GetMedian() {

        if (buffer.isEmpty()) {
            return 0.0;
        }
        Collections.sort(buffer);
        int size = buffer.size();
        if ((size & 1) == 1) {
            return (double) buffer.get(size / 2);
        }
        return (buffer.get(size / 2) + buffer.get(size / 2 - 1)) / 2.0;
    }

}
