package LINTCODE15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE1498 {
    /*Description
    * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
    * 返回 A 的任意排列，使其相对于 B 的优势最大化。
    * */

    //treemap
    public int[] advantageCount(int[] A, int[] B) {
        List<Integer> list=new ArrayList<>();
        for(int cur:A)
            list.add(cur);
        Collections.sort(list);
        int number=A.length;
        for(int i=0;i<number;i++){
            int val=B[i];
            if(val>=list.get(number-i-1))
                A[i]=list.remove(0);
            else{
                int left=0,right=number-i-1;
                while(left<=right){
                    int mid=left+(right-left)/2;
                    if(list.get(mid)>val&&(mid==0||list.get(mid-1)<=val)){
                        A[i]=list.remove(mid);
                        break;
                    }
                    if(list.get(mid)>val)
                        right=mid-1;
                    else
                        left=mid+1;
                }
            }
        }
        return A;
        // write your code here.
    }
}
