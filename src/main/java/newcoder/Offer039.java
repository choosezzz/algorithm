package newcoder;

import common.TreeNode;

/**
 * @Author dingshuangen
 * @Date 2020/11/15 21:31
 * <p>
 * <p>
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 知识点：树 深度优先遍历（dfs）
 * 平衡二叉树：左右子树高度差绝对值小于等于1，同时左右子树也为平衡二叉树
 */
public class Offer039 {

    public boolean IsBalanced_Solution(TreeNode root) {

        if (root == null) {
            return true;
        }
        return dfs(root) != -1;
    }

    /**
     * 运行时间：10ms
     * 占用内存：9472k
     *
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }
        //左子树深度
        int left = dfs(root.left);
        if (left == -1) {
            return -1;
        }
        //右子树深度
        int right = dfs(root.right);
        if (right == -1) {
            return -1;
        }
        //左右深度差值大于1则返回-1，否则树的深度为 1 + Math.max(left, right)
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
