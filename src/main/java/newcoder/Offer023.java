package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/10/30 22:38
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 */
public class Offer023 {

    /**
     * 运行时间：10ms
     * 占用内存：9408k
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {

        if (sequence == null || sequence.length <= 0) {
            return false;
        }

        int length = sequence.length;
        return judge(sequence, 0, length - 1);
    }

    /**
     * 二叉树后序遍历：左右根
     *  后序遍历 的序列中，最后一个数字是树的根节点 ，
     *  数组中前面的数字可以分为两部分：
     *  第一部分: 左子树节点的值，都比根节点的值小；
     *  第二部分: 右子树节点的值，都比根节点的值大.
     *  后面用递归分别判断前后两部分是否符合以上原则
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public boolean judge(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        }
        //右子树序列的开始位置
        int index = start;
        int root = arr[end];
        //左子树全部小于根节点，找到左子树的范围
        while (arr[index] < root) {
            index++;
        }
        //判断右子树数列是否有小于根节点的节点
        int right = index;
        while (right < end) {
            if (arr[right++] < root){
                return false;
            }
        }

        //递归验证左子树和右子树是否符合二叉树后序遍历的规则
        return judge(arr, start, index - 1) && judge(arr, index, end - 1);

    }
}
