package LINTCODE8;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE776 {
    /*Description
    * 对称数是一个旋转180度后(倒过来)看起来与原数相同的数.找到所有长度为 n 的对称数.
    * */

    public List<String> findStrobogrammatic(int n) {
        List<String> result=new ArrayList<>();
        if(n%2==0) {
            result.add("");
            return result;
        }else{
            result.add("1");
            result.add("0");
            result.add("8");
        }
        for(int i=0;i<=n;i+=2){
            List<String> list=new ArrayList<>();
            for(String cur:result){
                list.add("1"+cur+"1");
                list.add("8"+cur+"8");
                list.add("6"+cur+"9");
                list.add("9"+cur+"6");
                if(i<=n-2){
                    list.add("0"+cur+"0");
                }
            }
            result=list;
        }
        return result;
        // write your code here
    }
}
