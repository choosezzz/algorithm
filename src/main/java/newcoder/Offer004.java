package newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/7 22:49
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Offer004 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre == null || in == null || pre.length <= 0 || in.length <= 0) {
            return null;
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int leftCount = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                //leftCount = i - instart;
                root.left = reConstructBinaryTree(pre, preStart + 1, preStart + leftCount, in, inStart, inStart + leftCount - 1);
                root.right = reConstructBinaryTree(pre, preStart + leftCount + 1, preEnd, in, inStart + leftCount + 1, inEnd);
                break;
            }
            leftCount++;
        }
        return root;
    }

    private int preIndex = 0;
    private int inIndex = 0;

    public TreeNode buildTree(int[] pre, int[] in) {

        //中序遍历的结束节点为null
        return dfs(pre, in, null);
    }

    /**
     * 深度优先遍历
     *
     * 将中序遍历结果用根节点分开，左边为左子树，右边为右子树
     * @param pre
     * @param in
     * @param lastRoot
     * @return
     */
    private TreeNode dfs(int[] pre, int[] in, TreeNode lastRoot) {

        //退出条件
        //1.遍历完先序集合
        //2.当前根节点为中序遍历的终止节点（根节点或者最右节点）
        if (preIndex == pre.length || (lastRoot != null && in[inIndex] == lastRoot.val)) {
            return null;
        }
        //先序遍历：根左右，根节点为先序遍历的第一个节点
        TreeNode root = new TreeNode(pre[preIndex]);

        //遍历左子树，根节点为左子树中序遍历的终止节点
        preIndex++;
        root.left = dfs(pre, in, root);

        //遍历右子树
        inIndex++;
        root.right = dfs(pre, in, lastRoot);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        Offer004 offer004 = new Offer004();
        TreeNode treeNode = offer004.buildTree(pre, in);
        TreeNode root = offer004.rebuildTree(pre, in);
        System.out.println("end");
    }

    public TreeNode rebuildTree(int[] pre, int[] in) {

        if (pre == null || pre.length <= 0 || in == null || in.length <= 0) {
            return null;
        }
        return rebuildTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode rebuildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        //找到中序遍历根节点位置
        int leftCount = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                //以根节点位置分割为左右
                root.left = rebuildTree(pre, preStart + 1, preStart + leftCount , in, inStart, i-1);
                root.right = rebuildTree(pre, preStart + leftCount + 1, preEnd, in, i + 1, inEnd);
            }
            leftCount++;
        }
        return root;
    }
}
