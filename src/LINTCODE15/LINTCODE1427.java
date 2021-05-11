package LINTCODE15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE1427 {
    /*Description
    *给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
    * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
    * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
    * F.length >= 3；
    * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
    * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
    * 返回从 S 拆分出来的所有斐波那契式的序列块，如果不能拆分则返回 []。
    * */

    public List<Integer> splitIntoFibonacci(String S) {
        int length=S.length();
        for(int i=0;i<length/2;i++){
            long first=Long.parseLong(S.substring(0,i+1));
            if(first>Integer.MAX_VALUE)
                return Collections.emptyList();
            for(int j=i+1;j<(i+1+length)/2;j++){
                long second=Long.parseLong(S.substring(i+1,j+1));
                if(second>Integer.MAX_VALUE)
                    break;
                List<Integer> list=new ArrayList<>();
                list.add((int) first);
                list.add((int)second);
                int index=j+1;
                long f=first,s=second;
                while(index!=length){
                    long temp=f+s;
                    f=s;
                    s=temp;
                    if(temp>Integer.MAX_VALUE)
                        break;
                    int sLength=(temp+"").length();
                    if(sLength>length-index||!S.substring(index,index+sLength).equals((temp+"")))
                        break;
                    list.add((int)temp);
                    index+=sLength;
                }
                if(index==length&&list.size()>2)
                    return list;
                if(second==0)
                    break;
            }
            if(first==0)
                return Collections.emptyList();
        }
        return Collections.emptyList();
        // write your code here
    }

    public static void main(String[] args){
        System.out.println((Integer.MAX_VALUE+"").length());
    }
}
