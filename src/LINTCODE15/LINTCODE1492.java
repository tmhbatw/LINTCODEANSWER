package LINTCODE15;

public class LINTCODE1492 {
    /*Description
    * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
    * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
    * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
    * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
    * */

    public int minEatingSpeed(int[] piles, int H) {
        int left=1;
        int right=Integer.MAX_VALUE;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(calculate(piles,mid-1)>H&&calculate(piles,mid)<=H)
                return mid;
            if(calculate(piles,mid)>H)
                left=mid+1;
            else
                right=mid-1;
        }
        return left;
        // Write your code here
    }

    private int calculate(int[] piles,int num){

        int res=0;
        for(int cur:piles){
            res+=Math.ceil(1.0*cur/num);
        }
        return res;
    }
}
