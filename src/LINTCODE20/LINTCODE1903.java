package LINTCODE20;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class LINTCODE1903 {
    /*Description
    * 公司给你提供了所有员工的信息，包括其ID，姓名和所属部门。
    * 以及他们之间的朋友关系，每个关系中由2个ID组成，如 "1, 2" 代表1号员工和2号员工是朋友。
    * 朋友关系不具有传递性，即B、C都是A的朋友，但B和C不一定是朋友。
    * 请计算每个部门中与其它部门的员工有朋友关系的员工个数。
    * */

    public List<String> departmentStatistics(List<String> employees, List<String> friendships) {
        HashMap<String,Integer> map1=new HashMap<>();//用来存储部门与部门人数的关系
        HashMap<String,Integer> map2=new HashMap<>();//用来存储部门以及部门里满足要求的人数的关系

        HashMap<String,String> map3=new HashMap<>();//用来存储人所处的部门名称
        HashMap<String, Boolean> map4=new HashMap<>();//用来存储该成员是否符合要求

        for(String cur:employees){
            String[] list=cur.split(", ");
            map1.put(list[2],map1.getOrDefault(list[2],0)+1);
            map2.put(list[2],0);
            map3.put(list[0],list[2]);
            map4.put(list[0],false);
        }

        for(String cur:friendships){
            String[] list=cur.split(", ");
            String department1=map3.get(list[0]);
            String department2=map3.get(list[1]);
            if(!department1.equals(department2)){
                if(!map4.get(list[0]))
                    map2.put(department1,map2.get(department1)+1);
                if(!map4.get(list[1]))
                    map2.put(department2,map2.get(department2)+1);
                map4.put(list[1],true);
                map4.put(list[0],true);
            }
        }

        List<String> result=new ArrayList<>();
        for(Map.Entry entry:map1.entrySet()){
            String department=(String)entry.getKey();
            StringBuilder res=new StringBuilder();
            res.append(department).append(": ");
            res.append(map2.get(department)).append(" of ").append(map1.get(department));
            result.add(res.toString());
        }
        return result;
        // write your code here.S
    }

}
