package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/11/5 22:19
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Offer066 {

    /**
     * 运行时间：11ms
     *
     * 占用内存：9436k
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {

        if (threshold < 0 || rows < 0 || cols < 0) {
            return 0;
        }
        //记录每个格子是否已走过
        int[][] flag = new int[rows][cols];
        return dfs(0, 0, threshold, rows - 1, cols - 1, flag);
    }

    /**
     * 深度优先遍历
     * @param row 当前行
     * @param col 当前列
     * @param threshold 阈值
     * @param rows 总行数
     * @param cols 总列数
     * @param flag 格子使用标记
     * @return
     */
    private int dfs(int row, int col, int threshold, int rows, int cols, int[][] flag) {

        /*
        条件判断：
        1.是否超出格子范围
        2.当前格子是否已被走过
        3.是否超过阈值
         */
        if (row > rows || row < 0 || col > cols || col < 0 || flag[row][col] == 1 || sum(row, col) > threshold) {
            return 0;
        }
        //当前格子满足条件，则标记为已使用
        flag[row][col] = 1;
        //次数加一，向上下左右分别运动
        return 1 + dfs(row - 1, col, threshold, rows, cols, flag)
                + dfs(row + 1, col, threshold, rows, cols, flag)
                + dfs(row, col - 1, threshold, rows, cols, flag)
                + dfs(row, col + 1, threshold, rows, cols, flag);
    }

    private int sum(int row, int col) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row /= 10;
        }
        while (col > 0) {
            sum += col % 10;
            col /= 10;
        }
        return sum;
    }
}
