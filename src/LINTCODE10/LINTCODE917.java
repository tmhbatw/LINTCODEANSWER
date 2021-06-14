package LINTCODE10;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE917 {
    /*Description
    * 给定一个字符串s，返回所有回文排列(不重复)。如果没有回文排列，则返回空列表。
    * */
    List<String> result=new ArrayList<>();
    public List<String> generatePalindromes(String s) {
        int[] time=new int[128];
        for(int i=0;i<s.length();i++)
            time[s.charAt(i)]++;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<128;i++){
            if(time[i]%2==1){
                if(sb.length()>0)
                    return result;
                time[i]--;
                sb.append((char)(i));
            }
        }
        dfs(time,sb,s.length());
        return result;
        // write your code here
    }

    private void dfs(int[] time,StringBuilder sb,int length){
        if(sb.length()==length){
            result.add(sb.toString());
            return;
        }
        for(int i=0;i<128;i++){
            if(time[i]>0){
                time[i]-=2;
                StringBuilder curSb=new StringBuilder(sb);
                curSb.append((char)(i));
                curSb.insert(0,(char)(i));
                dfs(time,curSb,length);
                time[i]+=2;
            }
        }
    }

}
