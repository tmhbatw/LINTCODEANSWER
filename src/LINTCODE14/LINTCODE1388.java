package LINTCODE14;

import java.util.HashSet;

public class LINTCODE1388 {
    /*Description
    * 一个桌上有N张卡片，其上每一张的正反两面写有正整数（可能不同）。
    * 反转任意数量的卡片，然后选择一张。
    * 如果被选中的卡背面的数X没有在任何一张卡的正面上，那么X就符合要求。
    * 符合要求的最小的数是多少，如果没有数符合要求，那么返回0。
    * fronts[i]和backs[i]表示第i张卡片的正反两面的数。
    * 一次反转交换了正反两面，所以正面的数现在在反面，反之亦然
    * */

    public int flipgame(int[] fronts, int[] backs) {
        boolean hasResult=false;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<fronts.length;i++){
            if(fronts[i]!=backs[i])
                hasResult=true;
            else
                set.add(fronts[i]);
        }
        if(!hasResult)
            return 0;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<fronts.length;i++){
            if(!set.contains(fronts[i]))
                result=Math.min(result,fronts[i]);
            if(!set.contains(backs[i]))
                result=Math.min(result,backs[i]);
        }
        return result;
        //
    }

}
