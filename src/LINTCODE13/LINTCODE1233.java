package LINTCODE13;

import java.util.Arrays;
import java.util.Comparator;

public class LINTCODE1233 {
    /*Description
    *给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
    * 如果字符出现的次数相同，则按照他们的字典序排序。
    * */

    public String frequencySort(String s) {
        int[][] num=new int[128][2];
        for(int i=0;i<128;i++)
            num[i][1]=i;
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)][0]++;
        }
        Arrays.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<128;i++){
            if(num[i][0]==0)
                break;
            while(num[i][0]-->0){
                sb.append((char)(num[i][1]));
            }
        }
        return sb.toString();
        // write your code here
    }
}
