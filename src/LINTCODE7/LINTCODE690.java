package LINTCODE7;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE690 {
    /*Description
    * 给一个数字 n, 以字符串的形式返回数字的阶乘
    * */

    public String factorial(int n) {
        if(n<=1)
            return n+"";
        List<Integer> list=new ArrayList<>();
        list.add(1);
        for(int i=2;i<=n;i++){
            int count=0;
            for(int j=0;j<list.size();j++){
                long cur=list.get(j);
                cur =cur*i+count;
                list.set(j,(int)(cur%10));
                count =(int)(cur/10);
            }
            while(count!=0){
                int last=count%10;
                list.add(last);
                count/=10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=list.size()-1;i>=0;i--)
            sb.append(list.get(i));
        return sb.toString();
        // write your code here
    }



}
