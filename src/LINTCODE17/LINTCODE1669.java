package LINTCODE17;

import java.util.List;

public class LINTCODE1669 {
    /*Description
    *你是一名建造寺庙的建筑师。
    * 寺庙的柱子是由木头制成。每根柱子必须是一jie完整的木头而且不能是被连接得到的。
    * 给出n段具有不同长度的木头。你的寺庙有m根高度严格相同的柱子。那么你寺庙最大高度是多少。(m根柱子的高度)
    * */

    public int buildTemple(int m, List<Integer> woods) {
        int left=1,right=Integer.MAX_VALUE;
        while(left<=right){
            int mid=left+(right-left)/2;
            int number=getNumber(woods,mid);
            if(number>=m&&getNumber(woods,mid+1)<m)
                return mid;
            if(number>=m)
                left=mid+1;
            else
                right=mid-1;
        }
        return left;
        // write your code here.
    }

    private int getNumber(List<Integer> woods,int curHeight){
        int res=0;
        for(int num:woods)
            res+=num/curHeight;
        return res;
    }
}
