package LINTCODE16;

import java.util.Arrays;

public class LINTCODE1579 {
    /*Description
    * 在型月世界里面，普通人都会解决一个问题，这个问题是有一串英文字母，每次可以删掉一个英文字母
    * 求最少删多少次可以让每个字母出现的次数不同
    * */

    public int Kstart(String aString) {
        int[] num=new int[26];
        for(int i=0;i<aString.length();i++){
            num[aString.charAt(i)-'a']++;
        }
        Arrays.sort(num);
        int curMax=num[25];
        int result=0;
        for(int j=24;j>=0;j--){
            if(num[j]==0)
                return result;
            if(num[j]<curMax)
                curMax=j;
            else{
                curMax=curMax==0?0:curMax-1;
                result+=num[j]-curMax;
            }
        }
        return result;
        // write your code here
    }
}
