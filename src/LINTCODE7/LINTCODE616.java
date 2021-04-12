package LINTCODE7;

import java.util.*;

public class LINTCODE616 {
    /*Description
    * 你需要去上n门九章的课才能获得offer，这些课被标号为 0 到 n-1 。
    * 有一些课程需要“前置课程”，比如如果你要上课程0，你需要先学课程1，我们用一个匹配来表示他们： [0,1]
    * 给你课程的总数量和一些前置课程的需求，返回你为了学完所有课程所安排的学习顺序。
    * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
    * */

    //深度优先遍历会使得栈溢出
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int[] dp=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }
        List<Integer> result=new ArrayList<>();
        for(int[] cur:prerequisites){
            List<Integer> curr=map.get(cur[1]);
            curr.add(cur[0]);
            dp[cur[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(dp[i]==0) {
                q.add(i);
                result.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            List<Integer> list=map.get(cur);
            for(int curr:list){
                dp[curr]--;
                if(dp[curr]==0){
                    q.add(curr);
                    result.add(curr);
                }
            }
        }
        if(result.size()<numCourses)
            return new int[0];
        int[] res=new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            res[i] = result.get(i);
        }
        return res;
        // write your code here
    }

}
