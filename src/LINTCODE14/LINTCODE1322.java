package LINTCODE14;

import java.util.*;

public class LINTCODE1322 {
    /*Description
    * 给定一个长度为n的正整数序列。A的长度是n。
    * 你每次可以花费1的代价，将序列中某一个数加一或者减一。
    * 你希望用最小的代价使得序列所有数的乘积为
    * 每次操作结束后 每个数都要是正整数
    * */

    public int getMinCost(int B, int[] A) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        Map<Integer,List<Integer>> m=new HashMap<>();
        putMap(B,map,list);
        for(int i=0;i<list.size();i++){
            List<Integer> l=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(list.get(i)%list.get(j)==0){
                    l.add(j);
                }
            }
            m.put(i,l);
        }

        int length=A.length;
        int[][] dp=new int[length][list.size()];
        for(int j=0;j<list.size();j++){
            dp[0][j]=Math.abs(A[0]-list.get(j));
        }
        for(int i=1;i<length;i++){
            for(int j=0;j<list.size();j++){
                List<Integer> l=m.get(j);
                int cur=Integer.MAX_VALUE;
                for(int k:l){
                    cur=Math.min(cur,Math.abs(A[i]-list.get(k))+dp[i-1][map.get(list.get(j)/(list.get(k)))]);
                }
                dp[i][j]=cur;
            }
        }

        return dp[length-1][list.size()-1];
        // write your code here
    }

    //将B放到hashmap里
    private void putMap(int B, Map<Integer,Integer> map, List<Integer> list){
        int index=0;
        for(int i=1;i<=B;i++){
            if(B%i==0) {
                list.add(i);
                map.put(i,index++);
            }
        }
    }

    public static void main(String[] args){
        int B=12;
        int[] num=new int[]{1,3,5};
        System.out.println(new LINTCODE1322().getMinCost(B,num));
    }
}
