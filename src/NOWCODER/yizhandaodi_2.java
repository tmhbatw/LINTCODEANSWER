package NOWCODER;

import java.util.Scanner;

public class yizhandaodi_2 {
    /*Description
    * 第一行是一个正整数T ( 1 ≤ T ≤ 5 )，表示测试数据的组数，每组测试数据，第一行是一个正整数n ( 1 ≤ n ≤ 100000 )，
    * 表示该组测试数据包含的判定数。接下来的n行，每行包含"PERFECT"、"GOOD"、"BAD"、"MISS"之中的一个字符串，表示quailty打出的一个判定。
    * 全部为PERFECT则为MILLION Master
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        String[] res=new String[n];
        for(int i=0;i<n;i++){
            int m=s.nextInt();
            for(int j=0;j<m;j++){
                String cur=s.next();
                if(!cur.equals("PERFECT"))
                    res[i]="NAIVE Noob";
            }
            if(res[i]==null)
                res[i]="MILLION Master";
        }
        for(String cur:res){
            System.out.println(cur);
        }
    }

}
