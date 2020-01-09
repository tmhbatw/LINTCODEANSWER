package LINTCODE10;

public class LINTCODE916 {
    /*Description
    *给定一个字符串，判断字符串是否存在一个排列是回文排列。
    * */

    /*Solution
    * 统计每个字符出现的次数即可
    * */

    public boolean canPermutePalindrome(String s) {
        int[] cur=new int[128];
        for(int i=0;i<s.length();i++){
            cur[s.charAt(i)]++;
        }
        int index=0;
        for(int i=0;i<128;i++){
            if(cur[i]%2==1)
                index++;
            if(index==2)
                return false;
        }
        return true;
        // write your code here
    }

}
