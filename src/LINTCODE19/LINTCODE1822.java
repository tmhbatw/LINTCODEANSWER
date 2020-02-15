package LINTCODE19;

public class LINTCODE1822 {
    /*Description
    *给定由N个字母 'a' 和/或 'b' 组成的字符串S。 在一次操作中，可以将一个字母替换为另一个字母
    * （'a' 替换为 'b' 或 'b' 替换为 'a'）。 返回得到不包含三个连续相同字母的字符串所需的最小操作次数。
    * */

    public int MinimumMoves(String S) {
        if(S.length()==0)
            return 0;
        int result=0;
        for(int i=0;i<S.length();i++){
            char cur=S.charAt(i);
            int curLength=1;
            while(i<S.length()-1&&S.charAt(i+1)==cur) {
                i++;
                curLength++;
            }
            result+=curLength/3;
        }
        return result;
        // write your code here
    }
}
