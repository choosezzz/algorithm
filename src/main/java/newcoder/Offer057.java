package newcoder;

import common.TreeLinkNode;

import java.util.ArrayList;

/**
 * @Author dingshuangen
 * @Date 2020/11/2 12:44
 * <p>
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Offer057 {

    /**
     * 运行时间：16ms
     *
     * 占用内存：9772k
     * 
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode == null) {
            return null;
        }
        //右孩子不为空，则中序遍历的下一个节点为右孩子的最左孩子节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

        //父节点不为空
        while (pNode.next != null) {
            //如果当前节点为父节点的左孩子，则当前节点下一个节点为父节点
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            //如果为右孩子，则向上判断父节点是否为祖父节点的左孩子
            pNode = pNode.next;
        }
        return null;
    }

    /**
     * 运行时间：20ms
     * 占用内存：9820k
     * <p>
     * 暴力解题：找到根节点，然后中序遍历，得到当前节点的下一个节点
     *
     * @param pNode
     * @return
     */
    private TreeLinkNode getNext(TreeLinkNode pNode) {

        if (pNode == null) {
            return null;
        }

        TreeLinkNode root = pNode;
        while (root.next != null) {
            root = root.next;
        }

        ArrayList<TreeLinkNode> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val == pNode.val) {
                return list.get(i + 1);
            }
        }
        return null;
    }

    private void inOrder(TreeLinkNode root, ArrayList<TreeLinkNode> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
}
