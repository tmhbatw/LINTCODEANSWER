package LINTCODE14;

public class LINTCODE1398 {
    /*Description
    *给出一个k，a，b，代表a和b都是一个k进制的数，输出a + b的k进制数。
    * */

    public String addition(int k, String a, String b) {
        int aLength=a.length()-1;
        int bLength=b.length()-1;
        int count=0;
        String result="";
        while(aLength>=0||bLength>=0){
            int aa=aLength>=0?a.charAt(aLength)-'0':0;
            int bb=bLength>=0?b.charAt(bLength)-'0':0;
            int cur=aa+bb+count;
            if(cur>=k){
                count=1;
                cur-=k;
            }else{
                count=0;
            }
            System.out.println(cur);
            result=cur+""+result;
            aLength--;
            bLength--;
        }
        if(count==1)
            result=1+""+result;
        while(result.charAt(0)=='0')
            result=result.substring(1);
        return result;
        // Write your code here
    }
}
