package LINTCODE18;

public class LINTCODE1716 {
    /*Description
    * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
    * 我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
    * 返回使 S 单调递增的最小翻转次数。
    * */

    public int minFlipsMonoIncr(String S) {
        int times=0;//第一位用来保存0的个数，第二位用来保存1的个数
        for(int i=0;i<S.length();i++) {
            if (S.charAt(i) == '0')
                times++;
        }
        int result=times;
        int time=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='1'){
                time++;
            }else{
                times--;
            }
            result=Math.min(time+times,result);
        }
        return result;
        // Write your code here.
    }
}
