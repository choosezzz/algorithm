package newcoder;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author dingshuangen
 * @Date 2020/11/1 1:04
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Offer032 {

    public String PrintMinNumber(int [] numbers) {

        if (numbers == null || numbers.length <= 0){
            return "";
        }

        return min(numbers);
    }

    /**
     * 运行时间：103ms
     * 占用内存：15828k
     *
     * 将数组按照两两拼接在一起得到的数字大小进行升序排序
     * @param numbers
     * @return
     */
    public String min(int[] numbers){
        //将数组进行排序，排序规则为两个数字拼接起来，谁在前面时得到的结果小则排序靠前
        List<Integer> list = IntStream.of(numbers).boxed().collect(Collectors.toList());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.parseInt(o1 + "" + o2) > Integer.parseInt(o2 + "" + o1) ? 1 : -1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        return sb.toString();
    }

    /**
     * 运行时间：13ms
     * 占用内存：9580k
     *
     * @param numbers
     * @return
     */
    public String min2(int[] numbers){
        //将数组进行排序，排序规则为两个数字拼接起来，谁在前面时得到的结果小则排序靠前
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int num1 = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int num2 = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (num1 > num2){
                    int c = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = c;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }
        return sb.toString();
    }
}
