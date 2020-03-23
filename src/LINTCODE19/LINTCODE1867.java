package LINTCODE19;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1867 {
    /*Description
    * 给出一个字符串，表示小说的内容，返回string中出现次数最多的单词（如果次数最多的有多个，返回字典序最小的一个）。
    * */

    public String mostCommonWord(String paragraph) {
        Map<String,Integer> map=new HashMap<>();
        int length=paragraph.length();
        for(int i=0;i<length;i++){
            char cur =paragraph.charAt(i);
            if(cur<='Z'&&cur>='A'||cur<='z'&&cur>='a'){
                if(cur <= 'Z'){
                    cur= (char) (cur-'A'+'a');
                }
                StringBuilder sb=new StringBuilder();
                sb.append(cur);
                while(i+1<length){
                    i++;
                    cur=paragraph.charAt(i);
                    if(cur<='Z'&&cur>='A')
                        sb.append((char)(cur-'A'+'a'));
                    else if(cur<='z'&&cur>='a')
                        sb.append(cur);
                    else
                        break;
                }
                String curStr=sb.toString();
                map.put(curStr,map.getOrDefault(curStr,0)+1);
            }
        }
        int maxTime=0;
        String result="";
        for(Map.Entry entry:map.entrySet()){
            int time= (int) entry.getValue();
            if(time>maxTime){
                maxTime=time;
                result= (String) entry.getKey();
            }else if(time==maxTime){
                String cur=(String) entry.getKey();
                if(result.compareTo(cur)>0)
                    result=cur;
            }
        }
        return result;
        //
    }
}
