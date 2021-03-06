package LINTCODE14;

public class LINTCODE1304 {
    /*Description
    * 给定一个研究员的引用量数组（每个引用量都是一个非负整数）。请计算该研究员的H指数。
    * 一个研究者的H指数为h，意味着他的论文中，有h篇有至少有h个引用量。
    * */

    public int hIndex(int[] citations) {
        int max=0;
        for(int cur:citations)
            max=Math.max(cur,max);
        int[] dp=new int[max+1];
        for(int cur:citations)
            dp[cur]++;
        for(int i=max-1;i>=0;i--)
            dp[i]+=dp[i+1];
        int left=0,right=max;
        while(left<=right){
            int mid=(right-left)/2+left;
            int cur=dp[mid];
            if(cur<mid){
                right=mid-1;
            }else if(mid==max||dp[mid+1]<mid+1)
                return mid;
            else
                left=mid+1;
        }
        return left;
        // write your code here
    }
}
