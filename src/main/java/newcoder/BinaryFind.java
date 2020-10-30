package main.java.newcoder;

/**
 * @author dingshuangen
 * @date 2020/4/27 21:58
 * 二分查找,需要数组为递增或者递减
 */
public class BinaryFind {

    public static boolean find(int target, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {

            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            }
        }
        return false;
    }

    public static int find(int[] arr, int target) {

        if (arr == null || arr.length <= 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(find(arr, 5));
    }
}
