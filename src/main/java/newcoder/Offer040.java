package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/11/15 23:33
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * <p>
 * //num1,num2分别为长度为1的数组。传出参数
 * //将num1[0],num2[0]设置为返回结果
 *
 * 前提知识：
 * 异或运算：对应位相同则为0，不同则为1
 * 如果a、b两个值相同，异或结果为0。
 * 如果a、b两个值不相同，则异或结果中两个数不相同的位为1。
 * n^0=n
 * n^n=0
 * n^n^m=n^(n^m)=m
 */
public class Offer040 {

    /**
     * 运行时间：13ms
     * 占用内存：9672k
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {

        if (array == null || array.length == 0) {
            return;
        }
        int temp = array[0];
        //首先把数组中的数字全部进行异或，相同的两个数相互抵消
        // 剩下的数则为两个不同的数异或结果
        for (int i = 1; i < array.length; i++) {
            temp ^= array[i];
        }
        //把异或结果的最后一位1的那位找出来
        temp &= -temp;
        //以这一位是否为1或者0作为分类标准进行分类
        for (int val : array) {
            if ((val & temp) == 0) {
                num1[0] ^= val;
            } else {
                num2[0] ^= val;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,4,5,6,6,7,7};
        new Offer040().FindNumsAppearOnce(arr, new int[1], new int[1]);
        System.out.println(5^8);
    }
}
