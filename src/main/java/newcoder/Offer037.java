package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/11/15 22:20
 * <p>
 * 统计一个数字在升序数组中出现的次数。
 * 二分查找
 */
public class Offer037 {

    /**
     * 运行时间：11ms
     * 占用内存：9468k
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int count = 0;
        int left = 0;
        int right = array.length - 1;
        int index = 0;
        //二分查找
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > k) {
                right = mid - 1;
                continue;
            }
            if (array[mid] < k) {
                left = mid + 1;
                continue;
            }
            index = mid;
            break;
        }
        //查找到某次出现的位置，向前向后查找相等的元素
        if (index >= left && index <= right) {
            int forward = index;
            int backward = index + 1;
            while (forward >= 0 && array[forward] == k) {
                forward--;
                count++;
            }
            while (backward <= right && array[backward] == k) {
                backward++;
                count++;
            }
        }
        return count;
    }

    /**
     * 二分查找小于等于某个数的位置
     * 运行时间：12ms
     * 占用内存：9536k
     *
     * @param arr
     * @param target
     * @return
     */
    public int binaryFind(int[] arr, int target) {

        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,4,4,4,9};
        System.out.println(new Offer037().binaryFind(arr, 5));
    }
}
