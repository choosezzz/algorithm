package newcoder;

import java.util.Arrays;

/**
 * @author dingshuangen
 * @date 2020/5/10 11:46
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Offer013 {


    /**
     * 运行时间：14ms
     * 占用内存：9528k
     * 利用插入排序思想，每次将奇数插入到偶数前面
     * @param array
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length <= 0) {
            return;
        }
        //奇数待插入位置
        int insert = 0;
        for (int i = 0; i < array.length; i++) {
            //当前待插入值
            int insertVal = array[i];

            if ((insertVal&1) == 1){
                //为奇数，则将当前值前面的所有偶数向后移动，然后将待插入值插入到insert位置，同时insert向后移动一位
                for (int j=i-1;j>=insert;j--){
                    array[j+1] = array[j];
                }
                array[insert++]=insertVal;
            }
        }
    }

    /**
     * 运行时间：13ms
     * 占用内存：9368k
     * 暴力循环，先将奇数放入临时数组
     * 然后将偶数放入临时数组
     * 最终将临时数组数据全部拷贝到原数组
     * @param array
     */
    public void violenceReorderArray(int[] array) {

        if (array == null || array.length <= 0) {
            return;
        }
        int[] tmp = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i]&1) == 1){
                tmp[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i]&1) == 0){
                tmp[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        Offer013 instance = new Offer013();
//        instance.violenceReorderArray(array);
        instance.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

    public int[] reorderArr(int[] arr){

        if (arr == null || arr.length <= 0){
            return arr;
        }
        //待插入位置，奇数在前
        int insert = 0;
        for (int i = 0; i < arr.length; i++) {
            int insertVal = arr[i];
            //当前为奇数,将该数前面的所有偶数向后移动
            if ((insertVal&1) == 1){
                for (int j = i -1; j>=insert; j--){
                    arr[j+1]=arr[j];
                }
                //待插入位置向后移动一位
                arr[insert++] = insertVal;
            }
        }
        return arr;
    }
}
