package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/11/16 23:03
 * <p>
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中第一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 返回描述：
 * 如果数组中有重复的数字，函数返回true，否则返回false。
 * 如果数组中有重复的数字，把重复的数字放到参数duplication[0]中。（ps:duplication已经初始化，可以直接赋值使用。）
 */
public class Offer050 {

    /**
     * Parameters:
     * numbers:     an array of integers
     * length:      the length of array numbers
     * duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
     * Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
     * 这里要特别注意~返回任意重复的一个，赋值duplication[0]
     * Return value:       true if the input is valid, and there are some duplications in the array number
     * otherwise false
     * <p>
     * 运行时间：13ms
     * <p>
     * 占用内存：9692k
     */
    public boolean duplicate(int[] numbers, int length, int[] duplication) {

        if (length < 2) {
            return false;
        }
        int[] num = new int[length];
        for (int i = 0; i < length; i++) {
            num[numbers[i]]++;
        }
        for (int i = 1; i < length; i++) {
            if (num[i] > 1) {
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }

    /**
     * 运行时间：13ms
     * <p>
     * 占用内存：9832k
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate2(int[] numbers, int length, int[] duplication) {

        if (length < 2) {
            return false;
        }
        for (int num : numbers) {
            if (num < 0) {
                num += length;
            }
            if (numbers[num] >= 0) {
                numbers[num] -= length;
            } else {
                duplication[0] = num;
                return true;
            }
        }
        return false;
    }

    /**
     * 归为法：因为n个数字范围都为0-n，则将num[i]与值为i-1的元素进行交换，直到发现num[i]==num[num[i]]
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate3(int[] nums, int length, int[] duplication) {

        if (length < 2) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                // swap
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return false;
    }
}
