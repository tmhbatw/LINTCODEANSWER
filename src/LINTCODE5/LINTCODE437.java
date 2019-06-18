package LINTCODE5;

import java.util.Arrays;

public class LINTCODE437 {


    /*Description
    *给定 n 本书, 第 i 本书的页数为 pages[i]. 现在有 k 个人来复印这些书籍, 而每个人只能复印编号连续的一段的书,
    * 比如一个人可以复印 pages[0], pages[1], pages[2], 但是不可以只复印 pages[0], pages[2], pages[3] 而不复印 pages[1].
    * 所有人复印的速度是一样的, 复印一页需要花费一分钟, 并且所有人同时开始复印. 怎样分配这 k 个人的任务, 使得这 n 本书能够被尽快复印完?
    * 返回完成复印任务最少需要的分钟数.
    * */

    /*Solution
    *动态规划试一下，创建一个dp[][]数组，其中dp[i][j]表示i本书分配给j个人的最小时间
    * 需要O（n*n*k)的时间复杂度
    * 还可以使用二分法，想找到最小时间，然后判断这个最小时间是否可行
    * */

    public int copyBooks(int[] pages, int k) {
        if(pages.length==0)
            return 0;
        int max=Integer.MIN_VALUE;
        int res=0;
        for(int num:pages){
            max=Math.max(num,max);
            res+=num;
        }
        while(max<res){
            int mid=max+(res-max)/2;
            if(judge(pages,mid,k)){
                res=mid;
            }else{
                max=mid+1;
            }
        }
        return max;
        // write your code here
    }

    private boolean judge(int[] pages,int limit,int k){
        int count=0;
        int res=0;
        for(int num:pages){
            if(res+num>limit){
                res=0;
                count++;
            }
            res+=num;
        }
        if(res!=0)
            count++;
        System.out.println(limit+" "+count);
        return count<=k;
    }

/*    public int copyBooks(int[] pages, int k) {
        if(pages.length==0)
            return 0;
        int[][] dp=new int[pages.length+1][k+1];
        for(int i=0;i<pages.length;i++){
            dp[i+1][1]=dp[i][1]+pages[i];
        }
        for(int i=0;i<pages.length;i++){
            for(int j=1;j<k;j++){
                dp[i+1][j+1]=Integer.MAX_VALUE;
                int count=0;
                for(int m=i;m>=0;m--){
                    count+=pages[m];
                    dp[i+1][j+1]=Math.min(dp[i+1][j+1],Math.max(dp[i-(i-m)][j],count));
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[pages.length][k];
        // write your code here
    }*/

}
