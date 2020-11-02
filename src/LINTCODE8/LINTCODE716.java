package LINTCODE8;

import java.util.HashSet;

public class LINTCODE716 {
    /*Description
    * 给出两个整型数组 inputs 和 tests，只要你能从 inputs中挑出一对数字，
    * 令它们的和能够在 tests被找到，就返回真；如果一对都找不到，则返回假。
    * */


    public boolean addAndSearch(int[] inputs, int[] tests) {
        HashSet<Integer> set=new HashSet<>();
        for(int cur:tests)
            set.add(cur);
        int length=inputs.length;
        for(int i=0;i<length;i++){
            int cur=inputs[i];
            for(int j=i+1;j<length;j++){
                if(set.contains(inputs[j]+cur))
                    return true;
            }
        }
        return false;
        // write your code here.
    }


    //笨比方法
/*    public boolean addAndSearch(int[] inputs, int[] tests) {
        boolean[] exist=new boolean[2001];
        for(int i=0;i<inputs.length;i++){
            int cur=inputs[i];
            for(int j=i+1;j<inputs.length;j++){
                int curr=cur+inputs[j];
                if(curr<=1000&&curr>=-1000){
                    exist[curr+1000]=true;
                }
            }
        }
        for(int cur:tests){
            if(exist[cur+1000])
                return true;
        }
        return false;
        // write your code here.
    }*/
}
