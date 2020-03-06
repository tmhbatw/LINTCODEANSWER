package LINTCODE14;

public class LINTCODE1340 {
    /*Description
    * 我们认为一个字符串是合法的如果这个字符串中没有包含‘aaa'的子串。
    * 现在，给定一个字符串，你可以在字符串的任意位置（包括头部和尾部）添加字符‘a’，在这个过程中，你需要保证字符串是合法的。返回你最多能添加’a'的个数。
    * */

    public int addCharacter(String str) {
        int result=0;
        int length=str.length();
        for(int i=0;i<length;i++){
            if(str.charAt(i)=='a'||i>=2&&str.charAt(i-1)=='a'&&str.charAt(i-2)=='a')
                continue;
            if(i>=1&&str.charAt(i-1)=='a')
                result+=1;
            else{result+=2;}
        }
        if(str.charAt(length-1)!='a')
            return result+2;
        if(str.length()>=2&&str.charAt(length-1)=='a'&&str.charAt(length-2)=='a')
            return result;
        return result+1;
        // Write your code here.
    }
}
