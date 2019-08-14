package LINTCODE8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE768 {
    /*Description
    * Given an integer n, return the first n-line Yang Hui triangle.
    * */

    public List<List<Integer>> calcYangHuisTriangle(int n) {
        if(n==0)
            return Collections.emptyList();
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        res.add(1);
        result.add(res);
        for(int i=2;i<=n;i++){
            List<Integer> cur=new ArrayList<>();
            List<Integer> pre=result.get(i-2);
            cur.add(1);
            for(int j=0;j<i-2;j++){
                cur.add(pre.get(j)+pre.get(j+1));
            }
            cur.add(1);
            result.add(cur);
        }
        return result;
        // write your code here
    }
}
