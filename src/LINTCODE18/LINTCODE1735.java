package LINTCODE18;

import java.util.List;

public class LINTCODE1735 {
    /*Description
    * 如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
    * 现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。
    * */

    public int superpalindromesInRange(String L, String R) {
        long l=Long.parseLong(L),r=Long.parseLong(R);
        int result=0;
        if(l<=1&&r>=1)
            result++;
        if(l<=4&&r>=4)
            result++;
        if(l<=9&&r>=9)
            result++;
        for(int i=0;i<10000;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            for (int ii = sb.length() - 1; ii >= 0; ii--) {
                sb.append(sb.charAt(ii));
            }
            long curr = Long.parseLong(sb.toString());
            curr*=curr;
            if(curr>r)
                break;
            if(isPalindromes(curr)&&curr>=l){
                System.out.println(curr);
                result++;
            }
        }
        for(int cur=0;cur<10000;cur++){
            for(int i=0;i<=9;i++){
                StringBuilder curSb=new StringBuilder();
                curSb.append(cur);
                curSb.append(i);
                for (int j = curSb.length() - 2; j >= 0; j--) {
                    curSb.append(curSb.charAt(j));
                }
                long curr=Long.parseLong(curSb.toString());
                curr*=curr;
                if(curr>r)
                    return result;
                if(isPalindromes(curr)&&curr>=l) {
                    System.out.println(curr);
                    result++;
                }
            }
        }
        return result;
        // Write your code here
    }

    private boolean isPalindromes(long cur){
        String s=cur+"";
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        String l="4",r="1000000";
        System.out.println(new LINTCODE1735().superpalindromesInRange(l,r));
    }
}
