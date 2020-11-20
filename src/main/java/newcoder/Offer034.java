package newcoder;

/**
 * @Author dingshuangen
 * @Date 2020/11/3 22:40
 * <p>
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class Offer034 {

    /**
     * 运行时间：16ms
     * <p>
     * 占用内存：9536k
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int k = 0; k < chars.length; k++) {
                if (i == k) {
                    continue;
                }
                if (chars[i] == chars[k]) {
                    break;
                }
                if (k == chars.length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 运行时间：16ms
     *
     * 占用内存：9756k
     * @param str
     * @return
     */
    public int firstNotRepeatingChar(String str) {

        if (str == null || str.isEmpty()) {
            return -1;
        }
        //ASCII 码只有 128 个字符
        int[] count = new int[128];
        char[] chars = str.toCharArray();
        for (char c : chars) {
            count[c]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i]] == 1){
                return i;
            }
        }
        return -1;
    }
}
