package LINTCODE3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LINTCODE296 {
    /*Description
    * 给定一个长度为NN的整数数组arrarr，返回去掉重复元素之后的数组
    * （去掉重复元素前后数组元素相对次序不变）
    * */

    public int[] getUniqueArray(int[] arr) {
        HashSet<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for(int cur:arr){
            if(!set.contains(cur)){
                list.add(cur);
                set.add(cur);
            }
        }
        int[] result=new int[list.size()];
        for(int i=0;i<result.length;i++)
            result[i]=list.get(i);
        return result;
        // write your code here
    }
}
