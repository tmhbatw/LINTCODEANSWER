package LINTCODE13;

import java.util.Arrays;
import java.util.Comparator;

public class LINTCODE1220 {
    /*Description
    * 还记得卖火柴的小女孩的故事吗？现在，你知道了小女孩拥有的火柴数目和它们的长度，请找出一种能使用全部火柴摆成一个正方形的方法。
    * 你不能掰断任何一根火柴，但可以将它们连接起来，每根火柴必须使用正好一次。
    * 你的输入是一个由火柴长度组成的数组，表示小女孩现在拥有的火柴。你应该输出true或false，代表你能否找到一种方法使用全部火柴摆成一个正方形。
    * */

    boolean result=false;
    public boolean makesquare(int[] nums) {
        int length=nums.length;
        if(length<=3)
            return false;
        int sum=0;
        for(int cur:nums)
            sum+=cur;
        if(sum%4!=0)
            return false;
        sum/=4;
        Arrays.sort(nums);
        if(nums[length-1]>sum)
            return false;
        boolean[] reached=new boolean[length];
        recursion(nums,reached,sum,0,0,0);
        return result;
        // Write your code here
    }

    private void recursion(int[] nums,boolean[] reached,int target,int curSum,int start,int count){
        if(result)
            return;
        if(curSum==target){
            count++;
            if(count==3) {
                result = true;
                return;
            }
            recursion(nums,reached,target,0,0,count);
        }
        for(int i=start;i<nums.length;i++){
            if(curSum+nums[start]>target)
                break;
            if(reached[i])
                continue;
            boolean[] curReached=reached.clone();
            curReached[i]=true;
            recursion(nums,curReached,target,curSum+nums[i],i+1,count);
        }
    }

    public static void main(String[] args){
        boolean[] a=new boolean[]{true,true};
        boolean[] b=a.clone();
        b[1]=false;
        System.out.println(Arrays.toString(a)+" "+Arrays.toString(b));
    }

}
