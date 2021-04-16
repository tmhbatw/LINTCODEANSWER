package LINTCODE8;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE706 {
    /*Description
    * 给了一个二进制显示时间的手表和一个非负整数 n, n 代表在给定时间表上 1 的数量, 返回所有可能的时间
    * */

    public List<String> binaryTime(int num) {
        List<String> result=new ArrayList<>();
        for(int i=0;i<=Math.min(num,3);i++){
            if(num-i>5)
                continue;
            List<String> hourList=new ArrayList<>();
            getHourList(i,hourList,0,1);
            List<String> minList=new ArrayList<>();
            getMinList(num-i,minList,0,1);
            for(int m=0;m<hourList.size();m++){
                for(int n=0;n<minList.size();n++){
                    result.add(hourList.get(m)+":"+minList.get(n));
                }
            }
        }
        return result;
        // Write your code here
    }

    private void getHourList(int n,List<String> hourList,int cur,int count){
        if(n==0&&cur<12){
            hourList.add(cur+"");
            return;
        }
        if(cur>=12||count>=12)
            return;
        getHourList(n,hourList,cur,count*2);
        getHourList(n-1,hourList,cur+count,count*2);
    }

    private void getMinList(int n,List<String> minList,int cur,int count){
        if(n==0&&cur<60){
            minList.add(cur<10?"0"+cur:cur+"");
            return;
        }
        if(cur>=60||count>=60)
            return;
        getMinList(n,minList,cur,count*2);
        getMinList(n-1,minList,cur+count,count*2);
    }


    public static void main(String[] args){
        int maxBitCount=0;
        for(int i=0;i<=12;i++){
            maxBitCount=Math.max(maxBitCount,Integer.bitCount(i));
        }
        System.out.println(maxBitCount);
    }
}
