package LINTCODE17;

import java.util.Collections;
import java.util.List;

public class LINTCODE1601 {
    /*Description
    * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
    * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
    * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
    * */

    public int numRescueBoats(List<Integer> people, int limit) {
        Collections.sort(people);
        int result=0;
        int left=0,right=people.size()-1;
        while(left<=right){
            if(people.get(left)+people.get(right)<=limit)
                left++;
            right--;
            result++;
        }
        return result;
        // Write your code here.
    }
}
