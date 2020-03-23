package LINTCODE19;

public class LINTCODE1870 {
    /*Description
    * 给出一个只包含0或1的字符串str,请返回这个字符串中全为0的子字符串的个数
    * */

    public int stringCount(String str) {
        int result=0;
        int length=str.length();
        for(int i=0;i<str.length();i++){
            char cur=str.charAt(i);
            if(cur=='0'){
                int time=1;
                while(i+1<length){
                    i++;
                    cur=str.charAt(i);
                    if(cur=='0'){
                        time++;
                    }else
                        break;
                }
                result+=getResult(time);
            }
        }
        return result;
        // Write your code here.
    }

    private int getResult(int cur){
        return cur*(cur+1)/2;
    }
}
