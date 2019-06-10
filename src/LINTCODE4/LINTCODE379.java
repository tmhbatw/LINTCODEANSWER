package LINTCODE4;

public class LINTCODE379 {
    /*Description
    * Construct minimum number by reordering a given non-negative integer array. Arrange them such that they form the minimum number.
    * Challenge
    * Do it in O(n*log n) time complexity.
    * */

    /*Solution
    * 遍历比较两个数的相对大小，将相对较小的数字排在前面即可
    * 如果需要O（n*log n )的时间复杂度，则需要进行快速排序
    * */

    public String minNumber(int[] nums) {
        if(nums.length==0)
            return null;
        recursion(nums,0,nums.length-1);
        String result="";
        for(int i:nums)
            result+=i;
        while(result.length()>1&&result.charAt(0)=='0')
            result=result.substring(1,result.length());
        return result;
        // write your code here
    }

    private void recursion(int[] nums,int start,int end){
        if(end<=start)
            return;
        if(end-start==1){
            if(bigger(nums[start],nums[end]))
                swap(nums,start,end);
            return;
        }
        int i=start+1,j=end;
        while(i<j){
            if(!bigger(nums[start],nums[j])) {
                j--;
                continue;
            }
            if(bigger(nums[start],nums[j])){
                i++;
                continue;
            }
            swap(nums,i,j);
            j--;
        }
        if(bigger(nums[start],nums[i]))
            swap(nums,start,i);
        recursion(nums,start,i-1);
        recursion(nums,i+1,end);

    }

    private static boolean bigger(int num1,int num2){
        Long n1=Long.valueOf(num1);
        Long n2=Long.valueOf(num2);
        int nu1=String.valueOf(num2).length();
        int nu2=String.valueOf(num1).length();
        while(nu1-->0)
            n1*=10;
        while(nu2-->0)
            n2*=10;
        return n1+num2>n2+num1;
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args){
        System.out.println(bigger(73,79));
    }


}
