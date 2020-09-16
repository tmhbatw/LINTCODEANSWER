package LINTCODE4;

import java.util.*;

public class LINTCODE303 {
    /*Description
    * 手机号码由且仅由 N 位十进制数字(0-9)组成。一个手机号码中有至少 k 位数字相同则被定义为靓号。
    * 手机号可以有前导零，比如 000123456 是一个合法的手机号。
    * 小多想花钱将自己的手机号码修改为一个靓号。修改号码中的一个数字需要花费的金额为新数字与旧数字之间的差值的绝对值。
    * 比如将 1 修改为 6 或 6 修改为 1 都需要花 5 块钱。
    * 给定一个长度为N的整型数组number作为小多现在的手机号码，问将其修改成一个靓号，花费最少的靓号是哪一个？
    * 如果有多个靓号花费最少，那么返回字典序最小的靓号。
    * */

    public String getMiniumNumber(int[] number, int k) {
        int[] time=new int[10];
        for(int cur:number)
            time[cur]++;
        List<int[]> list=getModifiedNumber(time,k);
        String res=getNumber(number,list.get(0));
        for(int i=1;i<list.size();i++){
            String cur=getNumber(number,list.get(i));
            if(cur.compareTo(res)<0)
                res=cur;
        }
        return res;
        // write your code here
    }

    private String getNumber(int[] num,int[] curNumber){
        int[] number=num.clone();
        int index=curNumber[10];
        for(int i=index+1;i<10;i++){
            int cur=curNumber[i];
            for(int j=0;j<number.length;j++){
                if(number[j]==i&&cur>0){
                    number[j]=index;
                    cur--;
                }
                if(cur==0)
                    break;
            }
        }
        for(int i=0;i<index;i++){
            int cur=curNumber[i];
            for(int j=number.length-1;j>=0;j--){
                if(number[j]==i&&cur>0){
                    number[j]=index;
                    cur--;
                }
                if(cur==0)
                    break;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int cur:number)
            sb.append(cur);
        return sb.toString();
    }
    private List<int[]> getModifiedNumber(int[] number, int k){
        List<int[]> result=new ArrayList<>();
        int spend=Integer.MAX_VALUE;
        for(int i=0;i<10;i++){
            int[] curNumber=new int[11];
            int curK=k-number[i];
            int curRes=0;
            int next=i+1,pre=i-1;
            while(curK>0){
                if(next<10){
                    if(curK<=number[next]){
                        curNumber[next]=curK;
                        curRes+=curNumber[next]*(next-i);
                        break;
                    }else{
                        curK-=number[next];
                        curNumber[next]=number[next];
                        curRes+=curNumber[next]*(next-i);
                        next++;
                    }
                }
                if(pre>=0){
                    if(curK<=number[pre]){
                        curNumber[pre]=curK;
                        curRes+=curNumber[pre]*(i-pre);
                        break;
                    }else{
                        curK-=number[pre];
                        curNumber[pre]=number[pre];
                        curRes+=curNumber[pre]*(i-pre);
                        pre--;
                    }
                }
            }
            curNumber[10]=i;
            if(curRes==spend){
                result.add(curNumber);
            }
            if(curRes<spend){
                spend=curRes;
                result=new ArrayList<>();
                result.add(curNumber);
            }
        }
        return result;
    }
}
