package main.java.newcoder;

/**
 * @author dingshuangen
 * @date 2020/4/27 21:18
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInArray {

    /**
     * 思路：左下角斜对角线进行分区查找
     * 斜对角线上以上均小于斜对角元素，以下反之
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int[][] array) {

        if (array == null || array.length <= 0 || array[0].length <= 0) {
            return false;
        }
        int row = array.length;
        int colum = row;
        int i = row - 1;
        int j = 0;
        while (i >= 0 && j < colum) {
            //大于左下角元素（列最大值，行最小值）
            if (target > array[i][j]) {
                //大于整列，列向后移动
                j++;
                continue;
            }
            //小于左下角元素
            if (target < array[i][j]) {
                //行向上移
                i--;
                continue;
            }
            if (target == array[i][j]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 从右上角开始查找
     * @param arr
     * @param target
     * @return
     */
    public static boolean find(int[][] arr, int target){
        if (arr == null || arr.length <= 0 || arr[0].length <= 0){
            return false;
        }

        int rows = arr.length;
        int columns = rows;
        int i = 0;
        int j = columns - 1;
        while (j >= 0 && i < rows){

            if (target > arr[i][j]){
                //下移一行
                i++;
                continue;
            }
            if (target < arr[i][j]){
                //左移一列
                j--;
                continue;
            }
            return true;
        }
        return false;
    }

    public static boolean find2(int target, int[][] array) {

        if (array.length <= 0 || array[0].length <= 0) {
            return false;
        }
        int rows = array.length;
        if (target < array[0][0] || target > array[rows - 1][rows - 1]) {
            return false;
        }
        boolean find = false;
        for (int i = 0; i < rows; i++) {
            find = binaryFind(target, array[i]);
            if (find) {
                break;
            }
        }
        return find;
    }

    public static boolean binaryFind(int target, int[] array) {
        int end = array.length - 1;
        int start = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == array[mid]) {
                return true;
            }
            if (target < array[mid]) {
                end = mid - 1;
            }
            if (target > array[mid]) {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(find(55, array));
        System.out.println(find(array, 55));
    }
}
