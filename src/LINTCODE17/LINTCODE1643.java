package LINTCODE17;

public class LINTCODE1643 {
    /*Description
    *小红去果园采水果。有2个篮子，可以装无数个水果，但是只能装一种水果。从任意位置的树开始，
    * 往右采。遇到2种情况退出，1. 遇到第三种水果，没有篮子可以放了，2. 到头了。返回可以采摘的最多的水果个数。水果数组用arr表示。
    * */

    public int pickFruits(int[] arr) {
        int[] number=new int[2];
        int[] time=new int[2];
        int start=0;
        int result=0;
        for(int i=0;i<arr.length;i++){
            int cur=arr[i];
            if(cur==number[0]) {
                time[0]++;
                continue;
            }
            if(cur==number[1]){
                time[1]++;
                continue;
            }
            if(number[0]==0){
                number[0]=cur;
                time[0]++;
            }else if(number[1]==0){
                number[1]=cur;
                time[1]++;
            }else{
                result=Math.max(i-start,result);
                while(time[1]>0&&time[0]>0){
                    if(arr[start++]==number[0])
                        time[0]--;
                    else
                        time[1]--;
                }
                if(time[0]==0){
                    number[0]=cur;
                    time[0]=1;
                }else{
                    number[1]=cur;
                    time[1]=1;
                }
            }
        }
        return Math.max(result,arr.length-start);
        // Write your code here.
    }
}
