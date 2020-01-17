package LINTCODE13;

public class LINTCODE1250 {
    /*Description
    * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。
    * 要求算法时间复杂度必须是O(n)。
    * */

    public int thirdMax(int[] nums){
        int first=Integer.MIN_VALUE;
        for(int num:nums){
            first=Math.max(num,first);
        }
        int second=Integer.MIN_VALUE;
        for(int num:nums){
            if(first!=num)
                second=Math.max(second,num);

        }
        int third=Integer.MIN_VALUE;
        boolean flag=false;
        for(int num:nums){
            if(first!=num&&second!=num) {
                third = Math.max(third, num);
                flag=true;
            }
        }
        return flag?third:first;
        // Write your code here.
    }
}
