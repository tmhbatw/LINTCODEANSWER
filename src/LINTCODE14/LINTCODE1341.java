package LINTCODE14;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LINTCODE1341 {
    /*Description
    * 现在有一个数组a，你可以从里面取任意个数字，用这些数字组成一个新的数字，例如5，12，3三个数字可以组成新数字5123。
    * 题目需要你求出最大的能被3整除的新组合数字。
    * */

    public String combine(List<Integer> a) {
        int sum=0;
        for(int cur:a)
            sum+=cur;
        Collections.sort(a);
        //移除数字使得和为3
        //两个2，1个1
        if(sum%3==1){
            removeNumber(a,2,1);
        }
        //两个1，1个2
        if(sum%3==2){
            removeNumber(a,1,2);
        }
        StringBuilder sb=new StringBuilder();
        Collections.sort(a,(o1,o2)->{
            String oo1=o1+""+o2;
            String oo2=o2+""+o1;
            return oo2.compareTo(oo1);
        });
        for(int cur:a)
            sb.append(cur);
        return sb.toString();
        // write your code here
    }

    private void removeNumber(List<Integer> a,int mod1,int mod2){
        int num1=0,num2=0;
        int i1=-1,i2=-1;
        int num3=0;
        int i3=-1;
        for(int i=0;i<a.size();i++){
            if(a.get(i)%3==mod1){
                if(i1==-1){
                    num1=a.get(i);
                    i1=i;
                }else if(i2==-1){
                    num2=a.get(i);
                    i2=i;
                }
            }
            if(a.get(i)%3==mod2){
                if(i3==-1){
                    num3=a.get(i);
                    i3=i;
                }
            }
            if(i3!=-1&&i2!=-1)
                break;
        }
        if(i3==-1){
            a.remove(i2);
            a.remove(i1);
        }else if(i2==-1){
            a.remove(i3);
        }else{
            String s1=(num1+""+num2).compareTo(num2+""+num1)<0?num2+""+num1:num1+""+num2;
            String s3=num3+"";
            if(s1.length()<s3.length()||s1.length()==s3.length()&&s1.compareTo(s3)<0){
                a.remove(i2);
                a.remove(i1);
            }else{
                a.remove(i3);
            }
        }
    }
}
