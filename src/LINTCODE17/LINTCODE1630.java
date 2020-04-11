package LINTCODE17;

public class LINTCODE1630 {
    /*Description
    *现在有一个只由数字和小写字母组成的字符串s，如果字符串s是有趣的，那么s一定能够切分成若干个子串，
    * 每个子串满足以数字开头，且数字代表其后面字符的个数。例如 s = "4g12y6hunter"，我们可以分成"4g12y"和"6hunter"，故该字符串是有趣的。
    * 如果s是一个有趣的字符串，输出"yes"，否则输出"no"
    * */

    public String check(String s) {
        char[] c=s.toCharArray();
        return function(c,0)?"yes":"no";
        // Write your code here
    }

    private boolean isInteger(char cur){
        return cur<='9'&&cur>='0';
    }

    private boolean function(char[] c,int start){
        if(start==c.length)
            return true;
        if(start>c.length)
            return false;
        if(!isInteger(c[start])||c[start]=='0')
            return false;
        int number=c[start]-'0';
        boolean res=function(c,start+number+1);
        while(start<c.length-1&&isInteger(c[start+1])){
            number*=10;
            number+=c[++start]-'0';
            res|=function(c,start+1+number);
        }
        return res;
    }
}
