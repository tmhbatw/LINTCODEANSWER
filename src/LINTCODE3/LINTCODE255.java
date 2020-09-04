package LINTCODE3;

public class LINTCODE255 {
    /*Description
    *给出一个源字符串sourceString和一个目标字符串数组targetStrings，判断目标字符串数组中的每一个字符串是否是源字符串的子串
    * */

    public boolean[] whetherStringsAreSubstrings(String sourceString, String[] targetStrings) {
        int length=targetStrings.length;
        boolean[] result=new boolean[length];
        for(int i=0;i<length;i++){
            if(sourceString.indexOf(targetStrings[i])!=-1)
                result[i]=true;
            else
                result[i]=false;
        }
        return result;
        // write your code here
    }
}
