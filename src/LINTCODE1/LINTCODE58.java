package LINTCODE1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE58 {
    /*Description
    * 给一个包含n个数的整数数组S，在S中找到所有使得和为给定整数target的四元组(a, b, c, d)。
    * */

    /*Solution
    * 需要注意时间复杂度
    * */

    private void delete(List<List<Integer>> result){
        for(int i=0;i<result.size();i++){
            for(int j=result.size()-1;j>i;j--){
                if(result.get(i).equals(result.get(j)))
                    result.remove(j);
            }
        }
    }

    //两次循环加两边向中间找目标值
        public List<List<Integer>> fourSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numbers.length-3;i++){
            for(int j=i+1;j<numbers.length-2;j++){
                if (j > i + 1 && numbers[j] == numbers[j - 1]) continue;
                int m=j+1,n=numbers.length-1;
                while(m<n){
                    if(numbers[i]+numbers[j]+numbers[m]+numbers[n]==target){
                        List<Integer> res=new ArrayList<>();
                        res.add(numbers[i]);
                        res.add(numbers[j]);
                        res.add(numbers[m]);
                        res.add(numbers[n]);
                        list.add(res);
                        m++;
                        n--;
                    }else if(numbers[i]+numbers[j]+numbers[m]+numbers[n]<target){
                        m++;
                    }else{
                        n--;
                    }
                }
            }
        }
        delete(list);
        return list;

        // write your code here
    }



    //两次循环+hash搜索法
/*    public List<List<Integer>> fourSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numbers.length-3;i++){
            for(int j=i+1;j<numbers.length-2;j++){
                if (j > i + 1 && numbers[j] == numbers[j - 1]) continue;

                HashMap<Integer,Integer> map=new HashMap<>();
                for(int m=j+1;m<numbers.length;m++){

                    if(map.containsKey(target-numbers[i]-numbers[j]-numbers[m])){
                        List<Integer> res=new ArrayList<>();
                        res.add(numbers[i]);
                        res.add(numbers[j]);
                        res.add(target-numbers[i]-numbers[j]-numbers[m]);
                        res.add(numbers[m]);
                        list.add(res);
                    }
                    if(!map.containsKey(numbers[m]))
                        map.put(numbers[m],m);
                }
            }
        }
        delete(list);
        return list;

        // write your code here
    }*/

}
