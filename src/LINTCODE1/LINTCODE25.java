package LINTCODE1;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE25 {
    /*Description
    * 输入一个正整数N， 你需要按如下方式返回一个字符串列表。
    * */
    public List<String> printX(int n) {
        List<String> result=new ArrayList<>();
        if(n%2==1){
            n=(n+1)/2;
            result.add(numberSpace(n-1)+'X'+numberSpace(n-1));
            for(int i=1;i<n;i++){
                String cur=numberSpace(n-i-1)+'X'+numberSpace(i*2-1)+'X'+numberSpace(n-i-1);
                result.add(0,cur);
                result.add(cur);
            }
        }else{
            n/=2;
            for(int i=0;i<n;i++){
                String cur=numberSpace(n-i-1)+'X'+numberSpace(i*2)+'X'+numberSpace(n-i-1);
                result.add(cur);
                result.add(0,cur);
            }
        }
        return result;
        // write your code here.
    }

    private String numberSpace(int number){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<number;i++)
            sb.append(' ');
        return sb.toString();
    }
}
