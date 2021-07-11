package LINTCODE11;

public class LINTCODE1097 {
    /*Description
    *几乎每一个人都用过乘法表。但是你能够在乘法表中快速找到第k小的数吗？
    * 给定高度m和宽度n的m * n乘法表，和一个正整数k，你需要返回表中第k小的数。
    * */


    public int findKthNumber(int m, int n, int k) {
        int l =1,r=m*n;
        while(l<r){
            int mid=l+(r-l+1)/2;
            if(isMatch(m,n,k,mid))
                l=mid;
            else
                r=mid-1;
        }
        return l;
        // write your code here
    }
    private boolean isMatch(int m,int n ,int k, int mid){
        int count =0;
        for(int i=1;i<=m;i++){
            if(i>=mid)
                continue;
            int l =1,r=n;

            while(l<r){
                int medium=l+(r-l+1)/2;

                if(i*medium<mid)
                    l=medium;
                else
                    r=medium-1;
            }
            count+=l;
        }
        return count<k;
    }
}
