package LINTCODE10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE922 {
    /*Description
    * 给定一个字符串，我们可以将它的每个字母“转换”到它的后续字母，
    * 例如："abc"->"bcd"。我们可以保持“转换”，这就构成了序列：
    * */


    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> map=new HashMap<>();
        for(String cur:strings){
            String curr=getOrigin(cur);
            System.out.println(cur+" "+curr);
            if(map.containsKey(curr)){
                List<String> list=map.get(curr);
                list.add(cur);
                map.put(curr,list);
            }else{
                List<String> list=new ArrayList<>();
                list.add(cur);
                map.put(curr,list);
            }
        }
        List<List<String>> res=new ArrayList<>();
        for(HashMap.Entry entry:map.entrySet())
            res.add((List<String>) entry.getValue());
        return res;
        // write your code here
    }

    public String getOrigin(String cur){
        String res="";
        int reduce=cur.charAt(0)-'a';
        for(int i=0;i<cur.length();i++) {
            char curr= (char) (cur.charAt(i)-reduce);
            if(curr<'a'){
                curr= (char) (curr+26);
            }
            res += curr;
        }
        return res;
    }
}
