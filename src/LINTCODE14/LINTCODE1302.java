package LINTCODE14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE1302 {
    /*Description
    * 小明的公司的员工的个人每个月的薪酬是xi元。
    * 现在小明的老板向小明提了几次询问, 每次询问老板都会给出一个整数k,小明要快速回答老板工资等于k的员工的数量。
    * */

    public List<Integer> PeopleCounting(List<Integer> wage, List<Integer> ask) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur:wage){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        List<Integer> result=new ArrayList<>();
        for(int cur:ask){
            result.add(map.getOrDefault(cur,0));
        }
        return result;
        // write your code here
    }

}
