package LINTCODE13;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1264 {

    /*Description
    * 给定N个坐标轴对齐的矩形，其中N>0，判断所有给定的矩形能否共同完美覆盖一个矩形区域。
    * 矩形用左下角和右上角的坐标表示。例如，一个单位正方形表示为[1, 1, 2, 2]。（左下角的坐标为(1, 1)，
    * 同时右上角的坐标为(2, 2)）
    * */

    public boolean isRectangleCover(int[][] rectangles) {
        // write your code here
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < rectangles.length; i++) {
            for (int j = 0; j < 4; j++) {
                String cur = rectangles[i][j / 2 * 2]+ ":" + rectangles[i][j % 2 * 2 + 1];
                int temp = map.getOrDefault(cur,0);
                if ((temp & (1 << j)) > 0) {
                    return false;
                }
                temp |= (1 << j);
                map.put(cur, temp);
            }
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if((val & (val - 1)) == 0 && count++ > 4) {
                return false;
            }
            if(((val & (val - 1)) > 0) &&
                    (!(val == 3 || val == 12 || val == 5 || val == 10 || val == 15))) {
                return false;
            }
        }
        return true;
    }
}
