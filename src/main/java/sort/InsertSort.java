package sort;

import util.ArrayUtil;

/**
 * @Author dingshuangen
 * @Date 2020/11/13 21:41
 * <p>
 * 插入排序：每次查找到合适的位置，将元素插入到合适位置
 */
public class InsertSort {

    public static int[] sort(int[] arr) {
        if (ArrayUtil.isEmpty(arr)) {
            return arr;
        }

        int length = arr.length;
        //从第二位开始，依次和前面的值比较，如果小于则将前面的元素向后移动，直到不小于前面的值，插入到该位置
        for (int i = 1; i < length; i++) {
            int insertVal = arr[i];
            int index = i - 1;
            //向前查找
            while (index >= 0 && insertVal < arr[index]) {
                //元素向后移动
                arr[index + 1] = arr[index];
                //向前移动
                index--;
            }
            //插入到不小于前面值的位置
            arr[index + 1] = insertVal;
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayUtil.callAndPrint(InsertSort::sort);
    }
}
