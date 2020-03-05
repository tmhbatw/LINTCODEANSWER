package LINTCODE18;

public class LINTCODE1781 {
    /*Description
    * 给定一个由ascii编码的字符串（例如，“ABC”可以编码为“656667”），
    * 您需要编写一个将编码字符串作为输入并返回反转的解码字符串的函数。
    * */

    public String reverseAsciiEncodedString(String encodeString) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<encodeString.length();i+=2){
            int cur= Integer.parseInt(encodeString.substring(i,i+2));
            sb.append((char)(cur));
        }
        return sb.reverse().toString();
        // Write your code here
    }

    public static void main(String[] args){
        System.out.println((int)('A'));
        System.out.println((int)('Z'));
    }
}
