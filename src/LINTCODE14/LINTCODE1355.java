package LINTCODE14;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1355 {
    /*Description
    * 给定一个非负整数 *numRows，*生成杨辉三角的前 numRows 行。
    * */

    public List<List<Integer>> generate(int numRows) {
        if(numRows==0)
            return null;
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ress=new ArrayList<>();
        ress.add(1);
        result.add(ress);
        if(numRows==1)
            return result;
        List<Integer> res=new ArrayList<>();
        res.add(1);
        res.add(1);
        result.add(res);
        if(numRows==2)
            return result;
        for(int i=3;i<=numRows;i++){
            List<Integer> cur=new ArrayList<>();
            cur.add(1);
            for(int j=0;j<i-2;j++){
                cur.add(res.get(j)+res.get(j+1));
            }
            cur.add(1);
            res=cur;
            result.add(res);
        }
        return result;
        // write your code here
    }
}
