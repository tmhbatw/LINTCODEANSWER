package LINTCODE13;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1261 {
    /*Description
    * 找出给定字符串的最长子串，使得该子串中的每一个字符都出现了至少k次，返回这个子串的长度。
    * */

    public int longestSubstring(String s, int k) {
        int[] time=new int[128];
        int length=s.length();
        for(int i=0;i<length;i++)
            time[s.charAt(i)]++;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<length;i++){
            if(time[s.charAt(i)]<k)
                q.add(i);
        }
        q.add(s.length());
        int start=0;
        int result=0;
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int i=start+1;i<cur;i++){
                int[] curTime=new int[128];
                for(int j=i;j<cur;j++){
                    curTime[s.charAt(j)]++;
                    if(isMatch(curTime,k)){
                        result=Math.max(result,j-i+1);
                    }
                }
            }
            start=cur+1;
        }
        return result;
        // write your code here
    }

    private boolean isMatch(int[] time,int k){
        for(int cur:time){
            if(cur>0&&cur<k)
                return false;
        }
        return true;
    }
}
