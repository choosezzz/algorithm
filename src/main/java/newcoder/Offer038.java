package newcoder;

import common.TreeNode;

/**
 * @Author dingshuangen
 * @Date 2020/11/3 22:32
 * <p>
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Offer038 {
    /**
     * 运行时间：10ms
     * 占用内存：9308k
     *
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left, right;
        //遍历左子树
        left = 1 + TreeDepth(root.left);
        //遍历右子树
        right = 1 + TreeDepth(root.right);
        return left > right ? left : right;
    }
}
