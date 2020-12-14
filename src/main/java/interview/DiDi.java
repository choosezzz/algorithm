package interview;

/**
 * @Author dingshuangen
 * @Date 2020/12/1 9:08
 *
 * 滴滴
 */
public class DiDi {

    /**
     * 求根号2
     * 思路如下：
     * 构造一个数对序列，初始值为（1，1），
     * 然后对该数对依照如下规则进行演化：
     * 下一个数对中的第一个数为前一个数对中两个数之和，记为A+B，第二个数为2*A+B（A代表前个数对的第一个数，B代表前个数对的第二个数）
     * <p>
     * 那么依照如上规则，构造的数对序列如下：
     * (1,1)
     * (2,3)
     * (5,7)
     * (12,17)
     * (29,41)
     * (70,99)
     * (169,239)
     * ...
     * <p>
     * 可以证明，第二个除以第一个数（暂且记为B/A）越往后越接近根号2.
     * http://www.fengchang.cc/post/129
     *
     * @return
     */
    public static double sqrt2() {

        double a = 1;
        double b = 1;
        for (int i = 0; i < 20; i++) {
            double tmp = a;
            a = a + b;
            b = 2 * tmp + b;
        }
        return b / a;
    }

    /**
     * 面试
     * 对浮点数开平方根
     * 1. 二分法
     * 2. 牛顿法
     * @param num
     * @return
     */
    public static double sqrt(double num){

        return 0.0;
    }

    public static void main(String[] args) {
        System.out.println(sqrt2());
    }
}
