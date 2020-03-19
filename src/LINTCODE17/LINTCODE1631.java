package LINTCODE17;

public class LINTCODE1631 {
    /*Description
    * 如果一个子数组中出现的值不超过两个，则该子数组是有趣的。给一个数组a，求其中最长的一个有趣子数组。输出最大的长度。
    * */

    public int maxLen(int[] a) {
        int[] number=new int[2];
        int[] time=new int[2];
        int start=0;
        int result=0;
        for(int i=0;i<a.length;i++){
            int cur=a[i];
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
                    if(a[start++]==number[0])
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
        return Math.max(result,a.length-start);
        // Write your code here
    }
}
