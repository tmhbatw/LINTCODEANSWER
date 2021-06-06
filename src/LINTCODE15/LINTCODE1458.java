package LINTCODE15;

public class LINTCODE1458 {

    public long minimumSubmatrix(int[][] arr) {
        long result=arr[0][0];
        int m=arr.length,n=arr[0].length;
        for(int i=0;i<m;i++){
            long[] curDp=new long[n];
            for(int j=i;j<m;j++){
                long preMin=0;
                long[] currDp=new long[n];
                for(int k=0;k<n;k++) {
                    curDp[k] += arr[j][k];
                    currDp[k]+=curDp[k];
                    if(k>0)
                        currDp[k]+=currDp[k-1];
                    result=Math.min(result,currDp[k]-preMin);
                    preMin=Math.max(preMin,currDp[k]);
                }
            }
        }
        return result;
        // Write your code here
    }
}
