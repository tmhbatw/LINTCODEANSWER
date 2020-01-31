package LINTCODE12;

public class LINTCODE1112 {
    /*Solution
    * 集合S中原本包含数字1到n。但不幸的是，由于数据错误集合中的一个数变成了集合中的另一个数，
    * 这导致集合中有两个重复的数，并且集合中缺失了1到n的某个数。
    * 给定数组nums，表示发生错误后的数组，以数组的形式返回重复的数值和缺失的数值。
    * */

        public int[] findErrorNums(int[] nums) {
            boolean[] reached=new boolean[nums.length];
            int[] result=new int[2];
            for(int num:nums){
                if(reached[num-1])
                    result[0]=num;
                reached[num-1]=true;
            }
            for(int i=0;i<reached.length;i++){
                if(!reached[i])
                    result[1]=i+1;
            }
            return result;
            // Write your code here
        }
}
