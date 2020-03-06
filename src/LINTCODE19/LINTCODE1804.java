package LINTCODE19;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LINTCODE1804 {
    /*Description
    * 给一个二维数组scores表示每个学生的各科成绩，求出学生中总成绩排名第K的索引。
    * */

    public int FindTheRank(int[][] scores, int K) {
        int studentsNumber=scores.length;
        int courseNumber=scores[0].length;
        int[][] scoreList=new int[studentsNumber][2];
        for(int i=0;i<studentsNumber;i++){
            int sumScore=0;
            for(int num:scores[i])
                sumScore+=num;
            scoreList[i][0]=sumScore;
            scoreList[i][1]=i;
        }
        Arrays.sort(scoreList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        return scoreList[K-1][1];
        // write your code here
    }
}
