package LINTCODE;

import java.util.List;

public class LINTCODE48 {
    /*Description
    * Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.
    * */

    /*Solution
    *摩尔投票法复杂版本，创建两个长度为k-1的数组分别保留所有的候选值以及其出现的次数
    * 进行摩尔投票
    * 最后重新遍历一次数组输出出现次数最多的数即可
    * */

    public int majorityNumber(List<Integer> nums, int k) {
        int[] result=new int[k-1];
        int[] count=new int[k-1];
        for(int i=0;i<nums.size();i++){
            getMooreVote(result,count,nums.get(i));
        }
        count=new int[k-1];
        for(int i=0;i<nums.size();i++) {
            getValueCount(result, count,nums.get(i));

        }

        int cou=nums.size()/k;
        for(int i=0;i<k-1;i++){
            if(count[i]>cou){
                return result[i];
            }
        }
        return -1;
        // write your code here
    }


    //摩尔投票
    private void getMooreVote(int[] result,int[] count,int curr){
        //相同则当前备选结果数值加1
        for(int i=0;i<result.length;i++){
            if(curr==result[i]){
                count[i]++;
                return;
            }
        }
        //没有一个相同但有空位则将当前数置入空位
        for(int i=0;i<result.length;i++){
            if(result[i]==0){
                result[i]=curr;
                count[i]=1;
                return;
            }
        }
        //没有空位则全体备选值数量减1
        for(int i=0;i<count.length;i++){
            count[i]--;
            result[i]=count[i]==0?0:result[i];
        }
        return;
    }

    //获取最后筛选得到的备选值的个数
    private void getValueCount(int[] result,int[] count,int curr){
        for(int i=0;i<result.length;i++){
            if(result[i]==curr){
                count[i]++;
                return;
            }
        }
    }


}
