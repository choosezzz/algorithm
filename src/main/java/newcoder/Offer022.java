package newcoder;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @Author dingshuangen
 * @Date 2020/10/30 22:16
 *
 *从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Offer022 {


    /**
     * 运行时间：10ms
     *
     * 占用内存：9396k
     *
     * 使用队列保存树的每层数据
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        if (root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode header = queue.poll();
            res.add(header.val);
            if (header.left != null){
                queue.add(header.left);
            }
            if (header.right != null){
                queue.add(header.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(15);

        ArrayList<Integer> integers = new Offer022().PrintFromTopToBottom(root);
        System.out.println(integers.size());
    }
}
