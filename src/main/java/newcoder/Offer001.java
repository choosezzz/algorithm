package newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/7 21:47
 * <p>
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Offer001 {

    /**
     * 从左下角或者右上角进行比较，每次可排除一行或一列
     *
     * @param target
     * @param arr
     * @return
     */
    public static boolean find(int target, int[][] arr) {

        if (arr == null || arr.length <= 0
                || (arr.length == 1 && arr[0].length <= 0)) {
            return false;
        }
        int i = arr.length - 1;
        int j = 0;
        while (j < arr.length && i >= 0) {

            if (arr[i][j] == target) {
                return true;
            }
            //排除下面一行
            if (arr[i][j] > target) {
                i--;
                continue;
            }
            //排除左面一列
            if (arr[i][j] < target) {
                j++;
                continue;
            }
        }
        return false;
    }
}
