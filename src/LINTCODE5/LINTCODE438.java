package LINTCODE5;

public class LINTCODE438 {
    /*Description
    * 给定 n 本书, 每本书具有相同的页数. 现在有 k 个人来复印这些书. 其中第 i 个人需要 times[i] 分钟来复印一本书.
    * 每个人可以复印任意数量的书. 怎样分配这 k 个人的任务, 使得这 n 本书能够被尽快复印完?
    * 返回完成复印任务最少需要的分钟数.
    * */

    public int copyBooksII(int n, int[] times) {
        int l=0,r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l)/2;
            if(isMatch(n,mid,times)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return r;
        // write your code here
    }

    private boolean isMatch(int n,int min,int[] times){
        long count=0;
        for(int cur:times){
            count+=min/cur;
        }
        return count>=n;
    }
}
