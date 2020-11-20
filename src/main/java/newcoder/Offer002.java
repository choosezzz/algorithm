package newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/7 22:08
 * <p>
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Offer002 {

    public static String repalceSpace(String str) {
        int n = str.length();
        int size = 0;
        char[] result = new char[n * 3];
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == ' ') {
                result[size++] = '%';
                result[size++] = '2';
                result[size++] = '0';
            } else {
                result[size++] = str.charAt(i);
            }
        }
        return new String(result, 0, size);
    }
    public String replaceSpace(StringBuffer str) {

        if(str == null || str.length() <= 0){
            return "";
        }
        int p1 = str.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' '){
                //两个空格
                str.append("  ");
            }
        }
        int p2 = str.length() - 1;
        while (p1 >= 0 && p2 > p1){
            char c = str.charAt(p1--);
            if (c == ' '){
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');

            }else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();

    }


    public static void main(String[] args) {
        System.out.println(repalceSpace("We Are Happy."));
    }
}
