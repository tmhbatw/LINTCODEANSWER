package LINTCODE10;

public class LINTCODE928 {
    /*Description
    * 给定一个字符串，找出最长子串T
    * T的长度，它最多包含2个不同的字符
    * */

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] num=new int[128];
        int count=0;
        int right=0;
        int left=0;
        int result=0;
        int sLength=s.length();
        for(;right<sLength;right++){
            char cur=s.charAt(right);
            num[cur]++;
            if(num[cur]==1)
                count++;
            if(count==3) {
                result=Math.max(right-left,result);
                while(count==3){
                    num[s.charAt(left)]--;
                    if(num[s.charAt(left++)]==0)
                        count--;
                }
            }
        }
        return Math.max(result,right-left);
        // Write your code here
    }
}
