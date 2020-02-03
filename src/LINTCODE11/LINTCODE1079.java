package LINTCODE11;

public class LINTCODE1079 {
    /*Description
    * 给定字符串s，计算有相同数量的0和1的非空连续子串的数量，并且子串中所有的0和所有的1都是连续的。
    * 相同的子串出现多次则计数多次。
    * */

    public int countBinarySubstrings(String s) {
        int result=0;
        for(int i=0;i<s.length();i++){
            int time0=0,time1=0;
            boolean flag0=false,flag1=false;
            for(int j=i;j<s.length();j++){
                if(s.charAt(j)=='0') {
                    if(!flag0||s.charAt(j-1)=='0') {
                        time0++;
                        flag0=true;
                    }else
                        break;
                }
                else {
                    if(!flag1||s.charAt(j-1)=='1'){
                        time1++;
                        flag1=true;
                    }else
                        break;
                }
                if(time0==time1) {
                    result++;
                }
            }
        }
        return result;
        // Write your code here
    }
}
