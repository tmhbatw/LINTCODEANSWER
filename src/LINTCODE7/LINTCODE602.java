package LINTCODE7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE602 {
    /*Description
    * 给一定数量的信封，带有整数对 (w, h) 分别代表信封宽度和高度。
    * 一个信封的宽高均大于另一个信封时可以放下另一个信封。求最大的信封嵌套层数。
    * */

    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==0)
            return 0;
        Arrays.sort(envelopes,((o1, o2) -> {
            if(o1[0]==o2[0])
                return o2[1]-o1[1];
            return o1[0]-o2[0];
        }));
        List<Integer> list=new ArrayList<>();
        list.add(envelopes[0][1]);
        int length=envelopes.length;
        for(int i=1;i<length;i++){
            if(envelopes[i][0]>envelopes[i-1][0]&&envelopes[i][1]>list.get(list.size()-1)){
                list.add(envelopes[i][1]);
                continue;
            }
            int height=envelopes[i][1];
            int l = 0, r =list.size()-1;
            while(l<r){
                int mid = (l+r)/2;
                if(list.get(mid)<height)
                    l=mid+1;
                else
                    r=mid;
            }
            list.set(l,height);
        }
        return list.size();
        // write your code here
    }
}
