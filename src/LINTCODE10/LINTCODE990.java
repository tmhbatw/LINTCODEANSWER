package LINTCODE10;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE990 {
    /*Description
    * 假设你有 N 个从 1 到 N 的整数。我们将一个美丽的排列定义为：如果一个数组由这给出的 N 个整数构成，
    * 且满足下列任意一个条件对此数组中的第i个位置（1 <= i <= N）的要求，则这个数组为美丽的排列：
    * 第 i 个 位置的元素可以被 i 整除。
    * i 可以被第 i 个元素整除。
    * 现在给出 N，你可以构造出多少美丽的排列？
    * */

    List<List<Integer>> list;
    int result=0;
    public int countArrangement(int N) {
        list=new ArrayList<>();
        for(int i=1;i<=N;i++){
            List<Integer> cur=new ArrayList<>();
            for(int j=1;j<=N;j++){
                if(i%j==0||j%i==0)
                    cur.add(j);
            }
            list.add(cur);
        }
        recursion(new boolean[N+1],0,N);
        return result;
        // Write your code here
    }

    private void recursion(boolean[] reached,int index,int N){
        if(index==N) {
            result++;
            return;
        }
        List<Integer> cur=list.get(index);
        for(int curr:cur){
            if(!reached[curr]){
                boolean[] curReached=reached.clone();
                curReached[curr]=true;
                recursion(curReached,index+1,N);
            }
        }
    }

    public static void main(String[] args){
        System.out.println();
    }
}
