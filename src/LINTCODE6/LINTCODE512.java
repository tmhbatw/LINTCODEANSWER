package LINTCODE6;

public class LINTCODE512 {
    /*Description
    *有一个消息包含A-Z通过以下规则编码
    * 'A' -> 1
    * 'B' -> 2
    * ...
    * 'Z' -> 26
    * 现在给你一个加密过后的消息，问有几种解码的方式
    * */

    /*Solution
    * 递归方法如下（超时）
    * 动态规划试一下
    * */

    public int numDecodings(String s) {
        if(s.length()==0||s.equals("0"))
            return 0;
        int[] result=new int[s.length()+1];
        result[1]=1;
        result[0]=1;
        for(int i=2;i<result.length;i++){
            int cur=s.charAt(i-1)-'0';
            if(cur>0)
                result[i]+=result[i-1];
            int curr=(s.charAt(i-2)-'0')*10+cur;
            if(curr<=26&&curr>=10){
                result[i]+=result[i-2];
            }
        }
        return result[result.length-1];
        // write your code here
    }

 /*   int result=0;
    public int numDecodings(String s) {
        if(s.length()==0||s.equals("0"))
            return 0;
        recursion(s);
        return result;
        // write your code here
    }

    private void recursion(String s){
        if(s.length()==0){
            result++;
            return;
        }
        for(int i=0;i<s.length();i++){
            int cur=Integer.parseInt(s.substring(0,i+1));
            if(cur>26)
                return;
            recursion(s.substring(i+1,s.length()));
        }
    }*/
}
