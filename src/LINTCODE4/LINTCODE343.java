package LINTCODE4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE343 {
    /*Description
    * 有一个圆环上面有6个点，每一个点都有一个数字，对于两个圆环来说，若6个数字完全一致（顺序可以随
    * 机，只要数相同即可），则说明这两个圆环是一样的，现在有n个圆环，想问你这里面有没有一样的两
    * 个圆环，若有返回true，反之返回false。
    * */


    public boolean samecircle(int[][] circles) {
        Set<Integer> set=new HashSet<>();
        for(int[] cur:circles){
            Arrays.sort(cur);
            int curr=0;
            for(int i=0;i<6;i++){
                curr=curr*10+cur[i];
            }
            if(set.contains(curr))
                return true;
            set.add(curr);
        }
        return false;
        // write your code here
    }
}
