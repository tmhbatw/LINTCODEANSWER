package LINTCODE10;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE935 {
    /*Description
    * 我们采用二维数组setList[][]表示集合数组，其中setList[i]中的每个元素都为整数，且不相同。求集合setList[0],setList[1],...,setList[setList.length - 1]的笛卡尔积。
    * 一般地，集合A和集合B的笛卡尔积A×B = {(x,y)|x∈A∧y∈B}。
    * */

    public List<List<Integer>> getSet(int[][] setList) {
        return recursion(setList,0);
        // Write your code here
    }

    private List<List<Integer>> recursion(int[][] setList,int curIndex){
        List<List<Integer>> result=new ArrayList<>();
        int[] cur=setList[curIndex];
        if(curIndex==setList.length-1){
            for(int num:cur){
                List<Integer> curList=new ArrayList<>();
                curList.add(num);
                result.add(curList);
            }
            return result;
        }
        List<List<Integer>> later=recursion(setList,curIndex+1);
        for(int num:cur){
            for(List<Integer> list:later){
                List<Integer> curList=new ArrayList<>(list);
                curList.add(0,num);
                result.add(curList);
            }
        }
        return result;
    }
}
