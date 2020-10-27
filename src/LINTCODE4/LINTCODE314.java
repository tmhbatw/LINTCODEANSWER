package LINTCODE4;

import java.util.Arrays;

public class LINTCODE314 {
    /*Description
    * 在即时聊天软件中，如果你在过去3天发送了至少m条消息，那么你会在第三天结束时获得一枚勋章。
    * 现在有一个长度为n的数组record[]，记录了过去n天每天发送的消息数，若record[i]为-1，表
    * 示这一天的记录丢失。现在知道从第三天开始，每天都获得了勋章，请问过去nn天总共最少发送了多少条消息，若无解，则返回-1
    * */

    public int minimumMessages(int m, int[] record) {
        int length=record.length;
        boolean[] reached=new boolean[length];
        for(int i=0;i<record.length;i++) {
            if(record[i]==-1){
                record[i]=0;
                reached[i]=true;
            }
        }
        for(int i=2;i<record.length;i++){
            int cur=record[i-2]+record[i-1]+record[i];
            if(cur<m){
                int j=i;
                while(!reached[j]) {
                    if(j==i-2)
                        return -1;
                    j--;
                }
                record[j]+=m-cur;
            }
        }
        System.out.println(Arrays.toString(record));
        int result=0;
        for(int cur:record)
            result+=cur;
        return result;
        // write your code here
    }
}
