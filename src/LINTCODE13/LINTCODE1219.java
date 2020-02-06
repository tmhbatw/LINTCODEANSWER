package LINTCODE13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE1219 {
    /*Description
    * 冬天来啦！你的任务是设计出一个具有固定加热半径的加热器，使得所有房屋在这个冬天不至于太冷。
    * 现在你能够获知所有房屋和加热器所处的位置，它们均分布在一条水平线中。你需要找出最小的加热半径使得所有房屋都处在至少一个加热器的加热范围内。
    * 所以，你的输入将会是所有房屋和加热器所处的位置，期望输出为加热器最小的加热半径。
    * */


    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result=Integer.MIN_VALUE;
        for(int cur:houses){
            int left=0;
            int right=heaters.length-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if(mid==left)
                    break;
                if(cur>=heaters[mid])
                    left=mid;
                else
                    right=mid;
            }
            int res=left==heaters.length-1?Math.abs(heaters[left]-cur):Math.min(Math.abs(heaters[left]-cur),Math.abs(heaters[left+1]-cur));
            result=Math.max(result,res);
        }
        return result;
        // Write your code here
    }

}
