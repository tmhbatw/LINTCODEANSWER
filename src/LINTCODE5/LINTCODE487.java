package LINTCODE5;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE487 {
    /*Description
    *给一串名字，将他们去重之后返回。两个名字重复是说在忽略大小写的情况下是一样的。
    * */

    /*Solution
    *将字符小写判断是否重复，如果不重后加入list，
    * */

    public List<String> nameDeduplication(String[] names) {
        List<String> result=new ArrayList<>();
        for(String cur:names){
            cur=getSmall(cur);
            if(result.contains(cur))
                continue;
            result.add(cur);
        }
        return result;
        // write your code here
    }

    public String getSmall(String s){
        String result="";
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(curr<='Z'&&curr>='A') {
                curr=(char)(curr+'a'-'A');
            }
            result+=curr;
        }
        return result;
    }

}
