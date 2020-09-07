package LINTCODE4;

public class LINTCODE315 {
    /*Description
    * 给定一个字符串str和一个数组sublen[]，sublen[0] + sublen[1] + ... + sublen[sublen.size() – 1] == str.length()，
    * 按照sublen[]将字符串切分开来，sublen[i]表示第i个子串的长度。将第2k-1个子串与第2k个子串调换，
    * 若sublen长度为奇数，则最后一个不变。返回新生成的字符串。
    * */

    public String reformatString(String str, int[] sublen) {
        StringBuilder sb=new StringBuilder();
        int length=sublen.length;
        int start=0;
        for(int i=0;i<length/2;i++){
            sb.append(str.substring(start+sublen[i*2],start+sublen[i*2]+sublen[i*2+1]));
            sb.append(str.substring(start,start+sublen[i*2]));
            start+=sublen[i*2]+sublen[i*2+1];
        }
        if(length%2==1)
            sb.append(str.substring(start,start+sublen[length-1]));
        return sb.toString();
        // write your code here
    }
}
