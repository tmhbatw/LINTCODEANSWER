package LINTCODE8;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE739 {
    /*Description
    * 你有 4 张卡片, 每一张上面都有一个 1 到 9 的数字.
    * 你需要判断是否能用运算符 *, /, +, -, (, ) 来计算得到 24
    * */

    List<double[]> res=new ArrayList<>();
    public boolean compute24(double[] nums) {
        dfs(nums,0);
        double d=0.000000000001;
        for(double[] num:res) {
            List<Double> list = getRes(num, 0, 3);
            for (double cur : list) {
                if (Math.abs(24L-cur)<d)
                    return true;
            }
        }
        return false;
        // write your code here
    }

    private void dfs(double[] nums, int index){
        if(index==nums.length){
            res.add(nums.clone());
            return;
        }
        for(int i=index+1;i<nums.length;i++){
            swap(nums,index,i);
            dfs(nums,index+1);
            swap(nums,index,i);
        }
    }

    private void swap(double[] nums, int index1, int index2){
        double temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }

    private List<Double> getRes(double[] num,int start ,int end){
        List<Double> res=new ArrayList<>();
        if(start==end){
            res.add( num[start]);

            return res;
        }
        if(end-start==1){
            res.add((num[start]+num[end]));
            res.add((num[start]-num[end]));
            res.add(num[start]*num[end]);
            res.add(num[start]/num[end]);
            return res;
        }
        for(int i= start;i<=end-1;i++){
            List<Double> l1=getRes(num,start,i);
            List<Double> r1=getRes(num,i+1,end);
            for(double cur1:l1){
                for(double cur2:r1){
                    res.add(cur1+cur2);
                    res.add(cur1-cur2);
                    res.add(cur1*cur2);
                    res.add(cur1/cur2);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        double cu1=8*1.0/3;
        double cu2=3-cu1;
        double d=0.00000000001;
        System.out.println(cu2);
        System.out.println(24-8/cu2<d);
    }
}
