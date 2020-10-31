package newcoder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author dingshuangen
 * @Date 2020/10/31 15:57
 * <p>
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Offer027 {

    /**
     * 运行时间：71ms
     * 占用内存：11960k
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {

        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return res;
        }

        perm(str.toCharArray(), res, 0);
        Collections.sort(res);
        return res;
    }

    /**
     *
     * @param arr 原始数组
     * @param res 结果集
     * @param index
     */
    public void perm(char[] arr, ArrayList<String> res, int index) {
        //排列到最后一位
        if (index == arr.length - 1) {
            res.add(new String(arr));
            return;
        }

        //从一个位置开始，分别和固定位交换位置，得到全部的排列组合
        for (int i = index; i < arr.length; i++) {
            //两个字符相同，交换后得到的序列一样
            if (i != index && arr[i] == arr[index]) {
                continue;
            }
            //交换两个元素位置
            swap(arr, i, index);
            //递归产生全部排列
            perm(arr, res, index + 1);
            //复原
            swap(arr, i, index);
        }
    }

    public void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void main(String[] args) {
        ArrayList<String> abc = new Offer027().Permutation("abc");
        System.out.println(abc.size());
    }
}
