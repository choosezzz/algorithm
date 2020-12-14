package interview;

/**
 * @Author dingshuangen
 * @Date 2020/12/9 11:37
 */
public class Baidu {

    public static boolean palindrome(int m) {

        if (m < 0) {
            return false;
        }

        int left = m;
        int right = 0;
        while (right <= left) {
            int last = left % 10;
            left /= 10;
            if (left == right) {
                return true;
            }
            right = right * 10 + last;
        }
        return false;
    }

    public static boolean palindrome2(int m) {

        if (m < 0) {
            return false;
        }

        int left = m;
        int right = 0;
        while (right <= left) {
            right = right * 10 + left % 10;
            left /= 10;
        }
        return left == right || left == right / 10;
    }

    public static boolean palindrome3(String str) {

        if (str == null || str.isEmpty()) {
            return false;
        }
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left <= right){
            if (chars[left++] != chars[right--]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(palindrome(12321));
        System.out.println(palindrome2(12321));
        System.out.println(palindrome3("133321"));
    }
}
