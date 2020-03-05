package LINTCODE18;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1789 {
    /*Description
    * 给出一组用户名，如果有重复的请求在用户名后添加数字区别，返回修改后的数组。
    * */

    public String[] DistinguishUsername(String[] names) {
        Map<String,Integer> map=new HashMap<>();
        int length=names.length;
        String[] result=new String[length];
        for(int i=0;i<length;i++){
            String cur=names[i];
            if(!map.containsKey(cur)) {
                result[i] = cur;
                map.put(cur,1);
            }else{
                result[i]=cur+map.get(cur);
                map.put(cur,map.get(cur)+1);
            }
        }
        return result;
        // Write your code here
    }

}
