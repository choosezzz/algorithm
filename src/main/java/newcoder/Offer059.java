package newcoder;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @Author dingshuangen
 * @Date 2020/10/31 17:37
 *
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Offer059 {

    /**
     * 运行时间：15ms
     * 占用内存：9680k
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null){
            return res;
        }

        int row = 1;
        //记录当前行的数据
        ArrayDeque<TreeNode> queue1 = new ArrayDeque<>();
        queue1.push(pRoot);
        TreeNode pop;
        while (!queue1.isEmpty()){
            //记录下一行的数据
            ArrayDeque<TreeNode> queue2 = new ArrayDeque<>();
            ArrayList<Integer> list = new ArrayList<>();
            //遍历当前行
            while (!queue1.isEmpty()){
                pop = queue1.pop();
                if (pop == null){
                    continue;
                }
                list.add(pop.val);
                //奇数行
                if ((row & 1) == 1){
                    if (pop.left != null){
                        queue2.push(pop.left);
                    }
                    if (pop.right != null){
                        queue2.push(pop.right);
                    }
                }else {
                    if (pop.right != null){
                        queue2.push(pop.right);
                    }
                    if (pop.left != null){
                        queue2.push(pop.left);
                    }
                }
            }
            //记录当前行的结果
            res.add(list);
            //下一行变为当前行
            queue1 = queue2;
            row++;
        }

        return res;
    }
}
