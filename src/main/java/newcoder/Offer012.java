package newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/10 0:03
 * <p>
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class Offer012 {

    /**
     * 运行时间：45ms
     * 占用内存：10464k
     *
     * @param base
     * @param exponent
     * @return
     */
    public double power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    /**
     * 运行时间：44ms
     * 占用内存：10584k
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        double result = 1;
        if (exponent < 0) {
            exponent = -exponent;
            while ((exponent--) > 0) {
                result /= base;
            }
        } else {
            while ((exponent--) > 0) {
                result *= base;
            }
        }
        return result;
    }

    /**
     * 运行时间：38ms
     * 占用内存：10580k
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power2(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        int e = exponent;
        if (e < 0) {
            e = -e;
        }
        double result = 1;
        while ((e--) > 0) {
            result *= base;
        }
        return exponent > 0 ? result : 1 / result;
    }

    /**
     * 快速幂算法：结果等于指数对半拆解时所有指数为1时底数的乘积
     * 3^10=3^(2*5)=9^5=9^(4+1)=9*9^4=9*81^2=9*6561
     * 运行时间：38ms
     * 占用内存：10424k
     *
     * @param base
     * @param exponent
     * @return
     */
    public double fastPower(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        int pow = exponent;
        if (pow < 0) {
            pow = -pow;
        }
        double result = 1;

        while (pow > 0) {
            //偶数幂
            if (pow % 2 == 0) {
                //底数平方
                base *= base;
                //指数减少一半
                pow /= 2;
            } else {
                //奇数幂，结果为奇数幂时底数乘积
                result *= base;
                //指数减少一半（pow-1）/2
                pow /= 2;
                //底数平方
                base *= base;
            }
        }
        return exponent > 0 ? result : 1 / result;
    }

    /**
     * 运行时间：40ms
     * 占用内存：10532k
     *
     * @param base
     * @param exponent
     * @return
     */
    public double fastPower2(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        int pow = exponent;
        if (pow < 0) {
            pow = -pow;
        }
        double result = 1;

        while (pow > 0) {
            if ((pow & 1) == 1) {
                result *= base;
            }
            pow >>= 1;
            base *= base;
        }
        return exponent > 0 ? result : 1 / result;
    }

    public static void main(String[] args) {

        /**
         * int loop = 100000000;
         * int exp = 2000;
         * double base = 2;
         * fastPower1 : 1586565700
         * fastPower2 : 1210262000
         * math power : 17741283400
         *      Power : 232690252500
         *     Power2 : 232619488800
         */
        Offer012 instance = new Offer012();
        System.out.println(instance.fastPower2(2,4));

        System.out.println(instance.fastPower3(2,4));
        int loop = 100000000;
        int exp = 1024;
        double base = 2;
        long start = System.nanoTime();
        for (int i = 0; i < loop; i++) {
            instance.fastPower(base, exp);
        }
        System.out.println("fastPower1 : " + (System.nanoTime() - start));

        start = System.nanoTime();
        for (int i = 0; i < loop; i++) {
            instance.fastPower3(base, exp);
        }
        System.out.println("fastPower2 : " + (System.nanoTime() - start));

        start = System.nanoTime();
        for (int i = 0; i < loop; i++) {
            instance.power(base, exp);
        }
        System.out.println("math power : " + (System.nanoTime() - start));

        start = System.nanoTime();
        for (int i = 0; i < loop; i++) {
            instance.Power(base, exp);
        }
        System.out.println("     Power : " + (System.nanoTime() - start));

        start = System.nanoTime();
        for (int i = 0; i < loop; i++) {
            instance.Power2(base, exp);
        }
        System.out.println("    Power2 : " + (System.nanoTime() - start));
    }

    public double fastPower3(double base, int exp){

        int e = exp < 0 ? -exp : exp;
        double result = 1;
        while (e > 0){
            //奇数次幂
            if ((e&1) == 1){
                result *= base;
            }
            e >>= 1;
            base *= base;
        }
        if (exp < 0){
            result = 1/result;
        }
        return result;
    }
}