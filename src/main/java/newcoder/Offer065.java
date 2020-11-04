package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/11/4 23:16
 * <p>
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如：
 * |a b c e|
 * |s f c s|
 * |a d e e|
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 知识点：dfs（深度优先遍历）、回溯
 */
public class Offer065 {

    /**
     * 运行时间：12ms
     * <p>
     * 占用内存：9660k
     *
     * @param matrix 原始数组
     * @param rows   行数
     * @param cols   列数
     * @param str    目标字符数组
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //回溯标识数组
        int[] flag = new int[matrix.length];
        //遍历二维数组
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //从二维数组顶点开始查找目标字符数组
                if (helper(matrix, rows, cols, i, j, str, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param matrix 一维化二维数组
     * @param rows   二维数组行数
     * @param cols   二维数组列数
     * @param i      当前遍历的行
     * @param j      当前遍历的列
     * @param str    目标字符串
     * @param k      当前查找的目标字符串的位置
     * @param flag   回溯标志
     * @return
     */
    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        //计算当前所在的位置
        int index = i * cols + j;
        //不满足条件
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1) {
            return false;
        }
        //查找到最后一位
        if (k == str.length - 1) {
            return true;
        }
        //当前位置占用，继续查找其他位置
        flag[index] = 1;
        if (
            //向下查找
                helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                        //向上查找
                        || helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                        //向右查找
                        || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)
                        //向左查找
                        || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)) {
            return true;
        }
        //后续查找不匹配，对当前位置进行回溯
        flag[index] = 0;
        return false;
    }

    public boolean dfs(int[] matrix, int rows, int cols, int i, int j, int k, char[] str, int[] flags) {

        //计算二维数组一维化之后的位置 index = 当前所在行*列数 + 当前列
        int index = i * cols + j;
        //判断是否符合查找条件
        //1. 是否超出二维数组范围
        //2. 是否超出目标字符数组的长度
        //3. 是否已被遍历同时使用
        //4. 要查找的字符是否和当前位置的字符相等
        if (i < 0 || i > rows || j > cols || j < 0
                || k >= str.length
                || flags[index] == 1
                || matrix[index] != str[k]) {
            return false;
        }

        //查找的为目标字符串的最后一个字符，表示完全找到路径
        if (k == str.length - 1) {
            return true;
        }
        //不是最后一位，查找下一位相等的字符（当前位相等）
        flags[index] = 1;
        //向左,列-1
        if (dfs(matrix, rows, cols, i, j - 1, k, str, flags)) {
            return true;
        }
        //向右 列+1
        if (dfs(matrix, rows, cols, i, j + 1, k, str, flags)) {
            return true;
        }
        //向上 行-1
        if (dfs(matrix, rows, cols, i - 1, j, k, str, flags)) {
            return true;
        }
        //向下 行+1
        if (dfs(matrix, rows, cols, i + 1, j, k, str, flags)) {
            return true;
        }
        //上下左右都没有找到，则当前位置虽然相等但是不在路径上，进行回溯
        flags[index] = 0;
        return false;
    }
}
