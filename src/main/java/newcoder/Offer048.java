package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/11/18 22:12
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * <p>
 *
 *  二进制位运算
 *  a(i)   b(i)   无进位     进位
 *  0       0       0       0
 *  1       0       1       0
 *  0       1       1       0
 *  1       1       0       1
 * 无进位和运算就是按位异或结果
 * 进位就是与运算结果但是需要左移一位，因为进位影响下一位的运算。
 * 所以s = a + b,其实就是无进位和+进位的结果。
 */
public class Offer048 {

    public int Add(int num1, int num2) {

        int result;
        int ans;
        do {
            //无进位结果
            result = num1 ^ num2;
            //进位结果
            ans = (num1 & num2) << 1;
            num1 = result;
            num2 = ans;
        } while (ans != 0);
        return result;
    }
}
