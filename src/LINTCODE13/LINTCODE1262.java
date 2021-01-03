package LINTCODE13;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1262 {
    /*Description
    * UTF-8编码中，一个字符的长度可以是1到4字节，服从如下的规则：
    * 对于单字节的字符，第1位是一个'0'，后续二进制位为其unicode编码。
    * 对于n字节的字符，第一个字节的前n位全是'1'，第n+1位是'0'；对于后续的n-1字节，每个字节最高两位是'10'。
    * 以下是字符编号范围与UTF-8编码对应表：
    * */

    //递归方法超时
    public boolean validUtf8(int[] data) {
        if(data==null||data.length==0)
            return false;
        int length=data.length;
        String[] s=new String[length];
        for(int i=0;i<length;i++){
            s[i]=getData(data[i]);
        }
        boolean[] match=new boolean[length+1];
        match[0]=true;
        for(int i=0;i<length;i++){
            for(int j=0;j<4;j++){
                if(i-j<0)
                    break;
                if(match[i-j]&&isMatch(s,i-j,i))
                    match[i+1]=true;
            }
        }
        return match[length];
        // Write your code here
    }


    private boolean isMatch(String[] s,int start,int end){
        if(start==end){
            return s[start].charAt(0)=='0';
        }else{
            int n=end-start+1;
            for(int i=0;i<n;i++){
                if(s[start].charAt(i)!='1')
                    return false;
            }
            if(s[start].charAt(n)!='0')
                return false;
            for(int i=start+1;i<=end;i++){
                if(s[i].charAt(0)!='1'||s[i].charAt(1)!='0')
                    return false;
            }
            return true;
        }
    }

    private String getData(int cur){
        String s= Integer.toBinaryString(cur);
        int size=8-s.length();
        while(size-->0)
            s='0'+s;
        return s;
    }

    public static void main(String[] args){
        System.out.println(new LINTCODE1262().getData(0));
    }
}
