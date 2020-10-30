package main.java.newcoder;

import java.util.ArrayList;

/**
 * @author dingshuangen
 * @date 2020/5/10 22:34
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字:1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Offer019 {

    /**
     * 运行时间：24ms
     * 占用内存：9428k
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return result;
        }
        //上
        int top = 0;
        //下
        int down = matrix.length - 1;
        //左
        int left = 0;
        //右
        int right = matrix[0].length - 1;
        while (true) {

            //左-右
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            if (++top > down) {
                break;
            }
            //上-下
            for (int i = top; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            //右-左
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            if (--down < top) {
                break;
            }
            //下-上
            for (int i = down; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Offer019 instance = new Offer019();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //result = [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]

        int[][] arr = {{1},{2},{3},{4}};
        //result = [1,2,3,4,5]
        ArrayList<Integer> result = instance.printMatrix(matrix);
    }

}
