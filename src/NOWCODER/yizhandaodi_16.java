package NOWCODER;

import java.util.Arrays;
import java.util.Scanner;

public class yizhandaodi_16 {
    /*Description
    * 题目描述
    * 小Z向女神告白成功，成功脱单，为了庆祝，小Z决定送女神一个礼物。   在珠宝店，小Z终于发现一种既便宜又大气的手链。
    * 手链的价格是看手链上的宝石决定的，每一种宝石的价值不一样。    具体规则如下：    宝石A的价值是1、宝石B的价值是2、宝石C的价值是3·····宝石Z的价值是26。
    *为了防止被销售员虚报价格，小Z决定请你帮忙计算一下手链的价值。
    * 输入描述:
    * 本题有T组数据。对于每组数据只有一行。1≤T≤20
    * 1≤手链长度≤100000
    * 输出描述:
    * 输出结果，并换行。
    * */
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        int[] res=new int[T];
        for(int i=0;i<T;i++){
            String cur=s.next();
            int count=0;
            for(int j=0;j<cur.length();j++){
                count+=cur.charAt(j)-'A'+1;
            }
            res[i]=count;
        }
        for(int num:res)
            System.out.println(num);
    }
}
