package LINTCODE8;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE793 {
    /*Description
    * 给出多个数组，求它们的交集。输出他们交集的大小。
    * */

    /*Solution
    * 用一个HashMap保存所有出现过的数以及其出现的次数，判断是否等于数组的个数
    * 若等于则证明是一个所有数组
    * */

    public int intersectionOfArrays(int[][] arrs) {
        int length=arrs.length;
        if(length==0)
            return 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arrs[0].length;i++){
            map.put(arrs[0][i],1);
        }
        for(int i=1;i<arrs.length;i++){
            for(int j=0;j<arrs[i].length;j++){
                if(map.containsKey(arrs[i][j])){
                    map.put(arrs[i][j],map.get(arrs[i][j])+1);
                }
            }
        }
        int result=0;
        for(Map.Entry entry:map.entrySet()){
            if(entry.getValue()==(Integer)length)
                result++;
        }
        return result;
        // write your code here
    }
}
