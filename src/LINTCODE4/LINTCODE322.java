package LINTCODE4;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE322 {
    /*Description
    * 给定一个长度为N的二元组数组queen，代表N个皇后棋子的坐标
    * 给定一个长度为M的二元组数组knight，代表M个骑士棋子的坐标
    * 每个皇后可以袭击同行，同列，或者同对角线的任意一个骑士棋子
    * 请你返回一个长度为M的答案数组，依次代表每个骑士棋子是否会被攻击到
    * */

    public boolean[] isAttacked(int[][] queen, int[][] knight) {
        int knightNumber=knight.length;
        boolean[] result=new boolean[knightNumber];
        Set<Integer> row=new HashSet<>();
        Set<Integer> col=new HashSet<>();
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int[] cur:queen){
            row.add(cur[0]);
            col.add(cur[1]);
            set1.add(cur[0]+cur[1]);
            set2.add(cur[0]-cur[1]);
        }
        for(int i=0;i<knightNumber;i++){
            int[] cur=knight[i];
            if(row.contains(cur[0])||col.contains(cur[1])||set1.contains(cur[0]+cur[1])||set2.contains(cur[0]-cur[1]))
                result[i]=true;
        }
        return result;
        // write your code here
    }

}
