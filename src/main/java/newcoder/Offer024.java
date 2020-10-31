package newcoder;

import common.TreeNode;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author dingshuangen
 * @Date 2020/10/30 23:05
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Offer024 {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    /**
     * 运行时间：13ms
     * 占用内存：9788k
     *
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        dfs(root, target, new ArrayList<>());
        return res;
    }

    /**
     * 深度优先遍历 前序遍历
     *
     * @param root
     * @param target
     * @param path   保存路径节点的list
     */
    public void dfs(TreeNode root, int target, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }
        //路径直接保存当前节点值
        path.add(root.val);
        target -= root.val;
        //得到和为目标值的路径，同时需要当前节点为叶子节点
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        } else {
            //遍历左子树
            dfs(root.left, target, path);
            //遍历右子树
            dfs(root.right, target, path);
        }
        //遍历叶子节点不满足要求则进行回退
        path.remove(path.size() - 1);
    }

    private Stack<Integer> path = new Stack<>();
    private ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return list;
        }
        path.push(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList<>(path));
        } else {
            findPath(root.left, target);
            findPath(root.right, target);
        }
        path.pop();

        return list;
    }
}
