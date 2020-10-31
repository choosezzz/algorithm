package newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/10 20:34
 * <p>
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class Offer017 {

    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    /**
     * 运行时间：19ms
     * 占用内存：9544k
     *
     * @param a
     * @param b
     * @return
     */
    public boolean hasSubtree(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return false;
        }
        boolean result = false;
        //根节点值相同，则从根节点进行查找
        if (a.val == b.val) {
            result = contains(a, b);
        }
        //否则查找A左子树和A右子树
        if (!result) {
            result = contains(a.left, b) || contains(a.right, b);
        }
        return result;
    }

    private boolean contains(TreeNode a, TreeNode b) {

        //tree B遍历完都能对应上
        if (b == null) {
            return true;
        }
        //tree B未遍历完，但tree A已经为空
        if (a == null) {
            return false;
        }
        if (a.val == b.val) {
            return contains(a.left, b.left) && contains(a.right, b.right);
        } else {
            return false;
        }
    }
}
