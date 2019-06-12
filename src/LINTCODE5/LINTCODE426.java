package LINTCODE5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE426 {

    /*Description
    *给一个由数字组成的字符串。求出其可能恢复为的所有IP地址。
    * (你的任务就是往这段字符串中添加三个点, 使它成为一个合法的IP地址. 返回所有可能的IP地址.)
    * */

    /*Solution
    * 递归回溯即可
    * */


    public List<String> restoreIpAddresses(String s) {
        if(s.length()==0)
            return Collections.emptyList();
        List<String> result=new ArrayList<>();
        recursion(result,s,0,3);
        return result;
        // write your code here
    }

    private void recursion(List<String> result,String s,int start,int n){
        if(start==s.length()||n==0){
            int curr=Integer.parseInt(s.substring(start,s.length()));
            if(curr<=255&&curr>0&&s.charAt(start)!='0'||s.length()-start==1&&curr==0){
                result.add(s);
            }
            return;
        }
        for(int i=start+1;i<s.length();i++){
            int curr= Integer.parseInt(s.substring(start,i));
            if(curr==0){
                recursion(result,s.substring(0,i)+"."+s.substring(i,s.length()),i+1,n-1);
                return;
            }else if(curr>255){
                return;
            }else{
                recursion(result,s.substring(0,i)+"."+s.substring(i,s.length()),i+1,n-1);
            }
        }
    }

}
