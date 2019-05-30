package LINTCODE1;

import java.util.List;

public class LINTCODE47 {
    /*Description
    * Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.
    * Find it.
    * */

    /*Solution
    * 摩尔投票法的改良版，
    * 假设两个数字进行投票
    * 由题意可知最后只能剩下一个结果
    * */
    public int majorityNumber(List<Integer> nums) {
        int a=-1,b=-1,counta=0,countb=0;
        for(int i=0;i<nums.size();i++){
            int curr=nums.get(i);
            if(a==curr){
                counta++;
            }else if(b==curr){
                countb++;
            }else if(counta==0){
                a=curr;
            }else if(countb==0){
                b=curr;
            }else{
                counta--;
                countb--;
            }
        }
        counta=0;
        countb=0;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==a)
                counta++;
            else if(nums.get(i)==b)
                countb++;
        }
        a=counta>countb?a:b;
        return a;
    }

}
