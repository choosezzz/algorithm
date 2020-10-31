package newcoder;

import common.TreeNode;

import java.util.ArrayList;

/**
 * @Author dingshuangen
 * @Date 2020/10/31 15:34
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Offer026 {

    /**
     * 运行时间：11ms
     * 占用内存：9404k
     * 中序遍历：左根右
     * 借助list存储每个节点
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) {
            return null;
        }

        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(pRootOfTree, list);
        TreeNode node = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            node.right = list.get(i);
            list.get(i).left = node;
            node = list.get(i);
        }
        list.get(0).left = null;
        list.get(list.size() - 1).right = null;
        return list.get(0);
    }

    public void inOrder(TreeNode root, ArrayList<TreeNode> list) {

        if (root == null){
            return;
        }
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
}
