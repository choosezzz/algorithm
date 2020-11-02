package newcoder;

import common.TreeNode;

import java.util.ArrayList;

/**
 * @Author dingshuangen
 * @Date 2020/11/2 10:57
 * <p>
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 */
public class Offer062 {

    /**
     * 运行时间：16ms
     * 占用内存：9884k
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {

        if(pRoot == null || k <= 0){
            return null;
        }

        ArrayList<TreeNode> list = new ArrayList<>();
        preOrder(pRoot, list);
        if (list.isEmpty() || k > list.size()){
            return null;
        }
        return list.get(k-1);
    }

    /**
     * 先序遍历二叉树
     * @param pRoot
     * @param list
     */
    private void preOrder(TreeNode pRoot, ArrayList<TreeNode> list) {

        if (pRoot.left != null){
            preOrder(pRoot.left, list);
        }
        list.add(pRoot);
        if (pRoot.right != null){
            preOrder(pRoot.right, list);
        }
    }

    /**查找的位置*/
    int index = 0;

    /**
     * 先序遍历变种
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode kthNode(TreeNode pRoot, int k){

        if (pRoot == null){
            return null;
        }
        //在左子树递归查找
        TreeNode node = kthNode(pRoot.left, k);
        if (node != null){
            return node;
        }
        //每查找一次计数加一
        index++;
        if (index == k){
            return pRoot;
        }
        //左子树和根节点都不是，则递归查找右子树
        node = kthNode(pRoot.right, k);
        if (node != null){
            return node;
        }

        return null;
    }

}
