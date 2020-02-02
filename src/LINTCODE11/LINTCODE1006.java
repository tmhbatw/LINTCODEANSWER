package LINTCODE11;

import java.util.*;

public class LINTCODE1006 {
    /*Description
    * 诸如discuss.lintcode.com这样的域名由各种子域名构成。最顶层是com，下一层是lintcode.com，
    * 最底层是discuss.lintcode.com.当访问discuss.lintcode.com时，会隐式访问子域名lintcode.com和com.
    * 现给出域名的访问计数格式为“空格 地址”。 示例：9001 discuss.lintcode.com.
    * 给出计数列表cpdomains. 返回每个子域名（包含父域名）的访问次数（与输入格式相同，顺序任意）.
    * */

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map=new HashMap<>();
        for(String cur:cpdomains)
            getMessage(cur,map);
        System.out.println(map);
        List<String> result=new ArrayList<>();
        for(Map.Entry entry:map.entrySet()){
            String res=entry.getValue()+" "+entry.getKey();
            result.add(res);
        }
        return result;
        // Write your code here
    }

    private void getMessage(String cur, Map<String,Integer> map){
        String[] curr=cur.split(" ");
        int time=Integer.parseInt(curr[0]);
        String[] curS=curr[1].split("\\.");
        String curs="";
        for(int i=curS.length-1;i>=0;i--){
            curs=curS[i]+curs;
            map.put(curs,map.getOrDefault(curs,0)+time);
            curs="."+curs;
        }
    }
}
