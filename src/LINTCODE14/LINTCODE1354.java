package LINTCODE14;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1354 {
    /*Description
    * 给定非负索引k，其中k≤33，返回杨辉三角形的第k个索引行。
    * */

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre=new ArrayList<>();
        pre.add(1);
        if(rowIndex==0)
            return pre;
        pre.add(1);
        if(rowIndex==1)
            return pre;
        for(int i=2;i<=rowIndex;i++){
            List<Integer> cur=new ArrayList<>();
            cur.add(1);
            for(int j=0;j<i-2;j++){
                cur.add(pre.get(j)+pre.get(j+1));
            }
            cur.add(1);
            pre=cur;
        }
        return pre;
        // write your code here
    }
}
