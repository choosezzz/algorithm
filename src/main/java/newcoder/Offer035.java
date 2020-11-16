package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/11/16 21:47
 * 数组中的逆序对
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class Offer035 {

    public static int InversePairs(int[] array) {
        if (array == null) {
            return 0;
        }
        int[] tmp = new int[array.length];
        return mergeSort(array, tmp, 0, array.length - 1);
    }

    //归并排序，递归
    private static int mergeSort(int[] array, int[] tmp, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int res = 0, mid = low + (high - low) / 2;
        res += mergeSort(array, tmp, low, mid);
        res %= 1000000007;
        res += mergeSort(array, tmp, mid + 1, high);
        res %= 1000000007;
        res += merge(array, tmp, low, mid, high);
        res %= 1000000007;
        return res;
    }

    //归并排序，合并
    private static int merge(int[] array, int[] tmp, int low, int mid, int high) {
        int i1 = low, i2 = mid + 1, k = low;
        int res = 0;
        while (i1 <= mid && i2 <= high) {
            if (array[i1] > array[i2]) {
                res += mid - i1 + 1;
                res %= 1000000007;
                tmp[k++] = array[i2++];
            } else {
                tmp[k++] = array[i1++];
            }
        }
        while (i1 <= mid) {
            tmp[k++] = array[i1++];
        }
        while (i2 <= high) {
            tmp[k++] = array[i2++];
        }
        for (int i = low; i <= high; i++) {
            array[i] = tmp[i];
        }
        return res;
    }
}