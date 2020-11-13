package sort;

import util.ArrayUtil;

/**
 * @Author dingshuangen
 * @Date 2020/11/13 18:09
 * <p>
 * 选择排序：每次循环都挑选出最大（最小）的元素放到数组的未排序末尾（开头）
 */
public class SelectSort {

    public static int[] sort(int[] arr) {

        if (ArrayUtil.isEmpty(arr)) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            //最小值索引
            int min = i;
            //遍历查找最小值
            for (int j = i+1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            //将最小值和当前位置进行交换
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayUtil.callAndPrint(SelectSort::sort);
    }
}
