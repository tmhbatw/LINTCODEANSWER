package LINTCODE4;

import java.util.Arrays;

public class LINTCODE384 {

    /*Description
    * Given a string, find the length of the longest substring without repeating characters.
    * Challenge
    * time complexity O(n)
    * */

    /*Solution
    * 滑动窗口试一下，创建一个数组用来存储每一个字符出现的次数，先假设全是小写字母，那么一共需要26位存储空间
    * 当出现相同的字符时，移动滑框左边的位置
    * */

    public int lengthOfLongestSubstring(String s) {
        int[] num=new int[128];
        int index=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            int cur=s.charAt(i);
            if(num[cur]>=1){
                max=Math.max(i-index,max);
                while(s.charAt(i)!=s.charAt(index)){
                    num[s.charAt(index++)]=0;
                }
                index++;

            }else{
                num[cur]++;
            }
        }
        max=Math.max(s.length()-index,max);
        return max;
        // write your code here
    }
}
