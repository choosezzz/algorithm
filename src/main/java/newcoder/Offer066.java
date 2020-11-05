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
        int[][] flag = new int[rows][cols];
        return dfs(0, 0, threshold, rows - 1, cols - 1, flag);
    }

    private int dfs(int row, int col, int threshold, int rows, int cols, int[][] flag) {
        if (row > rows || row < 0 || col > cols || col < 0 || flag[row][col] == 1 || sum(row, col) > threshold) {
            return 0;
        }
        flag[row][col] = 1;
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
