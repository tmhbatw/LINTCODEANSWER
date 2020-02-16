package LINTCODE19;

public class LINTCODE1821 {
    /*Description
    * 给定一个长度为N的只包含字母A 和/或 B 的字符串
    * S。我们的目标是通过删除最少的字符使得字符串变成A...AB...B的形式（所有的A都在B前面）。
    * 特别的，如果字符串只包含A或B也是符合条件的。
    * 请写一个函数，给定一个字符串S，返回最小需要删除的字符数。
    * */

    public int minDeletionsToObtainStringInRightFormat(String s) {
        int timeA=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='A')
                timeA++;
        int result=timeA;
        int timeB=0;
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur=='A')
                timeA--;
            if(cur=='B')
                timeB++;
            result=Math.min(timeA+timeB,result);
        }
        return result;
        // write your code here
    }
}
