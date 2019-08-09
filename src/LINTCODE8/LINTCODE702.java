package LINTCODE8;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE702 {

    /*Description
    *给出两个字符串, 你需要修改第一个字符串，将所有与第二个字符串中相同的字符删除, 并且第二个字符串中不同的字符与第一个字符串的不同字符连接
    * */

    public String concatenetedString(String s1, String s2) {
        boolean[] ss2=new boolean[128];
        for(int i=0;i<s2.length();i++)
            ss2[s2.charAt(i)]=true;
        boolean[] ss1=new boolean[128];
        StringBuffer res=new StringBuffer("");
        for(int i=0;i<s1.length();i++) {
            ss1[s1.charAt(i)] = true;
            if(!ss2[s1.charAt(i)])
                res.append(s1.charAt(i));
        }
        for(int i=0;i<s2.length();i++)
            if(!ss1[s2.charAt(i)])
                res.append(s2.charAt(i));
         return res.toString();
        // write your code here
    }

    private static boolean isPrime(int n){
        if(n==2)
            return true;
        if(n%2==0)
            return false;
        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0)
                return false;
        }
        return true;

    }
    public static void main(String[] args){
        int count=0;
        for(int i=0;i<10000000;i++){
            if(isPrime(i))
                count++;
        }
        System.out.println(count);
    }
}
