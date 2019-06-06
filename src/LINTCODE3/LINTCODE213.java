package LINTCODE3;

public class LINTCODE213 {
    /*Description
    *设计一种方法，通过给重复字符计数来进行基本的字符串压缩。
    * 例如，字符串 aabcccccaaa 可压缩为 a2b1c5a3 。而如果压缩后的字符数不小于原始的字符数，则返回原始的字符串。
    * 可以假设字符串仅包括 a-z 的字母。
    * */

    /*Solution
    * 设计变量统计前面的数字即可，注意设计一个变量统计是否是不存在相同字符的情况
    * */
    public String compress(String originalString) {
        if(originalString.length()==0)
            return originalString;
        String result="";
        int num=1;
        char last=originalString.charAt(0);
        for(int i=1;i<originalString.length();i++){
            if(originalString.charAt(i)==last){
                num++;
            }else{
                result+=last+""+num;
                last=originalString.charAt(i);
                num=1;
            }
        }
        result+=last+""+num;
        if(result.length()<originalString.length())
            return result;
        return originalString;
        // write your code here
    }
}
