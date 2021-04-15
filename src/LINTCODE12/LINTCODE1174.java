package LINTCODE12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE1174 {
    /*Description
    * 给定一个32位整数n，用同样的数字组成新的32位整数，使得它要比n大，
    * 返回最小的这样的数。如果不存在这样的整数，返回-1。
    * */


    public int nextGreaterElement(int n) {
        List<Integer> list=new ArrayList<>();
        int num=n;
        while(num>0){
            int last=num%10;
            list.add(last);
            num/=10;
        }
        for(int i=1;i<list.size();i++){
            if(list.get(i)<list.get(i-1)){
                for(int j=0;j<i;j++){
                    if(list.get(j)>list.get(i)){
                        int temp=list.get(j);
                        list.set(j,list.get(i));
                        list.set(i,temp);
                        int left=0,right=i-1;
                        while(left<right){
                            int tem=list.get(left);
                            list.set(left++,list.get(right));
                            list.set(right--,tem);
                        }
                        long result=0;
                        for(int l=list.size()-1;l>=0;l--){
                            result=result*10+list.get(l);
                            if(result>Integer.MAX_VALUE)
                                return -1;
                        }
                        return (int)result;
                    }
                }
            }
        }
        return -1;
        // Write your code here
    }
}
