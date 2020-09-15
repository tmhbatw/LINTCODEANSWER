package LINTCODE13;

import java.util.Arrays;

public class LINTCODE1222 {
    /*Description
    * 实现一个函数来检查输入字符串是一个合法的IPv4地址，还是一个合法的IPv6地址，抑或是两者都不是。
    * IPv4地址被规范地表示为点分十进制，包含四个取值为0到255的十进制数，其间使用点号(".")来进行分隔，例如，172.16.254.1；
    * 此外，前导零在IPv4地址中是非法的。例如，地址172.16.254.01就是非法的。
    * IPv6地址被表示为十六进制数位，每4个十六进制数位归为一组，共八组，每组可表示16个二进制位。
    * 每组之间使用冒号(":")来进行分隔。例如，地址2001:0db8:85a3:0000:0000:8a2e:0370:7334是合法的。
    * 同时，去掉每组十六进制数位中的一些前导零，或是将表示十六进制数位的小写字母写作大写字母，也都是合法的，
    * 所以2001:db8:85a3:0:0:8A2E:0370:7334同样是一个合法的IPv6地址（它忽略了前导零同时使用了大写字母）。
    * 然而，我们不能为了追求简洁就使用两个冒号("::")将连续的值为0的组替换为一个空组。例如，2001:0db8:85a3::8A2E:0370:7334就是一个非法的IPv6地址。
    * 此外，额外的前导零在IPv6中也是非法的。例如，地址02001:0db8:85a3:0000:0000:8a2e:0370:7334就是非法的。
    * */

    public String validIPAddress(String IP) {
        if(isIPv4(IP))
            return "IPv4";
        if(isIPv6(IP))
            return "IPv6";
        return "Neither";
        // Write your code here
    }

    private boolean isIPv4(String cur){
        int pointNumber=0;
        for(int i=0;i<cur.length();i++){
            char c=cur.charAt(i);
            if(c=='.')
                pointNumber++;
            else if(c>'9'||c<'0')
                return false;
        }
        if(pointNumber!=3)
            return false;
        String[] c=cur.split("\\.");
        System.out.println(Arrays.toString(c));
        for(int i=0;i<4;i++){
            int curLength=c[i].length();
            if(curLength!=0&&c[i].charAt(0)=='0')
                return false;
            int curNumber=Integer.parseInt(c[i]);
            if(curNumber>255)
                return false;
        }
        return true;
    }

    private boolean isIPv6(String cur){
        int pointNumber=0;
        for(int i=0;i<cur.length();i++){
            char c=cur.charAt(i);
            if(c==':')
                pointNumber++;
            else if(!isTrueChar(c))
                return false;
        }
        if(pointNumber!=7)
            return false;
        String[] c=cur.split(":");
        for(String s:c) {
            if (s.length() > 4) {
                return false;
            }
        }
        return true;
    }

    private boolean isTrueChar(char cur){
        if(cur<='9'&&cur>='0'||cur>='a'&&cur<='f'||cur<='F'&&cur>='A')
            return true;
        return false;

    }

    public static void main(String[] args){
        String a="1:2::4";
        String[] aa=a.split(":");
        System.out.println(aa[2].length());
    }
}
