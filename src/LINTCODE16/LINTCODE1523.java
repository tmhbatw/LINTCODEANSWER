package LINTCODE16;

import java.util.HashMap;

public class LINTCODE1523 {
    /*Description
    * 给定一个数字数组，您需要检查是否可以将该数组划分为每个长度为k的子序列，例如：
    * 数组中的每个元素仅在一个子序列中出现
    * 子序列中的所有数字都是不同的
    * 数组中具有相同值的元素必须位于不同的子序列中
    * 是否可以对满足以上条件的数组进行分区？ 如果可能，返回true，否则返回false
    * */

    public boolean PartitioningArray(int[] A, int k) {
        if(A.length%k!=0)
            return false;
        int time=A.length/k;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:A){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(HashMap.Entry entry:map.entrySet()){
            if((int)entry.getValue()>time)
                return false;
        }
        return true;
        // write your code here
    }
}
