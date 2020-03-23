package LINTCODE19;

public class LINTCODE1868 {
    /*Description
    *一个由N个小写英文字母组成的字符串S。将字符串S分割是指把S分为两个非空字符串S1和S2，且S1+S2=S(其中“+”操作符表示字符串连接)。
    * 如果在某一次分割时，S1中不同字母的数量等于S2中不同字母的数量，它就被称为一个“平衡”。请你找出S中有多少个“平衡”。
    * */

    public int find(String S) {
        int[] pre=new int[26];
        int[] last=new int[26];
        int time1=0;
        int time2=0;
        for(int i=0;i<S.length();i++){
            int index=S.charAt(i)-'a';
            pre[index]++;
            if(pre[index]==1)
                time1++;
        }
        int result=0;
        for(int i=S.length()-1;i>=1;i--){
            int index=S.charAt(i)-'a';
            pre[index]--;
            if(pre[index]==0)
                time1--;
            last[index]++;
            if(last[index]==1)
                time2++;
            if(time1==time2)
                result++;
        }
        return result;
        // write your code here
    }


}
