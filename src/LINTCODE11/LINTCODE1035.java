package LINTCODE11;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1035 {
    /*Description
    * 在一个森林中，每个兔子都有一种颜色。兔子中的一部分（也可能是全部）会告诉你有多少兔子和它们有同样的颜色。这些答案被放在了一个数组中。
    * 返回森林中兔子可能的最少的数量。
    * */

    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:answers)
            map.put(num,map.getOrDefault(num,0)+1);
        int result=0;
        for(Map.Entry entry:map.entrySet()){
            int key= (int) entry.getKey()+1;
            int value=(int) entry.getValue();
            System.out.println(key+" "+value);
            result+=(key)*Math.ceil(value/(key));
        }
        return result;
        // write your code here
    }

}
