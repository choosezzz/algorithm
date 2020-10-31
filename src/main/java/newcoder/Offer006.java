package newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/8 20:11
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Offer006 {

    /**
     * 思路：变种的二分查找算法
     * 数组旋转之后形成两个非递减序列，末尾的值 <= 开头的值
     * 退出条件：左右查找最终为一个点，该点则为最小值
     * 1.mid >= first && >= end :
     * 说明中间值处于第一个非递减序列，则从中间值后面的数组中查找最小值
     * 2.mid < first || mid<end :
     * 说明中间值处于第二个非递减序列中，
     * 因为第二个非递减序列中包含最小值，所以从中间值开始往前查找
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {

        if (array == null || array.length <= 0) {
            return 0;
        }

        //左起下标
        int left = 0;
        //右起下标
        int right = array.length - 1;
        int end = array.length - 1;
        while (left < right) {
            //中间位置
            int mid = (right + left) / 2;
            //中间值>=数组最左边值&&>=数组最右边值
            if (array[mid] >= array[0] && array[mid] >= array[end]) {
                //中间点仍然处在第一个非递减序列，舍弃左边序列
                left = mid + 1;
            } else {
                //中间点处在第二个非递减序列，中间点及中间点前面的值可能为最小值
                right = mid;
            }
        }
        return array[right];
    }

    public static void main(String[] args) {
        int[] arr = {5,5,5,23,1,2,2,5,5};
        System.out.println(new Offer006().minNumberInRotateArray(arr));
    }
}
