package LINTCODE15;

import java.util.*;

public class LINTCODE1454 {
    /*Description
    * 输入一个字符串s和一个字符串列表excludeList，求s中不存在于excludeList中的所有的最高频词。你的结果将会被判题程序按字典序排序。
    * */

    public String[] getWords(String s, String[] excludeList) {
        HashSet<String> set=new HashSet<>();
        for(String cur:excludeList)
            set.add(cur);
        Map<String,Integer> map=new HashMap<>();
        int length=s.length();
        for(int i=0;i<length;i++){
            char cur=s.charAt(i);
            if(cur<='Z'&&cur>='A'||cur<='z'&&cur>='a'){
                if(cur<='Z')
                    cur=(char)(cur-'A'+'a');
                StringBuilder sb=new StringBuilder();
                sb.append(cur);
                while(i+1<length){
                    i++;
                    cur=s.charAt(i);
                    if(cur<='Z'&&cur>='A')
                        sb.append((char)(cur-'A'+'a'));
                    else if(cur<='z'&&cur>='a')
                        sb.append(cur);
                    else
                        break;
                }
                String res=sb.toString();
                if(!set.contains(res)){
                    map.put(res,map.getOrDefault(res,0)+1);
                }
            }
        }
        int maxTime=0;
        List<String> res=new ArrayList<>();
        for(Map.Entry entry:map.entrySet()){
            int curTime= (int) entry.getValue();
            if(curTime==maxTime)
                res.add((String)entry.getKey());
            if(curTime>maxTime){
                maxTime=curTime;
                res=new ArrayList<>();
                res.add((String)entry.getKey());
            }
        }
        String[] result=new String[res.size()];
        for(int i=0;i<res.size();i++)
            result[i]=res.get(i);
        return result;
        // Write your code here
    }


}
