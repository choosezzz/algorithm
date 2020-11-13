package util;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @Author dingshuangen
 * @Date 2020/11/13 21:25
 */
public class ArrayUtil {

    private static final int[] ARR = new int[]{9, 4, 5, 6, 9, 1, 2, 3, 11, 86};

    public static boolean isEmpty(int[] arr) {
        return arr == null || arr.length == 0;
    }

    public static void callAndPrint(Function<int[], int[]> function) {
        int[] apply = function.apply(ARR);
        System.out.println(Arrays.toString(apply));
    }
}
