package interview;

/**
 * @Author dingshuangen
 * @Date 2020/11/22 17:20
 * 美团一面，最长不重复子串
 */
public class MeiTuan {
    public static String getMaxSubStr(String str) {

        if (str == null || str.length() <= 0) {
            return str;
        }
        int len = str.length();
        int start = 0;
        int end = 0;
        int max = 1;
        int finalStart = 0;
        int finalEnd = 1;
        int[] count = new int[128];
        while (start < len && end < len) {
            int cnt = ++count[str.charAt(end)];
            if (cnt == 1) {
                end++;
                if (max < (end - start)) {
                    max = end - start ;
                    finalStart = start;
                    finalEnd = end;
                }
                continue;
            }
            start++;
            end = start;
            count = new int[128];
        }
        return str.substring(finalStart, finalEnd);
    }

    public static void main(String[] args) {

        System.out.println(getMaxSubStr("aacbvvv"));
    }
}
