package LINTCODE11;

import datastructure.TreeNode;

import java.util.*;

public class LINTCODE1070 {
    /*Description
    * 给定一个帐户列表，每个元素accounts [i]是一个字符串列表，其中第一个元素accounts [i] [0]是账户名称，其余元素是这个帐户的电子邮件。
    * 现在，我们想合并这些帐户。如果两个帐户有相同的电子邮件地址，则这两个帐户肯定属于同一个人。
    * 请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为两个不同的人可能会使用相同的名称。
    * 一个人可以拥有任意数量的账户，但他的所有帐户肯定具有相同的名称。
    * 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按字典序排序后的电子邮件。
    * 帐户本身可以按任何顺序返回。
    * */

    Map<String,String> map;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        map=new HashMap<>();
        Map<String,String> nameMap=new HashMap<>();
        for(int i=0;i<accounts.size();i++){
            List<String> curList=accounts.get(i);
            nameMap.put(i+"",curList.get(0));
            map.put(i+"",i+"");
            for(int j=1;j<curList.size();j++){
                if(map.containsKey(curList.get(j))){
                    String curType=i+"";
                    String targetType=getType(curList.get(j));
                    map.put(curType,targetType);
                }else{
                    map.put(curList.get(j),i+"");
                }
            }
        }
        System.out.println(map);
        Map<String,List<String>> result=new HashMap<>();
        for(Map.Entry entry:map.entrySet()){
            String type= getType((String) entry.getKey());
            String address=(String)entry.getValue();
            if(!result.containsKey(type))
                result.put(type,new ArrayList<>());
            List<String> cur=result.get(type);
            cur.add(address);
        }
        List<List<String>> res=new ArrayList<>();
        for(Map.Entry entry:result.entrySet()){
            String type= (String) entry.getKey();
            List<String> curList= (List<String>) entry.getValue();
            Collections.sort(curList);
            curList.add(0,nameMap.get(type));
            res.add(curList);
        }

        return res;
        // write your code here
    }

    private String getType(String cur){
        if(map.get(cur).equals(cur))
            return cur;
        return getType(map.get(cur));
    }
}
