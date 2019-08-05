package LINTCODE7;

import java.util.*;

public class LINTCODE615 {
    /*Description
    * 现在你总共有 n 门课需要选，记为 0 到 n - 1.
    * 一些课程在修之前需要先修另外的一些课程，比如要学习课程 0 你需要先学习课程 1 ，表示为[0,1]
    * 给定n门课以及他们的先决条件，判断是否可能完成所有课程？
    * */

    /*Solution
    *拓扑排序，保留一个入度和出度的概念
    * */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] num=new int[numCourses];
        List<HashSet<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            list.add(new HashSet<>());
        for(int[] cur:prerequisites){
            HashSet<Integer> set=list.get(cur[1]);
            if(!set.contains(cur[0])) {
                set.add(cur[0]);
                num[cur[0]]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        int nums=0;
        for(int i=0;i<numCourses;i++){
            if(num[i]==0){
                queue.add(i);
                nums++;
            }
        }
        while(!queue.isEmpty()){
            int cur=queue.poll();
            Set<Integer> set=list.get(cur);
            Iterator i=set.iterator();
            while(i.hasNext()){
                int ii= (int) i.next();
                num[ii]--;
                if(num[ii]==0) {
                    queue.add(ii);
                    nums++;
                }
            }
        }
        return nums==numCourses;
        // write your code here
    }

/*    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, HashSet<Integer>> map=new HashMap<>(numCourses);
        Map<Integer,HashSet<Integer>> maps=new HashMap<>(numCourses);
        for(int i=0;i<numCourses;i++) {
            map.put(i, new HashSet<>());
            map.put(i,new HashSet<>());
        }
        for(int[] cur:prerequisites){
            HashSet<Integer> set=map.get(cur[0]);
            set.add(cur[1]);
            HashSet<Integer> sets=map.get(cur[1]);
            set.add(cur[0]);
        }
        Queue<Integer> queue=new LinkedList<>();
        int num=0;
        for(HashMap.Entry entry:map.entrySet()){
            HashSet<Integer> set= (HashSet<Integer>) entry.getValue();
            if(set.isEmpty()){
                queue.add((Integer) entry.getKey());
                num++;
            }
        }
        while(!queue.isEmpty()){
            int cur=queue.poll();
            HashSet<Integer> sets=maps.get(cur);
            if(sets.isEmpty())
                continue;
            Iterator i=sets.iterator();
            while(i.hasNext()){
                int reduce= (int) i.next();
                HashSet<Integer> set=map.get(reduce);
                set.remove(cur);
                if(set.isEmpty()) {
                    queue.add(reduce);
                    num++;
                }
            }
        }
        return num==numCourses;
        // write your code here
    }*/
}
