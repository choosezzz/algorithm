package main.java.newcoder;

/**
 * @author dingshuangen
 * @date 2020/4/27 22:47
 */
public class StringReplace {
    public static void main(String[] args) {
        String str = "we are happy.";
        System.out.println(str.replaceAll(" ", "%20"));
    }

    public String repace(StringBuffer str){

        if (str == null || str.length() <= 0){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
