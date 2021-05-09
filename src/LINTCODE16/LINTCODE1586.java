package LINTCODE16;

public class LINTCODE1586 {
    /*Description
    * 给定一个只包含大小写字母的英文单词，问最少需要按键几次才能将单词输入（可以按caps lock以及shift键，一开始默认输入小写字母）
    * */

    public int getAns(String s) {
        int length=s.length();
        int[] dp1=new int[length+1];
        int[] dp2=new int[length+1];
        dp2[0]=1;
        for(int i=0;i<length;i++){
            char cur=s.charAt(i);
            if(cur<='z'&&cur>='a'){
                dp1[i+1]=Math.min(dp1[i]+1,dp2[i]+2);
                dp2[i+1]=Math.min(dp1[i]+2,dp2[i]+2);
            }else{
                dp1[i+1]=Math.min(dp1[i]+2,dp2[i]+2);
                dp2[i+1]=Math.min(dp1[i]+2,dp2[i]+1);
            }
        }
        return Math.min(dp1[length],dp2[length]);
        // Write your code here
    }
}
