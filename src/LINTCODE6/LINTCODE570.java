package LINTCODE6;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE570 {
    /*Description
    *给一个由 1 - n 的整数随机组成的一个字符串序列，其中丢失了一个整数，请找到它。
    * */

    static Set<Integer> ress=new HashSet<>();

    public static  int findMissing2(int n, String str) {
        recursion(new HashSet<>(),str,n);
        System.out.println(ress);
        return getLack(ress,n);
        // write your code here
    }
    private static void recursion(Set<Integer> res,String str,int n){
        if(ress.size()!=0)
            return;
        if(str.length()==0) {
            ress.addAll(res);
            return;
        }
        for(int i=0;i<str.length()&&i<2;i++){
            int cur=Integer.parseInt(str.substring(0,i+1));
            if(cur==0)
                return;
            if(!res.contains(cur)&&cur<=n&&cur>0){
                Set<Integer> curr = new HashSet<>(res);
                curr.add(cur);
                System.out.println(cur+" "+str+" "+curr);
                recursion(curr,str.substring(i+1,str.length()),n);
            }
        }
    }
    private static int getLack(Set<Integer> set,int n){
        for(int i=1;i<=n;i++){
            if(!set.contains(i))
                return i;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(findMissing2(28,"111097654281222131272625242321320191817161514"));

    }
}
