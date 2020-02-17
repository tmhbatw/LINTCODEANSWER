package LINTCODE14;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1309 {
    /*Description
    * 给定一串数字和运算符，通过计算所有不同的聚合数字和运算符的方式，
    * 返回所有可能的结果。 有效的运算符是+，- 和*。
    * */

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<input.length();i++){
            char cur=input.charAt(i);
            if(cur=='+'||cur=='-'||cur=='*'){
                List<Integer> list1=diffWaysToCompute(input.substring(0,i));
                List<Integer> list2=diffWaysToCompute(input.substring(i+1,input.length()));
                for(int m=0;m<list1.size();m++){
                    for(int n=0;n<list2.size();n++){
                        int p1=list1.get(m);
                        int p2=list2.get(n);
                        switch (cur){
                            case '+':
                                result.add(p1+p2);
                                break;
                            case '-':
                                result.add(p1-p2);
                                break;
                            default:
                                result.add(p1*p2);
                        }
                    }
                }
            }
        }
        if(result.size()==0)
            result.add(Integer.parseInt(input));
        return result;
        // write your code here
    }
}
