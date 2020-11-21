package newcoder;

import common.TreeNode;

/**
 * @Author dingshuangen
 * @Date 2020/11/21 22:20
 */
public class Offer058 {

    /**
     * 运行时间：11ms
     *
     * 占用内存：9396k
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null){
            return true;
        }

        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }

        return isSymmetrical(left.left,right.right) && isSymmetrical(left.right, right.left);
    }
}
