package LINTCODE15;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LINTCODE1475 {
    /*Description
    * 给出一个非空偶数长度的字符串s，该字符串包含"("、")"和"?"。对于每一个"?"，
    * 我们可以使用"("或者")"来代替，但每一次替代都会付出相应的代价。
    * 替换成"("的代价数组为a，其含义为第i个"?"替换成"("时需要付出的代价为a[i]。同理，替换为")"的代价数组为b，
    * 其含义为第i个"?"替换成")"时需要付出的代价为b[i]。
    * 现在要求替换所有的"?"，使得替换后的括号序列是合法的，输出所需要付出的最小代价为多少？
    * 如果不能得到一个合法括号序列，则输出-1。 一个合法的括号序列要求对于每一个"("，其右边均有")"能与其匹配。
    * */

    public int getAnswer(char[] s, int[] a, int[] b) {
        int res= Arrays.stream(b).sum();

        int cur=0;
        int index=0;
        Queue<Integer> q=new PriorityQueue<>();
        for(int i=0;i<s.length;i++){
            switch (s[i]){
                case '(':
                    cur++;
                    break;
                case ')':
                    cur--;
                    break;
                case '?':
                    cur--;
                    q.add(a[index]-b[index++]);
            }

            if(cur<0){
                if(q.isEmpty())
                    return -1;
                res+=q.poll();
                cur+=2;
            }
        }

        return cur==0?res:-1;
        // Write your code here
    }
}
