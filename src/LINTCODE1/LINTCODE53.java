package LINTCODE1;

public class LINTCODE53 {

    /*Description
    * Given an input string, reverse the string word by word.
    * */

    /*Solution
    * 转换位置，稍微注意多个空格情况处理即可
    * */

    public static String reverseWords(String s) {
        s+=" ";
        String result="";
        String[] res=s.split(" ");
        for(int i=res.length-1;i>0;i--){
            if(res[i].equals(""))
                continue;
            result+=res[i]+" ";
        }

        return result.substring(0,result.length()>0?result.length()-1:0);
    }

}
