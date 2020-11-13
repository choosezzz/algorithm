package sort;

import util.ArrayUtil;

/**
 * @Author dingshuangen
 * @Date 2020/11/13 22:03
 * <p>
 * 快速排序：
 * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
 * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 */
public class QuickSort {

    public static int[] sort(int[] arr) {
        if (ArrayUtil.isEmpty(arr)) {
            return arr;
        }
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void sort(int[] arr, int low, int high) {

        int l = low;
        int h = high;
        //标志位，将数组根据该位置分为两部分
        int flag = arr[low];
        while (low < high) {
            //从后向前查找到第一个比标志位小的元素
            while (low < high && arr[high] >= flag) {
                high--;
            }
            //交换位置
            if (low < high) {
                int tmp = arr[high];
                arr[high] = arr[low];
                arr[low] = tmp;
                low++;
            }

            //从前向后，找到比标志位小的元素
            while (low < high && arr[low] <= flag) {
                low++;
            }
            //交换位置
            if (low < high) {
                int tmp = arr[high];
                arr[high] = arr[low];
                arr[low] = tmp;
                high--;
            }
        }

        if (low > l) {
            sort(arr, l, low - 1);
        }
        if (high < h) {
            sort(arr, high + 1, h);
        }
    }

    public static void main(String[] args) {
        ArrayUtil.callAndPrint(QuickSort::sort);
    }

}
