package LINTCODE12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LINTCODE1143 {
    /*Description
    * 假设Andy和Doris想要选择一家餐馆吃晚餐，他们都有一个各自最喜爱的餐馆列表。
    * 你需要用最少的列表索引总和来帮助他们找出他们的共同兴趣。
    * 如果最少列表索引总和的答案不唯一，则输出所有答案并且没有顺序要求。 你可以假设总有一个答案。
    * */

    /*Solution
    *注意可能有多个解
    * */

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        List<String> res=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                int cur=map.get(list2[i])+i;
                if(min==cur) {
                    res.add(list2[i]);
                }else if(min>cur){
                    res=new ArrayList<>();
                    res.add(list2[i]);
                    min=cur;
                }
            }
        }
        String[] result=new String[res.size()];
        for(int i=0;i<res.size();i++)
            result[i]=res.get(i);
        return result;
        // Write your code here
    }
}
