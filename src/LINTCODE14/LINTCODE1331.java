package LINTCODE14;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1331 {
    /*Description
    * 小林是班级的英语课代表，他想开发一款软件来处理班上同学的成绩
    * 小林的软件有一个神奇的功能，能够通过一个百分数来反应你的成绩在班上的位置。“成绩超过班级 …% 的同学”。
    * 设这个百分数为 p，考了 s 分，则可以通过以下式子计算得出 p：
    * p = ( 分数不超过 s 的人数 - 1) / 班级总人数 * 100%
    * 请你设计一下这个软件
    * */

    public List<Integer> englishSoftware(List<Integer> score, List<Integer> ask) {
        int[] result=new int[101];
        for(int cur:score)
            result[cur]++;
        for(int i=1;i<101;i++)
            result[i]+=result[i-1];
        List<Integer> list=new ArrayList<>();
        int studentNumber=score.size();
        for(int cur:ask) {
            list.add((result[score.get(cur-1)] - 1) * 100 / studentNumber);
        }
        return list;
        // write your code here
    }
}
