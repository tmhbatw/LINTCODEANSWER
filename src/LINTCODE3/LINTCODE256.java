package LINTCODE3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LINTCODE256 {
    /*Description
    * 一名经理被指派去处理公司休息室的食物浪费现象。
    * 休息室里有几包奶精，每包都有有效期，奶精必须在有效期之内使用。
    * 经理还可以选择从杂货店订购额外的奶精，每一包奶精都有不同的有效期。
    * 给定每日对奶精的最大需求量，求出经理在不浪费的情况下可以订购的最大奶精数量。
    * 输入包括三个参数：
    * onHand[]：一个整数数组表示已有的个奶精的保质期
    * supplier[]：一个整数数组表示可以选择订购的奶精的保质期
    * demand：每天最多可以消耗的奶精数量
    * 请返回在没有浪费的情况下可以订购的最大奶精数量，如果一定会有浪费则返回 -1
    * */

    //0,2,2 2,0,0 2 2
    public int stockLounge(List<Integer> onHand, List<Integer> supplier, int demand) {
        Collections.sort(onHand);
        Collections.sort(supplier);
        if(!isMatch(onHand,supplier, 0, demand))
            return -1;
        int left=0, right=supplier.size();
        while(left<right){
            int mid=(left+right+1)/2;
            if(isMatch(onHand, supplier, mid, demand)){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return left;
        // write your code here
    }

    private boolean isMatch(List<Integer> onHand, List<Integer> supplier, int cur, int demand){
        int[] num=new int[onHand.size()+cur];
        int index1=0,index2=supplier.size()-cur;
        int count=demand;
        int day=0;
        for(int i=0;i<num.length;i++){
            int num1=index1==onHand.size()?Integer.MAX_VALUE:onHand.get(index1);
            int num2=index2==supplier.size()?Integer.MAX_VALUE:supplier.get(index2);
            int n=num1;
            if(num1>num2){
                n=num2;
                index2++;
            }else
                index1++;
            if(n<day)
                return false;
            count--;
            if(count==0){
                count=demand;
                day++;
            }
        }
        return true;
    }
}
