package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/11/18 22:03
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class Offer049 {

    /**
     * 运行时间：10ms
     *
     * 占用内存：9460k
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str == null || str.isEmpty()){
            return 0;
        }

        char[] chars = str.toCharArray();
        int start = 0;
        boolean positive = true;
        if (chars[0] == '-'){
            start = 1;
            positive = false;
        }else if (chars[0] == '+'){
            start = 1;
        }

        int res = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                res = res * 10 + chars[i] - '0';
            }else {
                return 0;
            }
        }

        return positive ? res : -res;
    }
}
