package LINTCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE50 {
    /*Description
    * Given an integers array A.
    * Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.Out put B
    * */

    /*Solution
    * 创建两个数组分别保存从左到右以及从右到左从第1个数到第i个数的乘积
    * 从两个数组取数字相乘即可得到需要的值
    * */
    public List<Long> productExcludeItself(List<Integer> nums) {
        List<Long> result=new ArrayList<>();
        if(nums.size()==1){
            result.add(1l);
            return result;
        }

        Long[] a=new Long[nums.size()];
        Long[] b=new Long[nums.size()];
        int temp=0;
        a[temp]=1l;
        while(temp<nums.size()-1)
            a[temp+1]=nums.get(temp)*a[temp++];
        System.out.println(Arrays.toString(a));
        b[temp]=1l;
        while(temp>0)
            b[temp-1]=nums.get(temp)*b[temp--];
        System.out.println(Arrays.toString(b));
        for(int i=0;i<nums.size();i++){
            result.add((long) (a[i]*b[i]));
        }
        return result;
        // write your code here
    }
}
