package LINTCODE1;

public class LINTCODE27 {
    /*Description
    *有一个字符串集合，所有字符串的长为 n， 只由 'a', 'b', 'c' 三种字符组成，
    * 而且每个字符串中，所有相邻字符都是不同的。
    * 请编写一个程序，返回这个字符串集合中，字典序第 k 小的字符串。
    * */

    public String kthString(int n, long k) {
        if(n<62&&3*Math.pow(2,n-1)<k){
            return "";
        }
        k--;
        StringBuilder sb=new StringBuilder();
        char pre='b';
        for(int i=0;i<n-62;i++){
            pre=pre=='a'?'b':'a';
            sb.append(pre);
        }
        if(n<=62){
            long curCount= (long) Math.pow(2,n-1);
            pre = 'a';
            while(k>=curCount){
                k-=curCount;
                pre = (char) (pre+1);
            }
            sb.append(pre);
        }
        for(int i=Math.min(62,n-1);i>=1;i--){
            long curCount = (long) Math.pow(2,i-1);
            char cur='a';
            if(cur==pre){
                cur= (char) (cur+1);
            }
            if(k>=curCount){
                k-=curCount;
                cur = (char)(cur+1);
            }
            if(cur==pre){
                cur = (char)(cur+1);
            }
            sb.append(cur);
            pre = cur;
        }
        return sb.toString();
        // write your code here.
    }

    public static void main(String[] args){
        long i=2;
        for(int j=0;j<61;j++){
            i*=2;
        }
        long ii = (long) Math.pow(2,62);
        System.out.println(ii);
    }


}
