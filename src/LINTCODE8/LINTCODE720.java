package LINTCODE8;

public class LINTCODE720 {
    /*Description
    * 给一包含大写字母和整数(从 0 到 9)的字符串, 试写一函数返回有序的字母以及数字和.
    * */

    public String rearrange(String str) {
        int[] charNum=new int[26];
        int sum=0;
        for(int i=0;i<str.length();i++){
            char cur=str.charAt(i);
            if(cur<='9'&&cur>='0'){
                sum+=cur-'0';
            }else{
                charNum[cur-'A']++;
            }
        }
        StringBuffer res=new StringBuffer();
        for(int i=0;i<charNum.length;i++){
            if(charNum[i]==0)
                continue;
            char cur=(char)(i+'A');
            while(charNum[i]-->0)
                res.append(cur);
        }
        res.append(sum==0?"":sum);
        return res.toString();
        // Write your code here
    }
}
