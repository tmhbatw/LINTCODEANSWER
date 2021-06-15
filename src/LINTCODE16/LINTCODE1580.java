package LINTCODE16;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1580 {
    /*Description
    * 给一个startString，一个endString，是否可以通过一系列的转换从startString转变成endString。
    * 规则是只有26个小写字母，每个操作只能更改一种字母。例如，如果将a更改为b，则起始字符串中的所有a必须为b。
    * 对于每一类型的字符，可以选择转换或不转换，转换必须在startString中的一个字符和endString相对应的一个字符之间进行，
    * 结果返回true或false。
    * */
    boolean[] reached;
    boolean[] waited;
    boolean[] res;
    public boolean canTransfer(String startString, String endString) {
        if(startString.length()!=endString.length())
            return false;
        Map<Character,Character> map=new HashMap<>();
        for(int i=0;i<startString.length();i++){
            char start=startString.charAt(i);
            char end=endString.charAt(i);
            map.putIfAbsent(start,end);
            if(map.get(start)!=end)
                return false;
        }
        this.reached=new boolean[26];
        this.waited=new boolean[26];
        this.res=new boolean[26];
        for(int i=0;i<26;i++){
            char start=(char)(i+'a');
            dfs(start,map);
        }
        for(boolean cur:res){
            if(!cur)
                return false;
        }
        return true;
        // write your code here
    }

    private boolean dfs(char start,Map<Character,Character> map){
        if(waited[start-'a'])
            return false;
        if(reached[start-'a']){
            return res[start-'a'];
        }
        waited[start-'a']=true;
        if(!map.containsKey(start)||map.get(start)==start){
            res[start-'a']=true;
            reached[start-'a']=true;
            waited[start-'a']=false;
            return true;
        }else{
            boolean next=dfs(map.get(start),map);
            res[start-'a']=next;
            reached[start-'a']=true;
            waited[start-'a']=false;
            return next;
        }
    }
}
