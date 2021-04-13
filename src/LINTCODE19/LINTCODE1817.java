package LINTCODE19;

public class LINTCODE1817 {
    /*Description
    * 你有一大块巧克力，它由一些甜度不完全相同的小块组成。我们用数组 sweetness 来表示每一小块的甜度。
    * 你打算和 K 名朋友一起分享这块巧克力，所以你需要将大巧克力切割 K 次才能得到 K+1 块，每一块都由一些 连续 的小块组成。
    * 为了表现出你的慷慨，你将会吃掉 总甜度最小 的一块，并将其余几块分给你的朋友们。
    * 请找出一个最佳的切割策略，使得你所分得的巧克力 总甜度最大，并返回这个 最大总甜度。
    * */

    public int maximizeSweetness(int[] sweetness, int K) {
        K++;
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int cur:sweetness){
            min=Math.min(min,cur);
            sum+=cur;
        }

        int left=min,right=sum;
        while(left<=right){
            int mid=left+(right-left)/2;
            int curK=getK(sweetness,mid);
            if(curK>=K&&getK(sweetness,mid+1)<K)
                return mid;
            else if(curK>=K)
                left=mid+1;
            else
                right=mid-1;
        }
        return -1;
        // write your code here
    }

    private int getK(int[] sweetness,int minValPerPart){
        int countK=0;
        int curSum=0;
        for(int i=0;i<sweetness.length;i++){
            curSum+=sweetness[i];
            //System.out.println(curSum+" "+countK);
            if(curSum>=minValPerPart) {
                countK++;
                curSum=0;
            }
        }
        return countK;
    }
}
