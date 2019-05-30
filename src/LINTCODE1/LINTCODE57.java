package LINTCODE1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LINTCODE57 {
    /*Description
    *给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
    * */

    /*Solution
    * 三次循环可以轻松解决（使用hash表亦可）
    * 注意需要一部去重过程
    * */

    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            //变成了找出两个数使之和为-numbers[i];
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=i+1;j<numbers.length;j++){
                if(map.containsKey(-numbers[i]-numbers[j])){
                    List<Integer> res=new ArrayList<>();
                    res.add(numbers[i]);

                    res.add(-numbers[i]-numbers[j]);
                    res.add(numbers[j]);
                    list.add(res);
                }
                if(!map.containsKey(numbers[j]))
                    map.put(numbers[j],j);
            }
        }
        delete(list);
        return list;
        // write your code here
    }


    private void delete(List<List<Integer>> result){
        for(int i=0;i<result.size();i++){
            for(int j=result.size()-1;j>i;j--){
                if(result.get(i).equals(result.get(j)))
                    result.remove(j);
            }
        }
    }

    //三部循环方法
/*    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                for(int k=j+1;k<numbers.length;k++){
                    if(numbers[i]+numbers[j]+numbers[k]==0){
                        List<Integer> res=new ArrayList<>();
                        res.add(numbers[i]);
                        res.add(numbers[j]);
                        res.add(numbers[k]);
                        list.add(res);
                    }
                }
            }
        }
        delete(list);
        return list;
        // write your code here
    }*/
}
