package sort;

import java.util.Arrays;

/**
 * @Author dingshuangen
 * @Date 2020/11/13 17:41
 * <p>
 * 冒泡排序,每次循环都将最大（最小）值移动到数组尾端
 */
public class BubbleSort {

    public static int[] sort(int[] arr) {

        if (arr == null || arr.length <= 0) {
            return arr;
        }

        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                //相邻的进行交换
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 3, 4, 5, 2})));
    }

}
