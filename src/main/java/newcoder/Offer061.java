package newcoder;

import common.TreeNode;

/**
 * @Author dingshuangen
 * @Date 2020/10/31 17:18
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * <p>
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 * <p>
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * <p>
 * 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
 */
public class Offer061 {

    /**
     * 运行时间：16ms
     * 占用内存：9672k
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {

        if (root == null) {
            return "#!";
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();

    }

    TreeNode Deserialize(String str) {
        if (str == null || str.isEmpty()){
            return null;
        }
        return deserialize(str.split("!"));
    }

    /**
     * 中序遍历二叉树
     * @param root
     * @param sb
     */
    public void serialize(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("#!");
            return;
        }
        //序列化根节点
        sb.append(root.val).append("!");
        //递归序列化左子树
        serialize(root.left, sb);
        //递归序列化右子树
        serialize(root.right, sb);
    }

    /**
     * 反序列化的下标
     */
    int index = -1;
    /**
     * 反序列化
     * @param str
     * @return
     */
    TreeNode deserialize(String[] str){
        //每次反序列化一个节点，字符数组向后取一位
        index++;
        //节点为空
        if ("#".equals(str[index])){
            return null;
        }
        //反序列化根节点
        TreeNode root = new TreeNode(Integer.parseInt(str[index]));
        //反序列化左子树
        root.left = deserialize(str);
        //反序列化右子树
        root.right = deserialize(str);
        return root;
    }
}
