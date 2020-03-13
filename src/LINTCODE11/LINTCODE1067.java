package LINTCODE11;

import java.util.Arrays;

public class LINTCODE1067 {
    /*Description
    * 给定具一个数组，编写一个函数将数组拆分为k个连续的“部分”。
    * 每个部分的长度应尽可能相等：没有两个部分的大小严格大于1。这可能导致某些部分为空。
    * 元素应按输入列表中的出现顺序排列，位置靠前的部分的长度应始终大于或等于稍后出现的部分。
    * 返回数组列表，表示形成的数组的部分。
    * */

    public int[][] splitLinkedListinParts(int[] root, int k) {
        int[][] result=new int[k][];
        int length=root.length;
        if(root.length<k){
            for(int i=0;i<root.length;i++)
                result[i]=new int[]{root[i]};
            for(int i=root.length;i<k;i++)
                result[i]=new int[0];
            return result;
        }
        int type1Time=length%k;
        int type1Number=length/k+1;
        int type2Number=length/k;
        int index=0;
        for(int i=0;i<type1Time;i++){
            result[i]=Arrays.copyOfRange(root,index,index+type1Number);
            index+=type1Number;
        }
        for(int i=type1Time;i<k;i++){
            result[i]=Arrays.copyOfRange(root,index,index+type2Number);
            index+=type2Number;
        }
        return result;
        // Write your code here.
    }
    public static void main(String[] args){
        int[] cur=new int[]{1,2,3};
        int[] curr= Arrays.copyOfRange(cur,0,2);
        System.out.println(Arrays.toString(curr));
    }
}
