package LINTCODE7;

public class LINTCODE617 {
    /*Description
    * 给出一个整数数组，有正有负。找到这样一个子数组，他的长度大于等于 k，且平均值最大。
    * */

    public double maxAverage(int[] nums, int k) {
        double min=Double.MAX_VALUE;
        double max=Double.MIN_VALUE;
        for(int cur:nums){
            min=Math.min(cur,min);
            max=Math.max(cur,max);
        }
        while(max-min>0.00001f){
            double mid=min+(max-min)/2;
            if(isBig(nums,mid,k))
                min=mid;
            else
                max=mid;
        }
        return min;
        // write your code here
    }

    private boolean isBig(int[] nums,double avg,int k){
        double[] num=new double[nums.length];
        for(int i=0;i<nums.length;i++)
            num[i]=nums[i]-avg;
        double minPre= 0f;
        double sum=0;
        for(int i=0;i<k-1;i++){
            sum+=num[i];
        }
        double curPre=0f;
        for(int i=k-1;i<num.length;i++){
            sum+=num[i];
            if(sum-minPre>=0)
                return true;
            curPre+=num[i-k+1];
            minPre=Math.min(curPre,minPre);
        }
        return false;
    }
}
