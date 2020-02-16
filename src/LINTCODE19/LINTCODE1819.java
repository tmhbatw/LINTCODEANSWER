package LINTCODE19;

public class LINTCODE1819 {
    /*Description
    * 给定一个长度为N且只包含a和b的字符串S
    * 你需要找出最长的子串长度，使得其中不包含三个连续的字母。即，找出不包含aaa或bbb的最长子串长度。注意
    * S是其本身的子串。
    * */

    public int longestSemiAlternatingSubstring(String s) {
        int result=0;
        int preSum=0;
        int length=s.length();
        for(int i=0;i<length;i++){
            char cur=s.charAt(i);
            int curNum=1;
            while(i<length-1&&s.charAt(i+1)==cur){
                i++;
                curNum++;
            }
            if(curNum<3)
                preSum+=curNum;
            else{
                result=Math.max(result,preSum+2);
                preSum=2;
            }
        }
        return Math.max(result,preSum);
        // write your code here
    }
}
