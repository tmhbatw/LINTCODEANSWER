package LINTCODE;

public class LINTCODE78 {
    /*Description
    * Given k strings, find the longest common prefix (LCP).
    * */

    /*Solution
    * 取第一个字符串的前i个字符，与其他字符串前i个字符相比较
    * 若相同则循环取第一个字符串的i+1个字符
    * 如不相同则返回A字符串的前i-1个字符即可
    * */
    public String longestCommonPrefix(String[] strs) {
        String result="";
        if(strs.length==0)
            return result;
        for(int i=0;i<strs[0].length();i++){
            char curr=strs[0].charAt(i);
            if(!containChar(strs,curr,i))
                break;
            result+=curr;
        }
        return result;
        // write your code here
    }

    private boolean containChar(String[] strs,char c,int index){
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()==0||strs[i].charAt(index)!=c)
                return false;
        }
        return true;
    }
}
