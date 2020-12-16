package LINTCODE14;

public class LINTCODE1337 {
    /*Description
    * 写一个给定整数N的函数，返回通过在整数N的十进制表示形式内插入一个'5'数字而获得的最大可能值。
    * */

    public int MaximumPossibleValue(int N) {
        if(N>=0){
            String s=""+N;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i++){
               char cur=s.charAt(i);
               if((cur-'0')<5){
                   sb.append(5);
                   return Integer.parseInt(sb.toString()+s.substring(i));
               }
               sb.append(cur);
            }
            return N*10+5;
        }
        StringBuilder sb=new StringBuilder();
        sb.append('-');
        String s=Math.abs(N)+"";
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if((cur-'0')>5){
                sb.append(5);
                return Integer.parseInt(sb.toString()+s.substring(i));
            }
            sb.append(cur);
        }
        return N*10-5;
        // write your code here
    }
}
