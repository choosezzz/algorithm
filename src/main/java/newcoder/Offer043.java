package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/11/16 22:02
 * <p>
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class Offer043 {

    /**
     * 运行时间：12ms
     *
     * 占用内存：9568k
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str, int n) {

        if (str == null || str.length() <= n) {
            return str;
        }

        //左旋最终结果为头部n个字符移动到尾部
        return str.substring(n, str.length()) + str.substring(0, n);
    }
}
