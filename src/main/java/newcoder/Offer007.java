package main.java.newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/8 23:27
 * <p>
 * 大家都知道斐波那契数列，
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项
 * （从0开始，第0项为0，第1项是1）。
 * n<=39
 */
public class Offer007 {

    /**
     * 递归实现
     * f(n) = f(n-1) + f(n-2)
     * 运行时间：1201ms
     * 占用内存：9420k
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**
     * 循环实现
     * 运行时间：14ms
     * 占用内存：9160k
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {

        if (n <= 0) {
            return 0;
        }
        //f(n-2)
        int n0 = 0;
        //f(n-1)
        int n1 = 1;
        //f(n)
        int fn = 1;
        for (int i = 1; i < n; i++) {
            fn = n0 + n1;
            n0 = n1;
            n1 = fn;
        }
        return fn;
    }

    /**
     * 减少一次赋值，通过两个数加减
     * 运行时间：21ms
     * 占用内存：9384k
     *
     * @param n
     * @return
     */
    public int fibonacci_2(int n) {

        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int fn0 = 0;
        int fn1 = 1;
        while ((--n) > 0) {
            fn1 += fn0;
            fn0 = fn1 - fn0;
        }
        return fn1;
    }

    /**
     * f(n) = 2f(n-2) + f(n-3)
     * 运行时间：21ms
     * 占用内存：9232k
     *
     * @param n
     * @return
     */
    public int fibonacci_3(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n == 3) {
            return 3;
        }
        return 2 * fibonacci_3(n - 2) + fibonacci_3(n - 3);
    }

    /**
     * 运行时间：13ms
     * 占用内存：9176k
     *
     * @param n
     * @return
     */
    public int fibonacci_3_for(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int f1 = 1;
        int f2 = 1;
        int f3 = 3;
        while ((n--) > 3) {
            f3 = 2 * f2 + f1;
            f2 = f2 + f1;
            f1 = f2 - f1;
        }
        return f3;
    }
}
