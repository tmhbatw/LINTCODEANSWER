package LINTCODE16;

import java.util.*;

public class LINTCODE1596 {
    /*Description
    *给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。
    * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
    * 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。
    * 当可以用这种方法将每个人分进两组时，返回 true；否则返回 false。
    * */

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] type=new int[N+1];//用type数组存储每个人的组别信息，其中0代表未标记组别，1表示第一组，2表示第二组
        HashMap<Integer, HashSet<Integer>> map=new HashMap<>();
        for(int[] cur:dislikes){
            HashSet<Integer> set=map.getOrDefault(cur[0],new HashSet<>());
            set.add(cur[1]);
            map.put(cur[0],set);
            HashSet<Integer> set2=map.getOrDefault(cur[1],new HashSet<>());
            set2.add(cur[0]);
            map.put(cur[1],set2);
        }
        for(int i=1;i<=N;i++){
            //当类别为0时证明未分别组类，需要进行分类操作
            if(type[i]==0){
                Queue<Integer> queue=new LinkedList<>();
                queue.add(i);
                type[i]=1;
                while(!queue.isEmpty()){
                    int cur=queue.poll();
                    Set<Integer> set=map.get(cur);
                    int type1=type[cur]==1?2:1;
                    if(set==null)
                        continue;
                    for(int curr:set){
                        if(type[curr]==0){
                            type[curr]=type1;
                            queue.add(curr);
                        }else if(type[curr]!=type1)
                            return false;
                    }
                }
            }
        }
        return true;
        // Write your code here.
    }
}
