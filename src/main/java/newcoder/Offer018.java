package main.java.newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/10 22:28
 * <p>
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Offer018 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 运行时间：28ms
     * 占用内存：9888k
     *
     * @param root
     */
    public void Mirror(TreeNode root) {
        mirror(root);
    }

    public TreeNode mirror(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        root.left = mirror(root.right);
        root.right = mirror(left);

        return root;
    }
}
