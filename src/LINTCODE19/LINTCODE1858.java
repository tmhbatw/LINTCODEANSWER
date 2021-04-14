package LINTCODE19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE1858 {
    /*Description
    * 我们有很多箱子要运。为了节省空间，我们把箱子放在一起。给你每个盒子的长度和宽度，箱子套箱子最多套几层？
    * */

    public int maxBoxes(int[][] boxes) {
        for(int[] cur:boxes){
            if(cur[0]>cur[1]) {
                int temp = cur[0];
                cur[0] = cur[1];
                cur[1] = temp;
            }
        }
        Arrays.sort(boxes,(o1,o2)->{
            if(o1[0]==o2[0])
                return o2[1]-o1[1];
            return o1[0]-o2[0];
        });
        List<Integer> result=new ArrayList<>();
        for(int[] cur:boxes){
            if(result.isEmpty()||result.get(result.size()-1)<cur[1]) {
                result.add(cur[1]);
                continue;
            }
            int left=0,right=result.size()-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(result.get(mid)>=cur[1]&&(mid==0||result.get(mid-1)<cur[1])){
                    result.set(mid,cur[1]);
                    break;
                }
                if(result.get(mid)>=cur[1]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return result.size();
        // Write your code here.
    }
}
