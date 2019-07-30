package LINTCODE14;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1368 {
    /*Description
    * 给一个数组，如果数组中存在相同数字，
    * 且至少有两个相同数字的距离小于给定值k，输出YES，否则输出NO。
    * */

    public String sameNumber(int[] nums, int k) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] cur = map.get(nums[i]);
                cur[1] = Math.min(cur[1], i - cur[0] + 1);
                cur[0] = i;
                map.put(nums[i], cur);
            } else {
                map.put(nums[i], new int[]{i, Integer.MAX_VALUE});
            }
        }
        for (HashMap.Entry cur : map.entrySet()) {
            int key= (int) cur.getKey();
            int[] value = (int[]) cur.getValue();
            System.out.println(key+" "+value[1]);
            if (value[1] < k)
                return "YES";
        }
        return "NO";

    }
}
