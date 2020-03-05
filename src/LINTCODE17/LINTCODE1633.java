package LINTCODE17;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1633 {
    /*Description
    * 给定一个字符串target和字符串数组s，按在s中的原次序输出s中所有包含target的字符串(即满足target为s[i]的一个子序列)
    * */

    public String[] getAns(String target, String[] s) {
        if(target.length()==0)
            return s;
        List<String> list=new ArrayList<>();
        for(String cur:s){
            if(isSubString(target,cur))
                list.add(cur);
        }
        String[] result=list.toArray(new String[list.size()]);
        return result;
        // Write your code here
    }

    private boolean isSubString(String target,String cur){
        int index=0;
        for(int i=0;i<cur.length();i++){
            if(cur.charAt(i)==target.charAt(index))
                index++;
            if(index==target.length())
                return true;
        }
        return false;
    }
}
