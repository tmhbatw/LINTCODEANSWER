package LINTCODE14;

import java.util.*;

public class LINTCODE1378 {
    /*Description
    * 给定一个字符串集合tag_list，一个字符串数组all_tags，请寻找最小的all_tags子数组包含tag_list中的所有字符串，输出这个子数组的长度。如果不存在返回-1。
    * */

    public int getMinimumStringArray(String[] tagList, String[] allTags) {
        HashSet<String> set=new HashSet<>(Arrays.asList(tagList));
        int end=0;
        int curNumber=0;
        int number=set.size();
        int result=-1;
        int length=allTags.length;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<length;i++){
            while(curNumber<number&&end<length){
                String cur=allTags[end++];
                if(set.contains(cur)){
                    int time=map.getOrDefault(cur,0)+1;
                    if(time==1)
                        curNumber++;
                    map.put(cur,time);
                }
            }
            if(curNumber<number)
                return result;
            while(i<length){
                String first=allTags[i];
                if(!set.contains(first)) {
                    i++;
                    continue;
                }
                if(map.get(first)==1)
                    break;
                map.put(first,map.get(first)-1);
                i++;
            }
            if(result==-1)
                result=end-i+1;
            else
                result=Math.min(result,end-i);
            map.put(allTags[i],0);
            curNumber--;
        }
        return result;
        // Write your code here
    }
}
